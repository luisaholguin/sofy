/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author carolina
 */
public class SensorTemperatura extends Sensor {
    private double temperaturaMaxima;
    private double temperaturaMinima;
    private double lectura;
    
public SensorTemperatura(){
    
}

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getLectura() {
        return lectura;
    }

    public void setLectura(double lectura) {
        this.lectura = lectura;
    }
    

}
