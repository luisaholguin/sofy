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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    }


    public void inicializar(int cantidad)
    {
        randomGenerator = RandomEngine.makeDefault();
        v.clear();
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

    public boolean validar(JTextField caja)
    {
        boolean bandera = true;
        System.out.println("Empezando la validacion");
        if(caja.getText().trim().length() == 0)
        {
            System.out.println("Caja vacia");
            bandera = false;
            JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad de valores a generar", "Faltan parametros", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                int numero = Integer.parseInt(caja.getText());
            }
            catch(NumberFormatException e)
            {
                bandera = false;
                JOptionPane.showMessageDialog(null, "Debe ingresar un cantidad entera de valores a generar", "Parametro Erroneo", JOptionPane.ERROR_MESSAGE);
            }
        }
        return bandera;
    }
    
    private void limpiar(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        while(tabla.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }

    public void mostrarValores(JTable tabla)
    {
        this.limpiar(tabla);
        boolean bandera = true;
        int cont = 0;
        this.limpiar(tabla);
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String[] datos = new String[2];
        for(int i=0; i<v.size(); i++)
        {
                datos[1] = String.valueOf(v.elementAt(i));
                cont++;
                datos[0] = String.valueOf(cont);
                modelo.addRow(datos);
        }
    }

}
