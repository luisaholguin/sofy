/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.Collection;

/**
 *
 * @author Marcelo
 */
public interface CanalesPerfilesDao
{
    public void guardar(int codigoPerfil, int codigoCanal);
    public void modificar(int codigo, int codigoPerfil, int codigoCanal);
    public void borrar (int codigo);
//    public int getCodigoIngrediente (int codIngrediente);
    public Collection getCanalPerfil(int codigoPerfil); //traigo todos los canales pertenecientes a un perfil
    public Collection getAll();
    public void borrarCanales(int codigoPerfil);
}
