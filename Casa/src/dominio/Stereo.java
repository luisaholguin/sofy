/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import abstraccionhardware.VentanaSalidaMusica;
import java.util.Collection;

/**
 *
 * @author Administrador
 */
public class Stereo extends Objeto
{

    private VentanaSalidaMusica ventana;
    private Collection canciones;
    private boolean estado;

    public Stereo() {
    }

    public Collection getCanciones() {
        return canciones;
    }

    public void setCanciones(Collection canciones) {
        this.canciones = canciones;
        this.ventana.setTemas(canciones);
    }

    public boolean isEstado() {
        return estado;
    }

    public void encender(boolean estado)
    {
        this.estado = estado;
    }

    public void apagar(boolean estado)
    {
        this.estado = estado;
    }

    public void setVentana(VentanaSalidaMusica ventana) {
        this.ventana = ventana;
    }



}
