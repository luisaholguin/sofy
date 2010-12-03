/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import umontreal.iro.lecuyer.rng.LFSR113;

/**
 *
 * @author Carolina
 */
public class GeneradorLfsr113 implements Generador
{
    LFSR113 LFSR = new LFSR113();

    public double getNumero() {
       
       return LFSR.nextDouble();
    }

}
