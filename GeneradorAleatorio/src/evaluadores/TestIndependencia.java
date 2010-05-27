/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluadores;

import java.util.Vector;

/**
 *
 * @author marcelo
 */
public class TestIndependencia
{
    
    private Vector numeros = new Vector();
    private Vector temp = new Vector();
    private int i;
    double z = 0.0;

    public TestIndependencia()
    {
    }


    public String test(Vector numeros)
    {
        this.numeros = numeros;
        this.extraer();
        String respuesta = "";
        
        int M = this.calcularM(this.temp.size());
        z = this.pim(M)/this.spim(M);
        if((z >= -1.96) && (z <= 1.96))
            respuesta = "La secuencia de numeros aleatorios generados para la variable "+String.valueOf(this.numeros.elementAt(0)).trim()+" es independiente " +
                    "\n \n El valor Z para la secuencia es: "+z;
        else
            respuesta = respuesta = "La secuencia de numeros aleatorios generados para la variable "+String.valueOf(this.numeros.elementAt(0)).trim()+" no es independiente " +
                    "\n \n El valor Z para la secuencia es: "+z;
        return respuesta;
    }

    private int calcularM(int n)
    {
        int M = 0;
        i = ((10*n)/100);
        int m = 5;
        M = (((n-i)/m)-1);
        if(M > n)
            M--;
        return M;
    }

    private double sumatoria(int M)
    {
        int j = 0;
        int k = 0;
        int l = 0;
        int m = 5;
        double suma = 0.0;
        for(;k < M;k++)
        {
            j = i+ (k*m);
            l = i + ((k+1)*m);
            suma = suma + (Double.parseDouble(String.valueOf(this.temp.elementAt(j))) * Double.parseDouble(String.valueOf(this.temp.elementAt(l))));
        }

        return suma;
    }

    private double pim(int M)
    {
        double pim = 0.0;
        pim = ((1/(M+1))*this.sumatoria(M)) - 0.25;
        return pim;
    }

    private double spim(int M)
    {
        double spim = 0.0;
        spim = (Math.sqrt((13*M)+7))/(12*(M+1));
        return spim;
    }

    private void extraer()
    {
        int size = this.numeros.size();
        for(int t=0; t < size; t++)
        {
            if(t != 0)
                this.temp.add(this.numeros.elementAt(t));
        }
    }
}
