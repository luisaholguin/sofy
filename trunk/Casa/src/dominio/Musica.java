/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author marcelo
 */
public class Musica {
    
    private int codigo;
    private String nombre;
    private String genero;
    private String artista;
    private String path;
    
    public Musica()
    {
        
    }

    public String getArtista()
    {
        return artista;
    }

    public void setArtista(String artista)
    {
        this.artista = artista;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
