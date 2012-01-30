/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contexto;

import dominio.Posicion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Marcelo
 */
public class ActualizadorContexto implements Subject
{
    private Collection observadores;
    private Posicion p;

    public ActualizadorContexto()
    {
        observadores = new ArrayList();
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
//            System.out.println("Coordenadas: X-"+p.getCoordenadaX()+" Y-"+p.getCoordenadaY());
            Observer o = (Observer)it.next();
            o.update(p);
        }
    }

}
