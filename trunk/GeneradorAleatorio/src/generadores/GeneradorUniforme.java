/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.Uniform;
import cern.jet.random.engine.RandomEngine;
import distribuciones.Uniforme;

/**
 *
 * @author Carolina
 */
public class GeneradorUniforme implements Generador
{
    private int semilla;
    private Uniform genUniforme;
    private Uniforme uniforme = new Uniforme();
    private GeneradorCongruencial congruencial;
    private boolean banderaGenerador = true; //false = generador congruencial

    public GeneradorUniforme(Uniforme uniforme)
    {
        this.banderaGenerador = true;
        this.uniforme = uniforme;
        this.genUniforme = new Uniform(uniforme.getMinimo(), this.uniforme.getMaximo(), RandomEngine.makeDefault());
    }

    public GeneradorUniforme(Uniforme uniforme, int semilla)
    {
        this.banderaGenerador = true;
        this.uniforme = uniforme;
        this.semilla = semilla;
        this.genUniforme = new Uniform(this.uniforme.getMinimo(), this.uniforme.getMaximo(), this.semilla);
    }

    public GeneradorUniforme(Uniforme uniforme, String congruencial)
    {
        this.banderaGenerador = false;
        this.uniforme = uniforme;
        this.congruencial = new GeneradorCongruencial();
    }

    public double getNumero()
    {
        double numero = 0.0;
        if(this.banderaGenerador)
            numero = this.genUniforme.nextDouble();
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }



}
