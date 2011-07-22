/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import abstraccionhardware.VentanaPrincipal;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Administrador
 */
public class Puerta extends Objeto
{

    private int numeroPuerta;
    private boolean estado; //true: puerta abierta, false: puerta cerrada
    private int forma;
    private JLabel labelPuerta;

    public Puerta()
    {
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public JLabel getLabelPuerta() {
        return labelPuerta;
    }

    public void setLabelPuerta(JLabel labelPuerta) {
        this.labelPuerta = labelPuerta;
    }

    public int getNumeroPuerta() {
        return numeroPuerta;
    }

    public void setNumeroPuerta(int numeroPuerta) {
        this.numeroPuerta = numeroPuerta;
    }

    public boolean abrirPuerta()
    {
        ImageIcon i = new ImageIcon();

        switch(this.forma)
        {
            case 1:
                    i = createImageIcon("/imagenes/Puerta Arriba Abierta.jpg");
                    break;
            case 2:
                    i = createImageIcon("/imagenes/Puerta Izquierda Abierta.jpg");
                    break;
            case 3:
                    i = createImageIcon("/imagenes/Puerta Abajo Abierta.jpg");
                    break;
            case 4:
                    i = createImageIcon("/imagenes/Puerta Doble Abierta.jpg");
                    break;
        }

        ImageIcon tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.labelPuerta.getWidth(), this.labelPuerta.getHeight(), Image.SCALE_DEFAULT));
        this.labelPuerta.setIcon(tmpIcon);
        this.estado = true;
        return estado;
    }

    public boolean cerrarPuerta()
    {
        ImageIcon i = new ImageIcon();
        switch(this.forma)
        {
            case 1:
                    i = createImageIcon("/imagenes/Puerta Arriba Cerrada.jpg");
                    break;
            case 2:
                    i = createImageIcon("/imagenes/Puerta Izquierda Cerrada.jpg");
                    break;
            case 3:
                    i = createImageIcon("/imagenes/Puerta Abajo Cerrada.jpg");
                    break;
            case 4:
                    i = createImageIcon("/imagenes/Puerta Doble Cerrada.jpg");
                    break;
        }

        ImageIcon tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.labelPuerta.getWidth(), this.labelPuerta.getHeight(), Image.SCALE_DEFAULT));
        this.labelPuerta.setIcon(tmpIcon);
        this.estado = false;
        return estado;
    }


    protected static ImageIcon createImageIcon(String path)
    {
        //FrmLogin es el nombre de la clase
        java.net.URL imgURL = VentanaPrincipal.class.getResource(path);
//        System.out.println("Path:" + imgURL.getPath());
        if (imgURL != null)
            return new ImageIcon(imgURL);
        else
            return null;
    }

    public int getForma() {
        return forma;
    }

    public void setForma(int forma) {
        this.forma = forma;
    }



}
