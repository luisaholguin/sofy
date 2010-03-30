/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author carolina
 */
public class SensorPeso extends Sensor{
    private  double pesoMaximo;
    private double pesoMinimo;
    private double lectura;
    
public SensorPeso (){
    
}

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public double getPesoMinimo() {
        return pesoMinimo;
    }

    public void setPesoMinimo(double pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    public double getLectura() {
        return lectura;
    }

    public void setLectura(double lectura) {
        this.lectura = lectura;
    }
    

}
