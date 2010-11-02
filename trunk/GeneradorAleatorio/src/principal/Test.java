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
import evaluadores.TestIndependencia;
import generadores.GeneradorBinomial;
import generadores.GeneradorErlang;
import generadores.GeneradorExponencial;
import generadores.GeneradorNormal;
import generadores.GeneradorPoisson;
import generadores.GeneradorTriangular;
import generadores.GeneradorUniforme;
import generadores.GeneradorWeibull;
import java.util.Vector;

/**
 *
 * @author Carolina
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
//        Weibull w = new Weibul
        Vector v = new Vector();
        v.add("prueba");
        v.add(0.12);
        v.add(0.01);
        v.add(0.23);
        v.add(0.28);
        v.add(0.89);
        v.add(0.31);
        v.add(0.64);
        v.add(0.28);
        v.add(0.83);
        v.add(0.93);
        v.add(0.99);
        v.add(0.15);
        v.add(0.33);
        v.add(0.35);
        v.add(0.91);
        v.add(0.41);
        v.add(0.6);
        v.add(0.27);
        v.add(0.75);
        v.add(0.88);
        v.add(0.68);
        v.add(0.49);
        v.add(0.05);
        v.add(0.43);
        v.add(0.95);
        v.add(0.58);
        v.add(0.19);
        v.add(0.36);
        v.add(0.69);
        v.add(0.87);
        TestIndependencia test = new TestIndependencia();
        test.test(v);
    }

}
