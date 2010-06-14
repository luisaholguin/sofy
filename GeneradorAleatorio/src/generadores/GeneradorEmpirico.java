/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import cern.jet.random.engine.RandomEngine;
import distribuciones.Empirica;

/**
 *
 * @author marcelo
 */
public class GeneradorEmpirico implements Generador
{

    private Empirica empirica = new Empirica();
    private RandomEngine engine = RandomEngine.makeDefault();

    public GeneradorEmpirico()
    {
    }

    public GeneradorEmpirico(Empirica empirica)
    {
        this.empirica = empirica;
    }

    public double getNumero()
    {
        double x = 0.0;
        double R = engine.raw();
        for(int i=0; i<empirica.getR().length; i++)
        {
            if((R >= empirica.getR()[i]) && (R <= empirica.getR()[i+1]))
            {
                x = empirica.getX()[i] + (empirica.getA()[i]*(R - empirica.getR()[i]));
                break;
            }
        }
        return x;
    }


}
