/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluadores;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author marcelo
 */
public class TestUniformidad
{

    private Vector numeros = new Vector();
    private double[] FX;
    private double[] SNX;
    private double[] DMas;
    private double[] DMenos;

    public TestUniformidad()
    {
    }

    private void crearVectores(int size)
    {
        FX = new double[size];
        SNX = new double[size];
        DMas = new double[size];
        DMenos = new double[size];
    }

    private void ordenar()
    {
        int size = numeros.size();
        for(int i=0; i<size;i++)
        {
            this.FX[i] = Double.parseDouble(String.valueOf(numeros.elementAt(i)));
        }
        Arrays.sort(FX);
    }

    private void calcularSNX()
    {
        int size = numeros.size();
        double j = 1.0;
        for(int i=0; i<size; i++)
        {
            SNX[i] = j/size;
            j++;
        }
    }

    private void calcularDMas()
    {
        int size = numeros.size();
        double aux = 0.0;
        for(int i=0; i<size; i++)
        {
            aux = SNX[i] - FX[i];
            if(aux >= 0)
                DMas[i] = aux;
            else
                DMas[i]=0;
        }
    }

    private void calcularDMenos()
    {
        int size = numeros.size();
        double aux = 0.0;
        for(int i= 0; i<size; i++)
        {
            if((i-1) < 0)
                aux = FX[i];
            else
            {
                aux = FX[i] - SNX[i-1];
                if(aux < 0)
                    aux = 0;
            }
            DMenos[i] = aux;
        }
    }

    private double maximo(double[] vector)
    {
        double maximo = 0.0;
        int size = numeros.size();
        Set hs = new HashSet();
        for(int i=0; i<size; i++)
            hs.add(vector[i]);
        maximo = Double.parseDouble(String.valueOf(Collections.max(hs)));
        return maximo;
    }

    private double calcularEstadistico()
    {
        double alpha = 0.0;
        double aux = 0.0;
        aux = numeros.size();
        aux = Math.sqrt(aux);
        alpha = 1.36/aux;
        return alpha;
    }

    public String test(Vector numeros)
    {
        this.crearVectores(numeros.size());
        this.numeros = numeros;
        String salida = "";
        double maxDMas;
        double maxDMenos;
        double DAlpha = 0.0;
        double D = 0.0;
        this.ordenar();
        this.calcularSNX();
        this.calcularDMas();
        this.calcularDMenos();
        maxDMas = this.maximo(this.DMas);
        maxDMenos = this.maximo(this.DMenos);
        DAlpha = this.calcularEstadistico();
        if(maxDMas > maxDMenos)
            D = maxDMas;
        else
            D = maxDMenos;
        if(D < DAlpha)
            salida = "La secuencia es uniforme con un 95% de certeza, el valor de D es "+D+" y el valor de Dalpha es "+DAlpha;
        else
            salida = "La secuencia no es uniforme, el valor de D es "+D+" y el valor de Dalpha es "+DAlpha;
        return salida;
    }

}
