/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.SensorTemperatura;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface SensorTemperaturaDao {
    public void guardar(SensorTemperatura sensorTemperatura);
    public void modificar(SensorTemperatura sensorTemperatura);
    public void borrar(SensorTemperatura sensorTemperatura);
    public SensorTemperatura  get(int id);
    public Collection getAll();


}
