/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Sensor;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface SensorDao {

    public void guardar(Sensor sensor);
    public void modificar(Sensor sensor);
    public void borrar(Sensor sensor);
    public Sensor get(int id);
    public Collection getAll();

}
