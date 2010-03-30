/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.SensorArtefacto;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface SensorArtefactoDao {
    public void guardar(SensorArtefacto sensorArtefacto);
    public void modificar(SensorArtefacto sensorArtefacto);
    public void borrar(SensorArtefacto sensorArtefacto);
    public SensorArtefacto get(int id);
    public Collection getAll();


}
