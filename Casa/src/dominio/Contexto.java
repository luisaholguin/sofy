/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;


/**
 *
 * @author Carolina
 */
public class Contexto
{
    private String contexto;
    private int codigo;
    private int coordenada_xn;
    private int coordenada_xs;
    private int coordenada_yn;
    private int coordenada_ys;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    public int getCoordenada_xn() {
        return coordenada_xn;
    }

    public void setCoordenada_xn(int coordenada_xn) {
        this.coordenada_xn = coordenada_xn;
    }

    public int getCoordenada_xs() {
        return coordenada_xs;
    }

    public void setCoordenada_xs(int coordenada_xs) {
        this.coordenada_xs = coordenada_xs;
    }

    public int getCoordenada_yn() {
        return coordenada_yn;
    }

    public void setCoordenada_yn(int coordenada_yn) {
        this.coordenada_yn = coordenada_yn;
    }

    public int getCoordenada_ys() {
        return coordenada_ys;
    }

    public void setCoordenada_ys(int coordenada_ys) {
        this.coordenada_ys = coordenada_ys;
    }

    public Contexto() {
    }

    public String getParOrdenadoNoroeste()
    {
        return "("+this.getCoordenada_xn()+","+this.getCoordenada_yn()+")";
    }

    public String getParOrdenadoSureste()
    {
        return "("+this.getCoordenada_xs()+","+this.getCoordenada_ys()+")";
    }
}
