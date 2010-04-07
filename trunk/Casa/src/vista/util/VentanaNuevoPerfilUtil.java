/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import dao.MusicaDao;
import dao.implementacion.MusicaDaoImp;
import dominio.Canal;
import dominio.Musica;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo
 */
public class VentanaNuevoPerfilUtil
{

    public VentanaNuevoPerfilUtil()
    {

    }

    public Collection cargarTablaTemas(JTable tabla, Collection temas)
    {
        this.limpiar(tabla);
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[1];
        Iterator it = temas.iterator();
        Musica m = new Musica();
        while(it.hasNext())
        {
            m = (Musica)it.next();
            datos[0] = m.getNombre().trim();
            modelo.addRow(datos);
        }
        m = null;
        modelo = null;
        it = null;
        return temas;
    }

    public Collection cargarTablaCanales(JTable tabla, Collection canales)
    {
        this.limpiar(tabla);
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[1];
        Iterator it = canales.iterator();
        Canal c = new Canal();
        while(it.hasNext())
        {
            c = (Canal)it.next();
            datos[0] = c.getNombre().trim();
            modelo.addRow(datos);
        }
        c = null;
        modelo = null;
        it = null;
        return canales;
    }


    /**
     * Metodo para limpiar los registros de la tabla.
     * Quita todas las filas de la tabla.
     */
    private void limpiar(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        while(tabla.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }

}
