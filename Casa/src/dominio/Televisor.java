/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import abstraccionhardware.VentanaSalidaTelevisor;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Administrador
 */
public class Televisor extends Objeto
{
    private VentanaSalidaTelevisor tele;
    private Collection canales;
    private boolean estado;

    public Televisor() {
    }

    public void setTele(VentanaSalidaTelevisor tele) {
        this.tele = tele;
    }

    public Collection getCanales() {
        return canales;
    }

    public void setCanales(Collection canales) 
    {
        this.tele.setCanales(canales);
        this.canales = canales;
    }

    public boolean fijarCanal(int numero)
    {
        boolean bandera = false;
        this.tele.mostrar(numero);
        return bandera;
    }

    public void encender()
    {
        this.estado = true;
        this.tele.setVisible(true);
    }

    public void apagar()
    {
        this.estado = false;
        this.tele.setVisible(false);
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



}
