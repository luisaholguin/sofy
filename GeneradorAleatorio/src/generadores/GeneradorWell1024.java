/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generadores;

import umontreal.iro.lecuyer.rng.WELL1024;

/**
 *
 * @author Carolina
 */
public class GeneradorWell1024 implements Generador {

    public double getNumero() {
          WELL1024 well = new WELL1024();
          return well.nextDouble();
    }

}
