/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcelo
 */
public class UIMostrarNumerosUtil
{

    public UIMostrarNumerosUtil()
    {
    }

    public void cargarVariable(String variable, JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[1];
        datos[0] = variable.trim();
        modelo.addRow(datos);
    }

    private void limpiar(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        while(tabla.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }

    public void cargarNumeros(JTable tabla, Vector num)
    {
        boolean bandera = true;
        int cont = 0;
        this.limpiar(tabla);
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String[] datos = new String[2];
        for(int i=0; i<num.size(); i++)
        {
            if(bandera)
                bandera = false;
            else
            {
                datos[1] = String.valueOf(num.elementAt(i));
                cont++;
                datos[0] = String.valueOf(cont);
                modelo.addRow(datos);
            }
            
        }
    }

}
