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

    public GeneradorLfsr113()
    {
    }

    public GeneradorLfsr113(int semilla)
    {
        int[] sem = new int[1];
        sem[0] = semilla;
        this.LFSR.setSeed(sem);
    }



    public double getNumero() {
       
       return LFSR.nextDouble();
    }

}
