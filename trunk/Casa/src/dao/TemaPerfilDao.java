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
public interface TemaPerfilDao
{
    public void guardar(int codigoPerfil, int codigoTema);
    public void modificar(int codigo, int codigoPerfil, int codigoTema);
    public void borrar (int codigo);
//    public int getCodigoIngrediente (int codIngrediente);
    public Collection getTemaPerfil(int codigoPerfil);// trae todos los temas asociados a un perfil
    public Collection getAll();
    public void borrarTemas(int codigoPerfil);
}
