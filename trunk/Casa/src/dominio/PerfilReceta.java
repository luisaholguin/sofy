/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author Marcelo
 */
public class PerfilReceta
{

    private int codigo;
    private int codigoPerfil;
    private int codigoReceta;

    public PerfilReceta()
    {
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public int getCodigoPerfil()
    {
        return codigoPerfil;
    }

    public void setCodigoPerfil(int codigoPerfil)
    {
        this.codigoPerfil = codigoPerfil;
    }

    public int getCodigoReceta()
    {
        return codigoReceta;
    }

    public void setCodigoReceta(int codigoReceta)
    {
        this.codigoReceta = codigoReceta;
    }

    
}
