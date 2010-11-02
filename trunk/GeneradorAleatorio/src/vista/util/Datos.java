/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

/**
 *
 * @author Carolina
 */
public class Datos
{

    private String nombreVariable;
    private String distribucion;
    private String parametro1;
    private String parametro2;
    private String parametro3;
    private String semilla;
    private int orden;
    private int cantidad;
    private double[] r;
    private double[] x;
    private double[] a;

    public Datos()
    {
    }

    public String getDistribucion()
    {
        return distribucion;
    }

    public void setDistribucion(String distribucion)
    {
        this.distribucion = distribucion;
    }

    public String getNombreVariable()
    {
        return nombreVariable;
    }

    public void setNombreVariable(String nombreVariable)
    {
        this.nombreVariable = nombreVariable;
    }

    public int getOrden()
    {
        return orden;
    }

    public void setOrden(int orden)
    {
        this.orden = orden;
    }

    public String getParametro1()
    {
        return parametro1;
    }

    public void setParametro1(String parametro1)
    {
        this.parametro1 = parametro1;
    }

    public String getParametro2()
    {
        return parametro2;
    }

    public void setParametro2(String parametro2)
    {
        this.parametro2 = parametro2;
    }

    public String getParametro3()
    {
        return parametro3;
    }

    public void setParametro3(String parametro3)
    {
        this.parametro3 = parametro3;
    }

    public String getSemilla()
    {
        return semilla;
    }

    public void setSemilla(String semilla)
    {
        this.semilla = semilla;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    public double[] getA()
    {
        return a;
    }

    public void setA(double[] a)
    {
        this.a = a;
    }

    public double[] getR()
    {
        return r;
    }

    public void setR(double[] r)
    {
        this.r = r;
    }

    public double[] getX()
    {
        return x;
    }

    public void setX(double[] x)
    {
        this.x = x;
    }

    

}
