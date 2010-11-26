/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.engine.RandomEngine;
import distribuciones.Weibull;

/**
 *
 * @author Carolina
 */
public class GeneradorWeibull implements Generador
{

    private Weibull weibull = new Weibull();
    private GeneradorCongruencial congruencial;
    private boolean banderaGenerador = true; //false = generador congruencial
    private int semilla;
    private RandomEngine randomGenerator;

    public GeneradorWeibull(Weibull weibull)
    {
        this.weibull = weibull;
        this.banderaGenerador = true;
        this.randomGenerator = RandomEngine.makeDefault();
    }

    public GeneradorWeibull(Weibull weibull, int semilla)
    {
        this.semilla = semilla;
        this.weibull = weibull;
        this.banderaGenerador = true;
        this.randomGenerator = new cern.jet.random.engine.MersenneTwister(this.semilla);
    }

    public GeneradorWeibull(Weibull weibull, String congruencial)
    {
        this.weibull = weibull;
        this.banderaGenerador = false;
    }

    public double getNumero()
    {
        double numero = 0.0;
        if(this.banderaGenerador)
//            if(this.semilla == -1)
//                numero = Distributions.nextWeibull(this.weibull.getAlfa(), this.weibull.getBeta(), RandomEngine.makeDefault());
//            else
//                numero = Distributions.nextWeibull(this.weibull.getAlfa(), this.weibull.getBeta(), new cern.jet.random.engine.MersenneTwister(this.semilla));
                numero = this.nextWeibull(this.weibull.getAlfa(), this.weibull.getBeta());
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }


    private double nextWeibull(double alpha, double beta)
    {
	// Polar method.
	// See Simulation, Modelling & Analysis by Law & Kelton, pp259
	return Math.pow(beta * ( - Math.log(1.0 - randomGenerator.raw()) ), 1.0 / alpha);
    }

}
