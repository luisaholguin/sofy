/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.Distributions;
import cern.jet.random.engine.RandomEngine;
import distribuciones.Erlang;

/**
 *
 * @author marcelo
 */
public class GeneradorErlang implements Generador
{

    private Erlang erlang = new Erlang();
    private GeneradorCongruencial congruencial;
    private boolean banderaGenerador = true; //false = generador congruencial

    public GeneradorErlang(Erlang erlang)
    {
        this.erlang = erlang;
        this.banderaGenerador = true;
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
            numero = Distributions.nextErlang(this.erlang.getVarianza(), this.erlang.getMedia(), RandomEngine.makeDefault());
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }

}
