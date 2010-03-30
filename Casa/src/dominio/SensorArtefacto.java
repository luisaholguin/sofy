/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author carolina
 */
public class SensorArtefacto extends Sensor {
    private double distanciaMaxima;
    private double distanciaMinima;
    private double lectura;

public SensorArtefacto() {
    
}

    public double getDistanciaMaxima() {
        return distanciaMaxima;
    }

    public void setDistanciaMaxima(double distanciaMaxima) {
        this.distanciaMaxima = distanciaMaxima;
    }

    public double getDistanciaMinima() {
        return distanciaMinima;
    }

    public void setDistanciaMinima(double distanciaMinima) {
        this.distanciaMinima = distanciaMinima;
    }

    public double getLectura() {
        return lectura;
    }

    public void setLectura(double lectura) {
        this.lectura = lectura;
    }


}    