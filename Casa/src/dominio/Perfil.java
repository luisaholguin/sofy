/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import contexto.Observer;
import contexto.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import shell.Kernel;

/**
 *
 * @author carolina
 */
public class Perfil extends Objeto implements Subject
{
    private Collection canales = new ArrayList();
    private int intesidadLuz;
    private Collection musica = new ArrayList();
    private Collection receta = new ArrayList();
    private int codigo;
    private EstadoAnimo estadoAnimo;
    private String nombrePerfil;
    private Kernel kernel;
//    private String categoria;
    private String carita;
    private Collection observadores = new ArrayList();

    public Perfil(Kernel kernel) {
        this.kernel = kernel;
    }

    
    
    public String getCarita()
    {
        return carita;
    }

    public void setCarita(String carita)
    {
        this.carita = carita;
    }

//    public String getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(String categoria) {
//        this.categoria = categoria;
//    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombre) {
        this.nombrePerfil = nombre;
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

    public int getIntesidadLuz() {
        return intesidadLuz;
    }

    public void setIntesidadLuz(int intesidadLuz) {
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

    public void addObserver(Observer observador) 
    {
        this.observadores.add(observador);
    }

    public void removeObserver(Observer observador) 
    {
        this.observadores.remove(observador);
    }

    public void notifyObserver(Posicion p) 
    {
        Iterator it = this.observadores.iterator();
        while(it.hasNext())
        {
            Observer o = (Observer)it.next();
            o.update(p);
        }
    }



}
