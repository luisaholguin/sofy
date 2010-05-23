/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

////import cern.jet.random.engine.RandomEngine;
import cern.jet.random.Binomial;
import cern.jet.random.engine.RandomEngine;
/**
 *
 * @author marcelo
 */
public class GeneradorBinomial implements Generador
{
    private Binomial genBinomial;
    private distribuciones.Binomial binomial;
    private int semilla;
    private GeneradorCongruencial congruencial;
    private boolean banderaGenerador = true; //false = generador congruencial


    public GeneradorBinomial(distribuciones.Binomial binomial)
    {
        this.banderaGenerador = true;
        this.binomial = binomial;
        this.genBinomial = new Binomial(this.binomial.getN(), this.binomial.getP(), RandomEngine.makeDefault());
    }

    public GeneradorBinomial(distribuciones.Binomial binomial, String congruencial)
    {
        this.binomial = binomial;
        this.congruencial = new GeneradorCongruencial();
        this.banderaGenerador = false;
    }

    
    public double getNumero()
    {
        double numero = 0.0;
        if(this.banderaGenerador)
            numero = this.genBinomial.nextDouble();
        else
            numero = this.congruencial.nextDouble();
        return numero;
    }

}
