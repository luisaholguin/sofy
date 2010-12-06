/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

/**
 *
 * @author Carolina
 */
public class GeneradorCongruencial
{
    private double semilla = 1;
    private double a = 6;
    private double m = 13;
    private double b = 0;

    public GeneradorCongruencial()
    {
    }

    public GeneradorCongruencial(double semilla, double a, double m, double b) {
        this.semilla = semilla;
        this.a = a;
        this.m = m;
        this.b = b;
    }



    public double nextDouble()
    {
        this.semilla = ((semilla*a)+b)%m;
        return this.semilla;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double getSemilla() {
        return semilla;
    }

    public void setSemilla(double semilla) {
        this.semilla = semilla;
    }

    

}
