/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author carolina
 */
public class Perfil {
    private Collection canales = new ArrayList();
    private double intesidadLuz;
    private Collection musica = new ArrayList();
    private Collection receta = new ArrayList();
    private int codigo;
    private EstadoAnimo estadoAnimo;
    private String nombre;
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EstadoAnimo getEstadoAnimo() {
        return estadoAnimo;
    }

    public void setEstadoAnimo(EstadoAnimo estadoAnimo) {
        this.estadoAnimo = estadoAnimo;
    }
    
    
public Perfil(){
    
}

    public Collection getCanales() {
        return canales;
    }

    public void setCanales(Collection canales) {
        this.canales = canales;
    }

    public double getIntesidadLuz() {
        return intesidadLuz;
    }

    public void setIntesidadLuz(double intesidadLuz) {
        this.intesidadLuz = intesidadLuz;
    }

    public Collection getMusica() {
        return musica;
    }

    public void setMusica(Collection musica) {
        this.musica = musica;
    }

    public Collection getReceta() {
        return receta;
    }

    public void setReceta(Collection receta) {
        this.receta = receta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }



}
