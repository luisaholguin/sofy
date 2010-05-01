package player.media;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import player.media.helliker.id3.ID3v2FormatException;
import player.media.helliker.id3.MP3File;

public class TagEditor extends JDialog implements ActionListener {
	MP3File file;
	JTextField trackNumber,trackTitle,album,artist,comment,composer,copyright,encoded,original,userDefined,year;
	JComboBox genre;
	String [] genres = {"Blues","Classic Rock","Country","Dance","Disco","Funk","General Fiction","Grunge","Hip-Hop","Jazz","Metal","New Age","Oldies","Other","Pop","R&B","Rap","Reggae","Rock","Techno",
		"Industrial","Alternative","Ska","Death Metal","Pranks","Soundtrack","Euro-Techno","Ambient","Trip-Hop","Vocal","Jazz+Funk","Fusion","Trance","Classical","Instrumental","Acid",
		"House","Game","Sound Clip","Gospel","Noise","AlternRock","Bass","Soul","Punk","Space","Meditative","Instrumental Pop","Instrumental Rock","Ethnic","Gothic","Darkwave",
		"Techno-Industrial","Electronic","Pop-Folk","Eurodance","Dream","Southern Rock","Comedy","Cult","Gangsta","Top 40","Christian Rap","Pop/Funk","Jungle","Native American",
		"Cabaret","New Wave","Psychadelic","Rave","Showtunes","Trailer","Lo-Fi","Tribal","Acid Punk","Acid Jazz","Polka","Retro","Musical","Rock & Roll","Hard Rock","Folk","Folk-Rock",
		"National Folk","Swing","Fast Fusion","Bebob","Latin","Revival","Celtic","Bluegrass","Avantgarde","Gothic Rock","Progressive Rock","Psychedelic Rock","Symphonic Rock","Slow Rock",
		"Big Band","Chorus","Easy Listening","Acoustic","Humour","Speech","Chanson","Opera","Chamber Music","Sonata","Symphony","Booty Bass","Primus","Porn Groove","Satire","Slow Jam",
		"Club","Tango","Samba","Folklore","Ballad","Power Ballad","Rhythmic Soul","Freestyle","Duet","Punk Rock","Drum Solo","A capella","Euro-House","Dance Hall"};
	public TagEditor(PlaylistManager p, MP3File f) {
		super(p,"Tag Editor",true);
		getContentPane().setLayout(new GridBagLayout());
		file = f;
		buildGUI();
		populateFields();
		pack();
	}
	private void buildGUI() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(0,1,1,1);
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		getContentPane().add(new JLabel("Track Number: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		trackNumber = new JTextField(3);
		getContentPane().add(trackNumber,gbc);
		gbc.gridy = 1;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Track Title: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		trackTitle = new JTextField(30);
		getContentPane().add(trackTitle,gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Album: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		album = new JTextField(30);
		getContentPane().add(album,gbc);
		gbc.gridy = 3;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Artist: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		artist = new JTextField(30);
		getContentPane().add(artist,gbc);
		gbc.gridy = 4;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Genre: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		genre = new JComboBox(genres);
		getContentPane().add(genre,gbc);
		gbc.gridy = 5;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Comment: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		comment = new JTextField(30);
		getContentPane().add(comment,gbc);
		gbc.gridy = 6;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Composer: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		composer = new JTextField(30);
		getContentPane().add(composer,gbc);
		gbc.gridy = 7;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Copyright Info: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		copyright = new JTextField(30);
		getContentPane().add(copyright,gbc);
		gbc.gridy = 8;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Encoded By: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		encoded = new JTextField(30);
		getContentPane().add(encoded,gbc);
		gbc.gridy = 9;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Original Artist: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		original = new JTextField(30);
		getContentPane().add(original,gbc);
		gbc.gridy = 10;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("URL: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		userDefined = new JTextField(30);
		getContentPane().add(userDefined,gbc);
		gbc.gridy = 11;
		gbc.gridx = 0;
		getContentPane().add(new JLabel("Year: ",SwingConstants.RIGHT),gbc);
		gbc.gridx = GridBagConstraints.RELATIVE;
		year = new JTextField(4);
		getContentPane().add(year,gbc);
		gbc.gridy = 12;
		gbc.gridx = 1;
		JPanel buttonPanel = new JPanel();
		JButton button = new JButton("OK");
		button.addActionListener(this);
		buttonPanel.add(button);
		button = new JButton("Cancel");
		button.addActionListener(this);
		buttonPanel.add(button);
		getContentPane().add(buttonPanel,gbc);
	}
	private void populateFields() {
		try {
			trackNumber.setText(file.getTrack());
			trackTitle.setText(file.getTitle());
			album.setText(file.getAlbum());
			artist.setText(file.getArtist());
			genre.setSelectedItem(file.getGenre());
			comment.setText(file.getComment());
			composer.setText(file.getComposer());
			copyright.setText(file.getCopyrightInfo());
			encoded.setText(file.getEncodedBy());
			original.setText(file.getOriginalArtist());
			userDefined.setText(file.getUserDefinedURL());
			year.setText(file.getYear());
		}
		catch(ID3v2FormatException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent ev) {
		JButton button = (JButton) ev.getSource();
		String command = button.getActionCommand();
		if(command.equals("OK")) {
			try {
				file.setTrack(Integer.parseInt(trackNumber.getText()));
				file.setTitle(trackTitle.getText());
				file.setAlbum(album.getText());
				file.setArtist(artist.getText());
				file.setGenre((String)genre.getSelectedItem());
				file.setComment(comment.getText());
				file.setComposer(composer.getText());
				file.setCopyrightInfo(copyright.getText());
				file.setEncodedBy(encoded.getText());
				file.setOriginalArtist(original.getText());
				file.setUserDefinedURL(userDefined.getText(),userDefined.getText());
				file.setYear(year.getText());
				file.writeTags();
			}
			catch(IOException ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
		dispose();
	}

}
						