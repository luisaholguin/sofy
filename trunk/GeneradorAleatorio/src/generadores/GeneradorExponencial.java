/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.Exponential;
import cern.jet.random.engine.RandomEngine;
import distribuciones.Exponencial;



/**
 *
 * @author Carolina
 */
public class GeneradorExponencial implements Generador
{
    
    private Exponential genExponencial;
    private Exponencial exponencial = new Exponencial();
    private GeneradorCongruencial congruencial;
    private boolean banderaGenerador = true; //false = generador congruencial
    private int semilla;

    public GeneradorExponencial(Exponencial exponencial)
    {
        this.exponencial = exponencial;
        this.banderaGenerador = true;
        this.genExponencial = new Exponential(this.exponencial.getLambda(), RandomEngine.makeDefault());
    }

    public GeneradorExponencial(Exponencial exponencial, int semilla)
    {
        this.semilla = semilla;
        this.exponencial = exponencial;
        this.banderaGenerador = true;
        this.genExponencial = new Exponential(this.exponencial.getLambda(), new cern.jet.random.engine.MersenneTwister(this.semilla));
    }

    public GeneradorExponencial(Exponencial exponencial, String congruencial)
    {
        this.exponencial = exponencial;
        this.banderaGenerador = false;
    }

    public double getNumero()
    {
        double numero = 0.0;
        if(this.banderaGenerador)
            numero = this.genExponencial.nextDouble();
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }



}
