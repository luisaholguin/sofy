/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.SensorPeso;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface SensorPesoDao {
    public void guardar(SensorPeso sensorPeso);
    public void modificar(SensorPeso sensorPeso);
    public void borrar(SensorPeso sensorPeso);
    public SensorPeso get(int id);
    public Collection getAll();


}
