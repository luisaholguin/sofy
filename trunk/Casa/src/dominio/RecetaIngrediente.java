/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author Marcelo
 */
public class RecetaIngrediente
{

    private int codigo;
    private int codigoReceta;
    private int codigoIngrediente;

    public RecetaIngrediente()
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



    public int getCodigoIngrediente()
    {
        return codigoIngrediente;
    }

    public void setCodigoIngrediente(int codigoIngrediente)
    {
        this.codigoIngrediente = codigoIngrediente;
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
