/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import evaluadores.TestCiclos;
import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author marcelo
 */
public class UIReporteTestUtil
{

    public UIReporteTestUtil()
    {
    }


    public void testCiclo(JTextArea textoCiclo, Vector v)
    {
        TestCiclos test = new TestCiclos();
        int ciclo = test.test(v);
        if(ciclo != (v.size()-1))
            textoCiclo.setText("La secuencia generada contiene ciclo, la cantidad de numeros generados antes de repetir el ciclo es: "+ciclo);
        else
            textoCiclo.setText("La secuencia generada no contiene ciclo");
    }

}
