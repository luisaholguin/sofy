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
                        mensaje = "Parametro incorrecto!";
                        break;
                case 2:
                        mensaje = "Nombre de comando incorrecto!";
                        break;
                case 3:
                        mensaje = "Nombre de objeto incorrecto!";
                        break;
                case 4:
                        mensaje = "lo siento, no puedo ejecutar el comando!";
                        break;
                case 5:
                        mensaje = "el estereo esta encendido!";
                        break;
                case 6:
                        mensaje = "el estereo esta apagado!";
                        break;
                case 7:
                        mensaje = "el televisor esta encendido!";
                        break;
                case 8:
                        mensaje = "el televisor esta apagado!";
                        break;
                case 9:
                        mensaje = "Canal no disponible!";
                        break;
                case 10:
                        mensaje = "Cancion no disponible!";
                        break;
            }
        }
        if(tipo.trim().toUpperCase().equals("INF"))
        {
            switch(codigo)
            {
                case 1:
                        mensaje = "Ejecutando comando!";
                        break;
                case 2:
                        mensaje = "¿si?";
                        break;
                case 3:
                        mensaje = "Comando cancelado!!!";
                        break;
            }
        }
        
        
        return mensaje;
    }
    
}
