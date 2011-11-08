/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package abstraccionhardware;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.speech.*;
import javax.speech.synthesis.*;
import javax.swing.JOptionPane;
import servicios.player.media.helliker.id3.MP3File;
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
    private SynthesizerModeDesc required;
    private Voice voice;
    private Synthesizer synth;

    public EmisorAudio() 
    {
        try {
            required = new SynthesizerModeDesc();
            required.setLocale(new Locale("es", "es"));

            voice= new Voice(null, Voice.GENDER_FEMALE, Voice.GENDER_FEMALE, null);

           // Voice v = new Voice();
            required.addVoice(voice);

            synth = Central.createSynthesizer(null);

            synth.allocate();
            synth.resume();
        } catch (Exception ex) 
        {
            Logger.getLogger(EmisorAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este metodo emite un sonido de acuerdo al tipo de mensaje que se desea hacer oir.
     *
     * @param mensaje
     * mensaje puede ser:
     * 0 - computadora lista para recibir parametros (ComputadoraLista.mp3)
     *
     */
    public void emitirMensaje(String mensaje)
    {
        try 
        {
             synth.speakPlainText(mensaje,null);

             synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
//             synth.deallocate();
//             synth.allocate();
//             synth.resume();
        } catch (Exception ex) 
        {
            Logger.getLogger(EmisorAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
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
