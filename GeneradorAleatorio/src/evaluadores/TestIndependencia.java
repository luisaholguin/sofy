/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluadores;

import java.util.Vector;

/**
 *
 * @author Carolina
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
            respuesta = "La secuencia de numeros aleatorios generados es independiente " +
                    "\n \n El valor Z para la secuencia es: "+z+" " +
                    "\n El valor de M es: "+M+", el valor de i es: "+i;
        else
            respuesta = "La secuencia de numeros aleatorios generados no es independiente " +
                    "\n \n El valor Z para la secuencia es: "+z+" " +
                    "\n El valor de M es: "+M+", el valor de i es: "+i;
        return respuesta;
    }

    private int calcularM(int n)
    {
        int M = 0;
        i = ((10*n)/100); //comparando a partir del 10% de la muestra
        int m = 5;
        M = (((n-i)/m)-1);
        if(M > n)
            M--;
        return M;
    }

    private double sumatoria(int M)
    {
        int j = 0;
        int ii=i;
        ii--;
        int l = 0;
        int m = 5;
        double suma = 0.0;
        for(int k = 0; k <= M; k++)
        {
            j = ii+ (k*m);
            l = ii + ((k+1)*m);
            suma = suma + (Double.parseDouble(String.valueOf(this.temp.elementAt(j))) * Double.parseDouble(String.valueOf(this.temp.elementAt(l))));
        }
        
        return suma;
    }

    private double pim(int M)
    {
//        double pim = 0.0;
        double pim;
        double suma = this.sumatoria(M);
        double aux = M;
        double div = 1/(aux+1);
        pim = div* suma;
        pim = pim - 0.25;
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
//            if(t != 0)
                this.temp.add(this.numeros.elementAt(t));
        }
    }
}
