/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author Carolina
 */
public class Posicion {
    
    private int coordenadaX;
    private int coordenadaY;

    public Posicion(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public Posicion() {
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    

}
