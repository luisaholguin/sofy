/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import distribuciones.Binomial;
import distribuciones.Erlang;
import distribuciones.Exponencial;
import distribuciones.Normal;
import distribuciones.Poisson;
import distribuciones.Triangular;
import distribuciones.Uniforme;
import distribuciones.Weibull;
import generadores.GeneradorBinomial;
import generadores.GeneradorErlang;
import generadores.GeneradorExponencial;
import generadores.GeneradorNormal;
import generadores.GeneradorPoisson;
import generadores.GeneradorTriangular;
import generadores.GeneradorUniforme;
import generadores.GeneradorWeibull;

/**
 *
 * @author marcelo
 */
public class Test
{

    public Test()
    {
    }

    public void probarUniforme()
    {
//        Uniforme u = new Uniforme();
//        u.setMinimo(1);
//        u.setMaximo(2);
//        Normal n = new Normal();
//        n.setMedia(5);
//        n.setDesviacion(0.5);
//        GeneradorNormal g = new GeneradorNormal(n);
//        Binomial b = new Binomial();
//        b.setN(30);
//        b.setP(0.35);
//        GeneradorBinomial g = new GeneradorBinomial(b);
//        Triangular t = new Triangular();
//        t.setMinimo(1);
//        t.setMaximo(10);
//        t.setMedio(5);
//        GeneradorTriangular g = new GeneradorTriangular(t);
//        Exponencial e = new Exponencial();
//        e.setLambda(0.5);
//        GeneradorExponencial g = new GeneradorExponencial(e);
//        Erlang e = new Erlang();
//        e.setMedia(23);
//        e.setVarianza(5);
//        GeneradorErlang g = new GeneradorErlang(e);
//        Poisson p = new Poisson();
//        p.setMedia(0.33);
//        GeneradorPoisson g = new GeneradorPoisson(p);
        Weibull w = new Weibull();
        w.setAlfa(13);
        w.setBeta(3);
        GeneradorWeibull g = new GeneradorWeibull(w);
        for(int i=1; i<101;i++)
        {
            System.out.println(g.getNumero());
        }
    }

}
