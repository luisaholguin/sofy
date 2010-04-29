/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dominio.Perfil;
import java.util.Collection;

/**
 *
 * @author Marcelo
 */
public interface PerfilInt
{
    public void guardar (Perfil perfil);//guarda un objeto perfil
    public void modificar (Perfil perfil);
    public void borrar (Perfil perfil);
    //public int getCodigoIngrediente (int codIngredient e);
    public int getCodigoReceta (int CodPerfil);
    public Collection getAll();
    public Perfil getPerfil(String nombre);
}
