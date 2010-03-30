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
public interface RecetasPerfilesDao
{
    public void guardar ( int codReceta, int codPerfil);
    public void modificar (int codigo, int codReceta, int codPerfil);
    public void borrar (int codigo);
    public int getCodigoPerfil (int codPerfil);
    public int getCodigoReceta (int CodReceta);
    public Collection getAll();

}
