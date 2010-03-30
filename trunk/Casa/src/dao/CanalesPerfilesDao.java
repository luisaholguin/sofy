/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface CanalesPerfilesDao
{
     public void guardar ( int codCanal, int codPerfil);
    public void modificar (int codigo, int codCanal, int codPerfil);
    public void borrar (int codigo);
    public int getCodigoCanal (int codCanal);
    public int getCodigoPerfil (int CodPerfil);
    public Collection getAll();


}
