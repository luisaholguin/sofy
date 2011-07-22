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
public class Temperatura extends Objeto
{
    private JSlider slider;
    private int valor;

    public Temperatura() {
    }

    public JSlider getSlider() {
        return slider;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public int getValor() {
        return valor;
    }

    public boolean cambiarTemperatura(int valor)
    {
        this.valor = valor;
        this.slider.setValue(valor);
        return true;
    }

}
