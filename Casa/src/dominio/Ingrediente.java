 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author carolina
 */
public class Ingrediente {
    private Elemento elemento;
    private int cucharadas;
    private double tazas;
    private double peso;
    private int unidades;
    private int codigo;
    private int seleccion;

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }
    
public Ingrediente(){
    
}

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCucharadas() {
        return cucharadas;
    }

    public double getPeso() {
        return peso;
    }

    public double getTazas() {
        return tazas;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setCucharadas(int cucharadas) {
        this.cucharadas = cucharadas;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTazas(double tazas) {
        this.tazas = tazas;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

 

}
