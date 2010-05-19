/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import abstraccionhardware.Kernel;


/**
 *
 * @author marcelo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
//        Test test = new Test();
////        test.testCaro();
//        test.TestMarcelo();


        
        Kernel k = new Kernel();
        k.inicializar();
    }

}
