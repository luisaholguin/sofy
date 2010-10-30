/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import reportes.ExportarCsv;
import vista.UIReporteTest;

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

    public void exportar(JTable tabla, Collection numeros)
    {
        Collection exportar = new ArrayList();
        for(int i=0; i<tabla.getRowCount(); i++)
        {
            if(Boolean.parseBoolean(String.valueOf(tabla.getValueAt(i, 1))))
            {
                exportar.add(this.getDistribucion(numeros, String.valueOf(tabla.getValueAt(i, 0))));
            }
        }
        JFileChooser fileChooser = new JFileChooser("C:\\temp");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int status = fileChooser.showOpenDialog(null); //fileChooser
        if (status == JFileChooser.APPROVE_OPTION)
        {
            File directorio =fileChooser.getSelectedFile();
            ExportarCsv ex = new ExportarCsv();
            ex.exportar(exportar, directorio.getPath());
        }

    }

    private Vector getDistribucion(Collection numeros, String dist)
    {
        Vector v = new Vector();
        Iterator it = numeros.iterator();
        while(it.hasNext())
        {
            Vector ve = (Vector)it.next();
            if(String.valueOf(ve.elementAt(0)).trim().equals(dist.trim()))
                v = ve;
        }
        return v;
    }

    public void mostrarTest(JTable tabla, Collection numeros)
    {
        Collection exportar = new ArrayList();
        for(int i=0; i<tabla.getRowCount(); i++)
        {
            if(Boolean.parseBoolean(String.valueOf(tabla.getValueAt(i, 1))))
            {
                exportar.add(this.getDistribucion(numeros, String.valueOf(tabla.getValueAt(i, 0))));
            }
        }
        Iterator it = exportar.iterator();
        while(it.hasNext())
        {
            Vector v = (Vector)it.next();
            UIReporteTest reporte = new UIReporteTest(v);
            reporte.setVisible(true);
            v = null;
        }
    }

}
