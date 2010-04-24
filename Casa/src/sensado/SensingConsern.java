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
    private Lectura ubicacion = new Ubicacion();
    private Lectura vPeso = new Peso();
    private Lectura perfil = new Perfil();

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

    public void setPosicion(int x, int y)
    {
        Posicion p = new Posicion();
        p.setCoordenadaX(x);
        p.setCoordenadaY(y);
        this.posicion = p;
        this.ubicacion.lectura(this);
    }

    

}
