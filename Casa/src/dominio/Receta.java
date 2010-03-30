/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author carolina
 */
public class Receta {
    private String nombre;
    private String categoria;
    private String tiempoPreparado;
    private String instrucciones;
    private Collection ingrediente = new ArrayList();
    private int codigo;
    private int calorias;
    private int porciones;
    
public Receta (){
        
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String gettiempoPreparado() {
        return tiempoPreparado;
    }

    public void settiempoPreparado(String tiempoPreparado) {
        this.tiempoPreparado = tiempoPreparado;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Collection getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Collection ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCalorias() {
        return calorias;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }


}
