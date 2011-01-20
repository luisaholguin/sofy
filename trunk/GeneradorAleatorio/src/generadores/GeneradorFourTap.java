/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import org.spaceroots.mantissa.random.FourTapRandom;

/**
 *
 * @author marcelo
 */
public class GeneradorFourTap implements Generador
{

    FourTapRandom f;

    public GeneradorFourTap() 
    {
        this.f  = new FourTapRandom();
    }

    public GeneradorFourTap(long semilla)
    {
        this.f  = new FourTapRandom(semilla);
    }


    public double getNumero()
    {
        return f.nextDouble();
    }

}
