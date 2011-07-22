/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author marcelo
 */
public class Canal extends Objeto
{
    
    private int codigo;
//    private String nombre;
    private int frecuencia;
    
    public Canal()
    {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

//    @Override
//    public String getNombre()
//    {
//        return super.getNombre();
//    }
//
//    @Override
//    public void setNombre(String nombre)
//    {
//        super.setNombre(nombre);
//    }

  

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

}
