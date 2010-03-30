/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.EstadoAnimo;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface EstadoAnimDao {
    public void guardar(EstadoAnimo estadoAnimo);
    public void modificar(EstadoAnimo estadoAnimo);
    public void borrar(EstadoAnimo estadoAnimo);
    public EstadoAnimo get(int id);
    public Collection getAll();


}
