/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author Carolina
 */
public class Peso {
    
    private Contenedor contenedor;
    private double peso;

    public Peso() {
    }

    public Peso(Contenedor contenedor, double peso) {
        this.contenedor = contenedor;
        this.peso = peso;
    }

    public Contenedor getContenedor() {
        return contenedor;
    }

    public double getPeso() {
        return peso;
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

}
