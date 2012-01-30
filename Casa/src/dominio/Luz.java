/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import vista.Panel;
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
    private Panel panel;

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
//        System.out.println("Apagando la luz");
        this.intensidad = 0;
        this.slider.setValue(0);
        this.encendida = false;//luz apagada
        this.panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iluminacionCero.jpg")));
        this.panel.repaint();
    }
    
    public void prenderLuz(String imagen)
    {
        this.intensidad = 100;
        this.slider.setValue(intensidad);
        this.encendida = true;
        this.panel.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagen)));
        this.panel.repaint();
    }

    public void cambiarIntensidad(int valor)
    {
        this.intensidad = valor;
        this.slider.setValue(valor);
        if(valor == 0)
            this.apagarLuz();
        else
            this.setEncendida(true);
    }

    public boolean isEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }



}
