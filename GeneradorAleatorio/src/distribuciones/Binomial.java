/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package distribuciones;

/**
 *
 * @author marcelo
 */
public class Binomial
{

    private String nombre;
    private int n; //numero de ensayos
    private double p; //probabilidad de exito

    public Binomial()
    {
    }

    public int getN()
    {
        return n;
    }

    public void setN(int n)
    {
        this.n = n;
    }

    public double getP()
    {
        return p;
    }

    public void setP(double p)
    {
        this.p = p;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    


}
