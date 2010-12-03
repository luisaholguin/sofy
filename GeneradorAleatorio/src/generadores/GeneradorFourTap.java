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

    public double getNumero()
    {
        FourTapRandom f = new FourTapRandom();
        return f.nextDouble();
    }

}
