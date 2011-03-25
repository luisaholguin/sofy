/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package abstraccionhardware;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JOptionPane;
import player.media.helliker.id3.MP3File;
import sonidos.Sonidos;

/**
 *
 * @author Administrador
 */
public class EmisorAudio
{
    
//    private Playlist playlist;
    private Player player = null;
    private Thread playThread = null;

    public EmisorAudio() {
    }
    
    /**
     * Este metodo emite un sonido de acuerdo al tipo de mensaje que se desea hacer oir.
     *
     * @param mensaje
     * mensaje puede ser:
     * 0 - computadora lista para recibir parametros (ComputadoraLista.mp3)
     *
     */
    public void emitirSonido(int mensaje)
    {
//        System.out.println(path);
//        String titulo = "";
        MP3File mp3File = null;
        Sonidos s = new Sonidos();
        try
        {
            switch(mensaje)
            {
                case 0:
                        URL url = s.getUrl("ComputadoraLista.mp3");
                        String u = url.toURI().getPath();
                        mp3File = new MP3File(u);
                        break;
            }
             
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
//		player.addControllerListener(this);
//		this.jProgressBar.setString("Realizing...");
		player.realize();
                player.start();
//                this.jProgressBar.setString("Playing " + fileTitle);
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
//            this.jProgressBar.setString("Playing " + fileTitle);
	}
    }

    public void errorMessage(String s)
    {
	JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
