/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.Poisson;
import cern.jet.random.engine.RandomEngine;

/**
 *
 * @author Carolina
 */
public class GeneradorPoisson implements Generador
{

    private Poisson genPoisson;
    private distribuciones.Poisson poisson = new distribuciones.Poisson();
    private GeneradorCongruencial congruencial;
    private boolean banderaGenerador = true; //false = generador congruencial
    private int semilla = -1;

    public GeneradorPoisson(distribuciones.Poisson poisson)
    {
        this.poisson = poisson;
        this.banderaGenerador = true;
        this.genPoisson = new Poisson(this.poisson.getMedia(), RandomEngine.makeDefault());
    }

    public GeneradorPoisson(distribuciones.Poisson poisson, int semilla)
    {
        this.semilla = semilla;
        this.poisson = poisson;
        this.banderaGenerador = true;
        this.genPoisson = new Poisson(this.poisson.getMedia(), new cern.jet.random.engine.MersenneTwister(this.semilla));
    }

    public GeneradorPoisson(distribuciones.Poisson poisson, String congruencial)
    {
        this.poisson = poisson;
        this.banderaGenerador = false;
    }

    public double getNumero()
    {
        double numero = 0.0;
        if(this.banderaGenerador)
            numero = this.genPoisson.nextDouble();
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }

}
