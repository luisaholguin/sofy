/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.salida;

import abstraccionhardware.EmisorAudio;

/**
 *
 * @author Administrator
 */
public class Decodificador 
{
    private EmisorAudio emisor;
    

    public Decodificador() 
    {
    }

    public Decodificador(EmisorAudio emisor) 
    {
        this.emisor = emisor;
    }
    
    
    
    public void emitirMensaje(String tipo, int codigo)
    {
        this.emisor.emitirMensaje(this.getMensaje(tipo, codigo));
    }
    
    private String getMensaje(String tipo, int codigo)
    {
        String mensaje = "";
        if(tipo.trim().toUpperCase().equals("ERR"))
        {
            switch(codigo)
            {
                case 1:
                        mensaje = "Incorrect Parameter!";
                        break;
                case 2:
                        mensaje = "Incorrect name of command!";
                        break;
                case 3:
                        mensaje = "incorrect name of object!";
                        break;
                case 4:
                        mensaje = "i can not execute this command!";
                        break;
                case 5:
                        mensaje = "the stereo is on!";
                        break;
                case 6:
                        mensaje = "the estereo is off!";
                        break;
                case 7:
                        mensaje = "the tv is on!";
                        break;
                case 8:
                        mensaje = "the tv is off!";
                        break;
                case 9:
                        mensaje = "The channel is not available!";
                        break;
                case 10:
                        mensaje = "The song is not available!";
                        break;
            }
        }
        if(tipo.trim().toUpperCase().equals("INF"))
        {
            switch(codigo)
            {
                case 1:
                        mensaje = "Executing command!";
                        break;
                case 2:
                        mensaje = "yes?";
                        break;
                case 3:
                        mensaje = "Command canceled!!!";
                        break;
            }
        }
        
        
        return mensaje;
    }
    
}
