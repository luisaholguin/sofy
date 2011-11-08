/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensado;

import contexto.Observer;
import contexto.Subject;
import controlador.PerfilInt;
import controlador.implementacion.PerfilImp;
import dominio.Posicion;
import shell.Kernel;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Marcelo
 */
public class Perfil implements Lectura, Subject
{

    private Kernel kernel;
    private Collection observadores = new ArrayList();

    public Perfil()
    {
    }

    public Perfil(Kernel kernel)
    {
        this.kernel = kernel;
        this.observadores = new ArrayList();
    }


    

    /**
     * En este metodo se transforma la lectura de la temperatura en un perfil.
     * @param valor
     */
//    public void lectura(SensingConsern valor)
    public void lectura()
    {
//        double temperatura = valor.getTemperatura();
//        PerfilInt sql = new PerfilImp();
//        Collection perfiles = sql.getAll();
//        Iterator it = perfiles.iterator();
//        while(it.hasNext())
//        {
//            dominio.Perfil p = (dominio.Perfil)it.next();
//            if((temperatura <= p.getEstadoAnimo().getTempMax()) && (temperatura >= p.getEstadoAnimo().getTempMin()))
//            {
//                this.kernel.setPerfil(p);
                this.notifyObserver(new Posicion());
//                break;
//            }
//        }
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

    public void lectura(SensingConsern valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
