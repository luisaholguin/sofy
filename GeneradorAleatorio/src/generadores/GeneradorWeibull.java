/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.Distributions;
import cern.jet.random.engine.RandomEngine;
import distribuciones.Weibull;

/**
 *
 * @author marcelo
 */
public class GeneradorWeibull implements Generador
{

    private Weibull weibull = new Weibull();
    private GeneradorCongruencial congruencial;
    private boolean banderaGenerador = true; //false = generador congruencial

    public GeneradorWeibull(Weibull weibull)
    {
        this.weibull = weibull;
        this.banderaGenerador = true;
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
            numero = Distributions.nextWeibull(this.weibull.getAlfa(), this.weibull.getBeta(), RandomEngine.makeDefault());
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }



}
