/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensado;

import dominio.Posicion;

/**
 *
 * @author Marcelo
 */
public class SensingConsern
{

    private Posicion posicion;
    private double peso;
    private double temperatura;

    public SensingConsern()
    {
    }

    public double getPeso()
    {
        return peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public double getTemperatura()
    {
        return temperatura;
    }

    public void setTemperatura(double temperatura)
    {
        this.temperatura = temperatura;
    }

    public Posicion getPosicion()
    {
        return posicion;
    }

    public void setPosicion(Posicion posicion)
    {
        this.posicion = posicion;
    }

    

}
