/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import javax.swing.JSlider;

/**
 *
 * @author Administrador
 */
public class Luz extends Objeto
{

    private int intensidad;
    private int numeroFoco;
    private JSlider slider;
    private boolean encendida;

    public Luz() {
    }

    public int getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(int intensidad) {
        this.intensidad = intensidad;
    }

    public int getNumeroFoco() {
        return numeroFoco;
    }

    public void setNumeroFoco(int numeroFoco) {
        this.numeroFoco = numeroFoco;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public void apagarLuz()
    {
        this.intensidad = 0;
        this.slider.setValue(0);
        this.encendida = false;//luz apagada
    }

    public void cambiarIntensidad(int valor)
    {
        this.intensidad = valor;
        this.slider.setValue(valor);
        this.encendida = true;
    }

    public boolean isEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }



}
