/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author Administrador
 */
public class Comando
{

    private int id;
    private String nombre;
    private String objeto;
    private String parmetro;

    public Comando() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getParmetro() {
        return parmetro;
    }

    public void setParmetro(String parmetro) {
        this.parmetro = parmetro;
    }

    

}
