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
public class Persiana extends Objeto
{
    private int numeroPersiana;
    private boolean estado;// true: abierta, false: cerrada
    private JLabel labelVentana;
    private boolean vertical;

    public Persiana() {
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public JLabel getLabelVentana() {
        return labelVentana;
    }

    public void setLabelVentana(JLabel labelVentana) {
        this.labelVentana = labelVentana;
    }

    public int getNumeroPersiana() {
        return numeroPersiana;
    }

    public void setNumeroPersiana(int numeroPersiana) {
        this.numeroPersiana = numeroPersiana;
    }

    public boolean abrirPersiana()
    {
        ImageIcon i;
        if(this.isVertical())
             i = createImageIcon("/imagenes/Ventana Vertical Abierta.JPG");
        else
             i = createImageIcon("/imagenes/Ventana Horizontal Abierta.JPG");
        ImageIcon tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.labelVentana.getWidth(), this.labelVentana.getHeight(), Image.SCALE_DEFAULT));
        this.labelVentana.setIcon(tmpIcon);
        this.estado = true;
        return true;
    }

    public boolean cerrarPersiana()
    {
        ImageIcon i;
        if(this.isVertical())
            i = createImageIcon("/imagenes/Ventana Vertical Cerrada.JPG");
        else
            i = createImageIcon("/imagenes/Ventana Horizontal Cerrada.JPG");
        ImageIcon tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.labelVentana.getWidth(), this.labelVentana.getHeight(), Image.SCALE_DEFAULT));
        this.labelVentana.setIcon(tmpIcon);
        this.estado = false;
        return false;
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

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }




}
