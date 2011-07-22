/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author marcelo
 */
public class Cancion extends Objeto
{
    
    private int codigo;
//    private String nombre;
    private String genero;
    private String artista;
    private String path;
    
    public Cancion()
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

//    @Override
//    public String getNombre() {
//        return super.getNombre();
//    }
//
//    @Override
//    public void setNombre(String nombre) {
//        super.setNombre(nombre);
//    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
