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
public class GeneradorLfsr113 implements Generador {

    public double getNumero() {
       LFSR113 LFSR = new LFSR113();
       return LFSR.nextDouble();
    }

}
