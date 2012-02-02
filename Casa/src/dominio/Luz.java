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
    private boolean estado;
    private Panel panel;
    private String imagen;

    public Luz() {
    }

    @Override
    public int getIntensidad() {
        return intensidad;
    }

    @Override
    public void setIntensidad(int intensidad) 
    {
        this.intensidad = intensidad;
        if(intensidad == 0)
            this.apagarLuz();
        else
        {
            this.slider.setValue(intensidad);
            this.estado = true;
            this.panel.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagen)));
            this.panel.repaint();
        }
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

    private void apagarLuz()
    {
//        System.out.println("Apagando la luz");
        this.intensidad = 0;
        this.slider.setValue(0);
        this.estado = false;//luz apagada
        this.panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iluminacionCero.jpg")));
        this.panel.repaint();
    }
    
    private void prenderLuz()
    {
        this.intensidad = 100;
        this.slider.setValue(intensidad);
        this.estado = true;
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
            this.setEstado(true);
    }

    @Override
    public boolean isEstado() {
        return estado;
    }

    @Override
    public void setEstado(boolean encendida) 
    {
        this.estado = encendida;
        if(estado)
            this.prenderLuz();
        else
            this.apagarLuz();
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }



}
