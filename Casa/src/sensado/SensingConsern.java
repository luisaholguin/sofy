/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensado;

import dominio.Posicion;
import shell.Kernel;

/**
 *
 * @author Marcelo
 */
public class SensingConsern
{

    private Posicion posicion = new Posicion();
    private double peso;
    private double temperatura;
    private Kernel kernel;
    private Lectura ubicacion;
    private Lectura vPeso;
    private Lectura perfil;

    public SensingConsern()
    {

    }

    public SensingConsern(Kernel kernel)
    {
        this.kernel = kernel;
//        this.ubicacion = new Ubicacion(kernel);
        this.ubicacion = kernel.getUbicacion();
        this.vPeso = new Peso(kernel);
        this.perfil = this.kernel.getSensorPerfil();
    }


    public double getPeso()
    {
        return peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
        this.vPeso.lectura(this);
    }

    public double getTemperatura()
    {
        return temperatura;
    }

    public void setTemperatura(double temperatura)
    {
        this.temperatura = temperatura;
        this.perfil.lectura(this);
    }

    public Posicion getPosicion()
    {
        return posicion;
    }

    public void setPosicion(int x, int y)
    {
        this.posicion.setCoordenadaX(x);
        this.posicion.setCoordenadaY(y);
        this.ubicacion.lectura(this);
    }

    

}
