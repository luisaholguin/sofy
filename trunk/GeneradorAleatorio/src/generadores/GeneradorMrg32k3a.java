/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import umontreal.iro.lecuyer.rng.MRG32k3a;

/**
 *
 * @author Carolina
 */
public class GeneradorMrg32k3a implements Generador {

    public double getNumero() {
        MRG32k3a Mrg32k3a = new MRG32k3a();
        return Mrg32k3a.nextDouble();

    }



}
