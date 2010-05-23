/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;


/**
 *
 * @author marcelo
 */
public class GeneradorNormal implements Generador
{
    private distribuciones.Normal normal;
    private Normal genNormal;
    private GeneradorCongruencial congruencial;
    private int semilla;
    private boolean banderaGenerador = true; //false = generador congruencial

    public GeneradorNormal(distribuciones.Normal normal)
    {
        this.banderaGenerador = true;
        this.normal = normal;
        this.genNormal = new Normal(this.normal.getMedia(), this.normal.getDesviacion(), RandomEngine.makeDefault());
    }

    public GeneradorNormal(distribuciones.Normal normal, String congruencial)
    {
        this.banderaGenerador = false;
        this.normal = normal;
        this.congruencial = new GeneradorCongruencial();
    }

    public double getNumero()
    {
        double numero = 0.0;
        if(this.banderaGenerador)
            numero = this.genNormal.nextDouble();
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }
    



}
