/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import umontreal.iro.lecuyer.rng.MRG32k3aL;

/**
 *
 * @author Carolina
 */
public class GeneradorMrg32k3aL implements Generador {

    public double getNumero() {
        MRG32k3aL m = new MRG32k3aL();
        return m.nextDouble();

    }


}
