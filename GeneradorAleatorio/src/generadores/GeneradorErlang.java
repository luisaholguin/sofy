/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.engine.RandomEngine;
import distribuciones.Erlang;

/**
 *
 * @author Carolina
 */
public class GeneradorErlang implements Generador
{

    private Erlang erlang = new Erlang();
    private GeneradorCongruencial congruencial;
    private boolean banderaGenerador = true; //false = generador congruencial
    private int semilla = -1;
    private RandomEngine randomGenerator;

    public GeneradorErlang(Erlang erlang)
    {
        this.erlang = erlang;
        this.banderaGenerador = true;
        this.randomGenerator = RandomEngine.makeDefault();
    }

    public GeneradorErlang(Erlang erlang, int semilla)
    {
        this.semilla = semilla;
        this.erlang = erlang;
        this.banderaGenerador = true;
        this.randomGenerator = new cern.jet.random.engine.MersenneTwister(this.semilla);
    }

    public GeneradorErlang(Erlang erlang, String congruencial)
    {
        this.erlang = erlang;
        this.banderaGenerador = false;
    }



    public double getNumero()
    {
        double numero = 0.0;
        if(this.banderaGenerador)
//            if(this.semilla == -1)
//                numero = Distributions.nextErlang(this.erlang.getVarianza(), this.erlang.getMedia(), RandomEngine.makeDefault());
//            else
//                numero = Distributions.nextErlang(this.erlang.getVarianza(), this.erlang.getMedia(), new cern.jet.random.engine.MersenneTwister(this.semilla));
            numero = this.nextErlang(this.erlang.getVarianza(), this.erlang.getMedia());
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }

    private double nextErlang(double variance, double mean)
    {
	int k = (int)( (mean * mean ) / variance + 0.5 );
	k = (k > 0) ? k : 1;
	double a = k / mean;

	double prod = 1.0;
	for (int i = 0; i < k; i++) prod *= randomGenerator.raw();
	return -Math.log(prod)/a;
    }

}
