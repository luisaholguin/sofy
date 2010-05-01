/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaSalidaMusica.java
 *
 * Created on 22/04/2010, 11:21:35
 */

package habstraccionhardware;

import dominio.Musica;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;
import javax.media.Time;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import player.media.Settings;
import player.media.helliker.id3.ID3v2FormatException;
import player.media.helliker.id3.MP3File;
import player.media.helliker.id3.Playlist;
import player.media.helliker.id3.PlaylistException;
import vista.util.Utils;

/**
 *
 * @author Administrador
 */
public class VentanaSalidaMusica extends javax.swing.JFrame implements Runnable, ControllerListener
{

    private Kernel kernel;
    private Collection temas = new ArrayList();
    private Playlist playlist;
    private Player player = null;
    private String fileTitle = "";
    private Thread playThread = null;

    /** Creates new form VentanaSalidaMusica */
    public VentanaSalidaMusica()
    {
        initComponents();
//        this.cargarImagen();
    }

    /** Creates new form VentanaSalidaMusica */
    public VentanaSalidaMusica(Kernel kernel)
    {
        this.kernel = kernel;
        initComponents();
//        this.cargarImagen();
//        this.centrar();
        this.inicializar();
        Settings.loadSettings();
        playlist = new Playlist();
	File playlistFile = new File(Settings.getPlaylistDirectory(),	Settings.getPlaylistFile());
	if(playlistFile.exists() && playlistFile.isFile())
        {
            this.jProgressBar.setString("Loading Playlist...");
	try
        {
            playlist.loadFromFile(playlistFile);
	}
	catch(IOException ex)
        {
            errorMessage(ex.getMessage());
	}
	catch(PlaylistException ex)
        {
            errorMessage(ex.getMessage());
	}
            this.jProgressBar.setString("");
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new vista.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTemas = new javax.swing.JTable();
        jButtonPlay = new javax.swing.JButton();
        jButtonPause = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonPrevious = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo03.jpg"))); // NOI18N

        jScrollPane1.setBackground(java.awt.SystemColor.desktop);
        jScrollPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jScrollPane1.setOpaque(false);

        jTableTemas.setBackground(java.awt.SystemColor.desktop);
        jTableTemas.setFont(new java.awt.Font("Dungeon", 0, 12)); // NOI18N
        jTableTemas.setForeground(new java.awt.Color(204, 204, 255));
        jTableTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {"asdsad", "asdasd", "asdasd", null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod.", "Nombre", "Artista", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTemas.setGridColor(new java.awt.Color(204, 204, 204));
        jTableTemas.setOpaque(false);
        jTableTemas.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jTableTemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTemasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTemas);

        jButtonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Play16.gif"))); // NOI18N
        jButtonPlay.setContentAreaFilled(false);
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jButtonPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pause16.gif"))); // NOI18N
        jButtonPause.setContentAreaFilled(false);

        jButtonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Stop16.gif"))); // NOI18N
        jButtonStop.setContentAreaFilled(false);
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jButtonPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Previous16.gif"))); // NOI18N
        jButtonPrevious.setContentAreaFilled(false);

        jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Next16.gif"))); // NOI18N
        jButtonNext.setContentAreaFilled(false);

        jProgressBar.setStringPainted(true);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonPlay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPause, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonStop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPrevious, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNext, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonPlayActionPerformed
    {//GEN-HEADEREND:event_jButtonPlayActionPerformed
        // TODO add your handling code here:
//        this.ajustarTamanioColumna();
//        this.play();
}//GEN-LAST:event_jButtonPlayActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonStopActionPerformed
    {//GEN-HEADEREND:event_jButtonStopActionPerformed
        // TODO add your handling code here:
        this.stop();
}//GEN-LAST:event_jButtonStopActionPerformed

    private void jTableTemasMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableTemasMouseClicked
    {//GEN-HEADEREND:event_jTableTemasMouseClicked
        // TODO add your handling code here:
        this.stop();
        Utils u = new Utils();

        this.play(u.agregarBarra(String.valueOf(this.jTableTemas.getValueAt(this.jTableTemas.getSelectedRow(), 3))));
//        this.play("C:\\BAJADOS\\MUSICA\\23 TERROR IN THE DEPTHS OF FOG.MP3");
//        this.play(String.valueOf(this.jTableTemas.getValueAt(this.jTableTemas.getSelectedRow(), 3)));
    }//GEN-LAST:event_jTableTemasMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSalidaMusica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPause;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTemas;
    private vista.Panel panel1;
    // End of variables declaration//GEN-END:variables

    private void inicializar()
    {
        this.centrar();
        this.ajustarTamanioColumna();
    }

    private void centrar()
    {
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
    }


    private void ajustarTamanioColumna()
    {
        TableColumn column = null;
        for (int i = 0; i < 4; i++)
        {
            column = this.jTableTemas.getColumnModel().getColumn(i);
            switch(i)
            {
                case 0:
                        column.setPreferredWidth(32);
//                        System.out.println("El tamaño de la clumna 1 es: "+column.getPreferredWidth());
                        break;
                case 1:
                        column.setPreferredWidth(258);
//                        System.out.println("El tamaño de la clumna 2 es: "+column.getPreferredWidth());
                        break;
                case 2:
                        column.setPreferredWidth(169);
//                        System.out.println("El tamaño de la clumna 3 es: "+column.getPreferredWidth());
                        break;
                case 3:
//                        System.out.println("El tamaño de la clumna 3 es: "+column.getPreferredWidth());
                        column.setPreferredWidth(0);
                        break;
            }
        }
    }



    private void limpiar()
    {
        DefaultTableModel modelo = (DefaultTableModel)this.jTableTemas.getModel();
        while(this.jTableTemas.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }

    private void cargarTemas()
    {
       this.limpiar();
       Iterator it = this.temas.iterator();
       DefaultTableModel modelo = (DefaultTableModel)this.jTableTemas.getModel();
       String[] datos = new String[4];
       while(it.hasNext())
       {
           Musica m = (Musica)it.next();
           datos[0] = String.valueOf(m.getCodigo());
           datos[1] = m.getNombre().trim();
           datos[2] = m.getArtista().trim();
           datos[3] = m.getPath().trim();
           modelo.addRow(datos);
       }
    }

    public void setTemas(Collection temas)
    {
        this.temas = temas;
        this.cargarTemas();
    }


    public Playlist getPlaylist()
    {
	return playlist;
    }
    public void setPlaylist(Playlist p)
    {
	playlist = p;
    }

    public Player getPlayer()
    {
	return player;
    }

    public void errorMessage(String s)
    {
	JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.ERROR_MESSAGE);
    }


    public void play(String path)
    {
//        System.out.println(path);
//        String titulo = "";
        MP3File mp3File = null;
        try
        {
             mp3File = new MP3File(path);
             fileTitle = mp3File.getTitle();
        }
	catch( Exception e )
        {
			// Do nothing, just don't add it
	}
	
//	int position = Settings.getPlaylistPosition();
//	try
//        {
//            mp3File = (MP3File) playlist.get(position);
//            fileTitle = mp3File.getTitle();
//	}
//	catch(ID3v2FormatException ex)
//        {
//            errorMessage(ex.getMessage());
//	}
	if(player == null)
        {
            try
            {
		File file = new File(mp3File.getPath());
		MediaLocator mediaLocator = new MediaLocator(file.toURL());
                player = Manager.createPlayer(mediaLocator);
		player.addControllerListener(this);
		this.jProgressBar.setString("Realizing...");
		player.realize();
                player.start();
                this.jProgressBar.setString("Playing " + fileTitle);
            }
            catch(MalformedURLException ex)
            {
		errorMessage(ex.getMessage());
            }
            catch(NoPlayerException ex)
            {
		errorMessage(ex.getMessage());
            }
            catch(IOException ex)
            {
		errorMessage(ex.getMessage());
            }
	}
	else
        {
            player.start();
            this.jProgressBar.setString("Playing " + fileTitle);
	}
    }

    private void pause()
    {
        if(player != null)
        {
            MP3File mp3File = null;
            int position = Settings.getPlaylistPosition();
            try
            {
                mp3File = (MP3File) playlist.get(position);
		fileTitle = mp3File.getTitle();
		this.jProgressBar.setString( fileTitle + " Paused");
            }
            catch(ID3v2FormatException ex)
            {
                errorMessage(ex.getMessage());
            }
            player.stop();
	}
    }

    public void stop()
    {
        if(player != null)
        {
            player.removeControllerListener(this);
            player.stop();
            player.close();
            player = null;
	}
	if(playThread != null)
        {
            playThread = null;
	}
	this.jProgressBar.setValue(0);
	this.jProgressBar.setString("");
    }

    private void previous()
    {
        int position = Settings.getPlaylistPosition();
	position--;
	if(position < 0)
            position = 0;
	Settings.setPlaylistPosition(position);
	if(player != null)
            stop();
	play("asd");
    }

    private void next()
    {
        int position = Settings.getPlaylistPosition();
	position++;
	if(position >= playlist.size())
        {
            position = 0;
            Settings.setPlaylistPosition(position);
            stop();
            return;
	}
	Settings.setPlaylistPosition(position);
	if(player != null)
            stop();
	play("AS");
    }


    private void playlistAction()
    {
        JFileChooser fileChooser = new JFileChooser(Settings.getPlaylistDirectory());
	fileChooser.setMultiSelectionEnabled(false);
	fileChooser.addChoosableFileFilter(new PlaylistFilter());
	if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            this.jProgressBar.setString("Loading Playlist...");
            playlist = new Playlist();
            try
            {
                File playlistFile = fileChooser.getSelectedFile();
		playlist.loadFromFile(playlistFile);
		Settings.setPlaylistDirectory(playlistFile.getParent());
		Settings.setPlaylistFile(playlistFile.getName());
            }
            catch(IOException ex)
            {
                errorMessage(ex.getMessage());
            }
            catch(PlaylistException ex)
            {
                errorMessage(ex.getMessage());
            }
            this.jProgressBar.setString("");
	}
    }

    public void run()
    {
        while(playThread != null)
        {
            if(player != null)
            {
                Time time = player.getMediaTime();
		this.jProgressBar.setValue((int)time.getSeconds());
		try
                {
                    playThread.sleep(500);
		}
		catch(InterruptedException ex) {}
            }
	}
    }

    public void controllerUpdate(ControllerEvent ev)
    {
        if(ev instanceof RealizeCompleteEvent)
        {
            player.prefetch();
            this.jProgressBar.setString("Prefetching...");
	}
	if(ev instanceof PrefetchCompleteEvent)
        {
            Time time = player.getDuration();
            this.jProgressBar.setMaximum((int) time.getSeconds());
            this.jProgressBar.setString("Playing " + fileTitle);
            playThread = new Thread(this);
            playThread.start();
            player.getGainControl().setLevel(1);
	player.start();
	}
	if(ev instanceof EndOfMediaEvent)
        {
            player.removeControllerListener(this);
            player.stop();
            player.close();
            player = null;
            if(playThread != null)
            {
                playThread = null;
            }
            this.jProgressBar.setValue(0);
            next();
	}
    }


    class PlaylistFilter extends FileFilter
    {
        public boolean accept(File file)
        {
            if(file.isDirectory())
                return true;
            String s = file.getName().toLowerCase();
            if (s.endsWith(".m3u"))
                return true;
	return false;
        }
        public String getDescription()
        {
            return "Playlist Files";
	}
    }

}
