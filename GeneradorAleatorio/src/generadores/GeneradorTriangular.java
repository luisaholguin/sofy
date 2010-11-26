/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.Distributions;
import cern.jet.random.engine.RandomEngine;
import distribuciones.Triangular;

/**
 *
 * @author Carolina
 */
public class GeneradorTriangular implements Generador
{

//    private Distributions genTriangular;
    private Triangular triangular = new Triangular();
    private GeneradorCongruencial congruencial;
    private boolean banderaGenerador = true; //false = generador congruencial
    private int semilla = -1;
    private RandomEngine randomGenerator;

    public GeneradorTriangular(Triangular triangular)
    {
        this.banderaGenerador = true;
        this.triangular = triangular;
        this.randomGenerator = RandomEngine.makeDefault();
    }

    public GeneradorTriangular(Triangular triangular, int semilla)
    {
        this.semilla = semilla;
        this.banderaGenerador = true;
        this.triangular = triangular;
        this.randomGenerator = new cern.jet.random.engine.MersenneTwister(this.semilla);
    }


    public GeneradorTriangular(Triangular triangular, String congruencial)
    {
        this.banderaGenerador = false;
        this.triangular = triangular;
    }


    public double getNumero()
    {
        double numero = 0.0;
//        if(this.banderaGenerador)
//            if(this.semilla == -1)
//                numero = Distributions.nextTriangular(triangular.getMinimo(), triangular.getMaximo(), triangular.getMedio(), RandomEngine.makeDefault());
//            else
//                numero = Distributions.nextTriangular(triangular.getMinimo(), triangular.getMaximo(), triangular.getMedio(), new cern.jet.random.engine.MersenneTwister(this.semilla));
//        else
//            numero = this.congruencial.nextDouble();
        if(this.banderaGenerador)
            numero = this.generar(this.triangular.getMinimo(), this.triangular.getMaximo(), this.triangular.getMedio());
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }

    private double generar(double min, double max, double medio)
    {

        double t = (medio-min)/(max-min);
        double u;
	u=randomGenerator.raw();
	if (u<t)
            return(min+Math.sqrt((medio-min)*(max-min)*u));                      /* -1 <= x <= 0 */
	else
            return(max-Math.sqrt((max-medio)*(max-min)*(1-u)));                 /*  0 <= x <= 1 */
    }

}
