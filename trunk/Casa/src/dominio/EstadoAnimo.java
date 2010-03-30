/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author carolina
 */
public class EstadoAnimo {
    private String nombre;
    private double tempMax ;
    private double tempMin;
    private int codigo;
    
public EstadoAnimo (){
    
}

   

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
            

}
