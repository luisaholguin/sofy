/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contexto;

import dominio.Posicion;

/**
 *
 * @author Marcelo
 */
public interface Subject
{
    public void addObserver(Observer observador);
    public void removeObserver(Observer observador);
    public void notifyObserver(Posicion p);
}
