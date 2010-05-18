package player.media;

import abstraccionhardware.VentanaSalidaMusica;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import player.media.helliker.id3.ID3v2FormatException;
import player.media.helliker.id3.MP3File;
import player.media.helliker.id3.NoMPEGFramesException;
import player.media.helliker.id3.Playlist;
//import media.helliker.id3.ID3v2FormatException;
//import media.helliker.id3.MP3File;
//import media.helliker.id3.NoMPEGFramesException;
//import media.helliker.id3.Playlist;
//import vista.JavaPlayer;

public class PlaylistManager extends JDialog implements ActionListener, DropTargetListener,MouseListener {
	private VentanaSalidaMusica player;
	private Playlist playlist;
	private Vector columns;
	private DefaultTableModel model;
	private JTable table;
	private int[] columnWidth = {75,100,300,300,300,75}; 
	public PlaylistManager(VentanaSalidaMusica p) {
		super();
		setTitle("Playlist Manager");
		setModal(true);
		setBounds(Settings.getManagerRect());
		setJMenuBar(buildMenu());
		player = p;
		playlist = player.getPlaylist();
		columns = new Vector();
		columns.addElement("Number");
		columns.addElement("Track Number");
		columns.addElement("Track Title");
		columns.addElement("Album");
		columns.addElement("Artist");
		columns.addElement("Time");
		model = new DefaultTableModel(columns,0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		for(int i=0;i<columns.size();i++) {
			TableColumn column = table.getColumn((String) columns.elementAt(i));
			column.setPreferredWidth(columnWidth[i]);
		}
		table.getTableHeader().setResizingAllowed(false);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
		for(int i=0;i<playlist.size();i++)
			addToTable((MP3File) playlist.get(i),i+1);
		table.setDropTarget(new DropTarget(table,this));
		table.getTableHeader().setDropTarget(new DropTarget(table.getTableHeader(),this));
		getJMenuBar().setDropTarget(new DropTarget(getJMenuBar(),this));
		setDropTarget(new DropTarget(this,this));
	}
	private JMenuBar buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("Save As");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		JMenu optionMenu = new JMenu("Save Option");
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem musicMatch = new JRadioButtonMenuItem("MusicMatch Format");
		group.add(musicMatch);
		musicMatch.setSelected(!Settings.getWinampFormat());
		musicMatch.addActionListener(this);
		optionMenu.add(musicMatch);
		JRadioButtonMenuItem winamp = new JRadioButtonMenuItem("Winamp Format");
		group.add(winamp);
		winamp.setSelected(Settings.getWinampFormat());
		winamp.addActionListener(this);
		optionMenu.add(winamp);
		menu.add(optionMenu);
		menu.addSeparator();
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);
		menu = new JMenu("Edit");
		menuItem = new JMenuItem("Add Files");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("Add Directory");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Edit Tags");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Remove File");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);
		return menuBar;
	}
	private void addToTable(MP3File mp3File, int pos) {
		try {
			Vector row = new Vector();
			row.addElement(new Integer(pos));
			row.addElement(mp3File.getTrack());
			row.addElement(mp3File.getTitle());
			row.addElement(mp3File.getAlbum());
			row.addElement(mp3File.getArtist());
			row.addElement(mp3File.getPlayingTimeString());
			model.addRow(row);
		}
		catch(ID3v2FormatException ex) {
			player.errorMessage(ex.getMessage());
		}
	}
	private void scanDirectory(File dir) {
		try {
			Playlist pl = new Playlist();
			pl.loadFromDirectory(dir,true);
			for(int i=0;i<pl.size();i++) {
				MP3File mp3 = (MP3File)pl.get(i);
				playlist.add(mp3);
				addToTable(mp3,model.getRowCount()+1);
			}
		}
		catch(IOException ex) {
			player.errorMessage(ex.getMessage());
		}
	}
	private void saveAs() {
		JFileChooser fileChooser = new JFileChooser(Settings.getPlaylistDirectory());
		fileChooser.addChoosableFileFilter(new PlaylistFilter());
		fileChooser.setMultiSelectionEnabled(false);
		if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String path = file.getParent();
			Settings.setPlaylistDirectory(path);
			String name = file.getName();
			if(!name.endsWith(".m3u"))
				name = name + ".m3u";
			file = new File(path,name);
			savePlaylist(file);
			Settings.setPlaylistDirectory(file.getParent());
			Settings.setPlaylistFile(file.getName());
		}
	}
	private void savePlaylist(File file) {
		try {
			playlist.writeToFile(file);
		}
		catch(IOException ex) {
			player.errorMessage(ex.getMessage());
		}
	}
	public void actionPerformed(ActionEvent ev) {
		JMenuItem menuItem = (JMenuItem) ev.getSource();
		String command = menuItem.getActionCommand();
		if(command.equals("New")) {
			playlist.clear();
			model.setRowCount(0);
			Settings.setPlaylistDirectory("");
			Settings.setPlaylistFile("");
			Settings.setPlaylistPosition(0);
		}
		else if(command.equals("Save")) {
			File playlistFile = new File(Settings.getPlaylistDirectory(),	Settings.getPlaylistFile());
			if(playlistFile.exists() && playlistFile.isFile())
				savePlaylist(playlistFile);
			else
				saveAs();
		}
		else if(command.equals("Save As")) {
			saveAs();
		}
		else if(command.equals("Winamp Format")) {
			Settings.setWinampFormat(true);
		}
		else if(command.equals("MusicMatch Format")) {
			Settings.setWinampFormat(false);
		}
		else if(command.equals("Exit")) {
			Settings.setManagerRect(getBounds());
			player.setPlaylist(playlist);
			dispose();
		}
		else if(command.equals("Add Files")) {
			JFileChooser fileChooser = new JFileChooser(Settings.getOpenDirectory());
			fileChooser.addChoosableFileFilter(new MP3Filter());
			fileChooser.setMultiSelectionEnabled(true);
			if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File[] files = fileChooser.getSelectedFiles();
				for(int i=0;i<files.length;i++)
                                {
					if(files[i].exists())
                                        {
						Settings.setOpenDirectory(files[i].getParent());
						try
                                                {
							MP3File file = new MP3File(files[i],MP3File.BOTH_TAGS);
							playlist.add(file);
							addToTable(file,model.getRowCount()+1);
						}
						catch(ID3v2FormatException ex) {
							player.errorMessage(ex.getMessage());
						}
						catch(IOException ex) {
							player.errorMessage(ex.getMessage());
						}
						catch(NoMPEGFramesException ex) {
							player.errorMessage(ex.getMessage());
						}
					}
				}
			}
		}
		else if(command.equals("Add Directory")) {
			JFileChooser fileChooser = new JFileChooser(Settings.getOpenDirectory());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setMultiSelectionEnabled(true);
			if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File[] files = fileChooser.getSelectedFiles();
				for(int i=0;i<files.length;i++) {
					if(files[i].exists()) {
						Settings.setOpenDirectory(files[i].getParent());
						scanDirectory(files[i]);
					}
				}
			}
		}
		else if(command.equals("Edit Tags")) {
			ListSelectionModel lsm = table.getSelectionModel();
			if (!lsm.isSelectionEmpty()) {
				 int selectedRow = lsm.getMinSelectionIndex();
				MP3File file = (MP3File) playlist.get(selectedRow);
				TagEditor tagEditor = new TagEditor(this,file);
				tagEditor.setVisible(true);
				playlist.set(selectedRow,file);
				try {
					Vector row = new Vector();
					row.addElement(new Integer(selectedRow+1));
					row.addElement(file.getTrack());
					row.addElement(file.getTitle());
					row.addElement(file.getAlbum());
					row.addElement(file.getArtist());
					row.addElement(file.getPlayingTimeString());
					model.insertRow(selectedRow,row);
					model.removeRow(selectedRow+1);
				}
				catch(ID3v2FormatException ex) {
					player.errorMessage(ex.getMessage());
				}
			}
		}
		else if(command.equals("Remove File")) {
			int row = table.getSelectedRow();
			if(row != -1) {
				model.removeRow(row);
				playlist.remove(row);
			}
		}
	}
	public void drop(DropTargetDropEvent ev) {
		DropTargetContext targetContext = ev.getDropTargetContext();
		boolean outcome = false;
		ev.acceptDrop(DnDConstants.ACTION_COPY);
		List dataFlavors = ev.getCurrentDataFlavorsAsList();
		Transferable t = ev.getTransferable();
		for (int i = 0; i < dataFlavors.size(); i++) {
			try {
				DataFlavor flavor = (DataFlavor) dataFlavors.get(i);
				if(flavor.isFlavorJavaFileListType()) {
					List list = (List) t.getTransferData(flavor);
					for(int j=0;j<list.size();j++) {
						File file = (File) list.get(j);
						if(file.isDirectory()) {
							scanDirectory(file);
						}
						else if(file.getName().toLowerCase().endsWith(".mp3")) {
							try {
								MP3File mp3File = new MP3File(file);
								playlist.add(mp3File);
								addToTable(mp3File,playlist.size());
							}
							catch(ID3v2FormatException ex) {
								player.errorMessage(ex.getMessage());
							}
							catch(NoMPEGFramesException ex) {
								player.errorMessage(ex.getMessage());
							}
						}
					}
				}
				outcome = true;
			}
			catch (IOException ex) {
				player.errorMessage(ex.getMessage());
			}
			catch (UnsupportedFlavorException ex) {
				player.errorMessage(ex.getMessage());
			}
		}
		targetContext.dropComplete(outcome);
    	}
	public void dropActionChanged(DropTargetDragEvent ev){}
	public void dragOver(DropTargetDragEvent ev){}
	public void dragEnter(DropTargetDragEvent ev){}
	public void dragExit(DropTargetEvent ev) {}
	public void mouseClicked(MouseEvent ev) {
		if(ev.getClickCount() == 2) {
			int row = table.rowAtPoint(ev.getPoint());
			if(row != -1) {
				Settings.setPlaylistPosition(row);
				if(player.getPlayer() != null)
					player.stop();
				player.play("");
			}
		}
	}
	public void mousePressed(MouseEvent ev) {}
	public void mouseExited(MouseEvent ev) {}
	public void mouseEntered(MouseEvent ev) {}
	public void mouseReleased(MouseEvent ev) {}
	class MP3Filter extends FileFilter implements FilenameFilter{
		public boolean accept(File dir, String name) {
			String s = name.toLowerCase();
			if (s.endsWith(".mp3"))
				return true;
			File file = new File(dir,name);
			if(file.exists() && file.isDirectory())
				return true;
			return false;
		}
		public boolean accept(File file) {
			if(file.isDirectory())
				return true;
			String s = file.getName().toLowerCase();
			if (s.endsWith(".mp3"))
				return true;
			return false;
		}
		public String getDescription() {
			return "MP3 Files";
		}
	}
	class PlaylistFilter extends FileFilter{
		public boolean accept(File file) {
			if(file.isDirectory())
				return true;
			String s = file.getName().toLowerCase();
			if (s.endsWith(".m3u"))
				return true;
			return false;
		}
		public String getDescription() {
			return "Playlist Files";
		}
			
	}
}														