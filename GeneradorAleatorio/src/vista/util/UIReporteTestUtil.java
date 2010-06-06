/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import cern.jet.random.engine.RandomEngine;
import evaluadores.TestCiclos;
import evaluadores.TestIndependencia;
import evaluadores.TestUniformidad;
import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author marcelo
 */
public class UIReporteTestUtil
{
    private RandomEngine randomGenerator;
    private TestIndependencia testIndependencia = new TestIndependencia();
    private TestUniformidad testUniformidad = new TestUniformidad();

    private Vector v = new Vector();

    public UIReporteTestUtil()
    {
        randomGenerator = RandomEngine.makeDefault();
    }

    public UIReporteTestUtil(int cantidad)
    {
        randomGenerator = RandomEngine.makeDefault();
        for(int i=0; i<cantidad; i++)
        {
            v.add(randomGenerator.raw());
        }
    }


    public void testCiclo(JTextArea textoCiclo)
    {
        TestCiclos test = new TestCiclos();
        int ciclo = test.test(v);
        if(ciclo != (v.size()-1))
            textoCiclo.setText("La secuencia generada contiene ciclo, la cantidad de numeros generados antes de repetir el ciclo es: "+ciclo);
        else
            textoCiclo.setText("La secuencia generada no contiene ciclo");
    }

    public void testIndependencia(JTextArea textoIndependencia)
    {
        textoIndependencia.setText(this.testIndependencia.test(this.v));
    }

    public void testUniformidad(JTextArea resultado)
    {
        resultado.setText(this.testUniformidad.test(v));
    }

}
