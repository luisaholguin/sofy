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
public interface TemasPerfilesDao {
    public void guardar ( int codPerfil, int codTema);
    public void modificar (int codigo, int codPerfil, int codTema);
    public void borrar (int codigo);
    public int getCodigoPerfil (int codperfil);
    public int getCodigoTema (int CodTema);
    public Collection getAll();
    
}
