/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensado;

import contexto.Observer;
import contexto.Subject;
import dominio.Posicion;
import habstraccionhardware.Kernel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Marcelo
 */
public class Peso implements Lectura, Subject
{
    private Kernel kernel;
    private Collection observadores;

    public Peso()
    {
    }

    public Peso(Kernel kernel)
    {
        this.kernel = kernel;
        this.observadores = new ArrayList();
    }



    public void lectura(SensingConsern valor)
    {
        this.notifyObserver(new Posicion());
    }

    public void addObserver(Observer observador)
    {
        this.observadores.add(observador);
    }

    public void removeObserver(Observer observador)
    {
        this.observadores.remove(observador);
    }

    public void notifyObserver(Posicion p)
    {
        Iterator it = this.observadores.iterator();
        while(it.hasNext())
        {
            Observer o = (Observer)it.next();
            o.update(p);
        }
    }

}
