/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import dao.CanalDao;
import dao.implementacion.CanalDaoImp;
import dominio.Canal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.VentanaNuevoPerfil;

/**
 *
 * @author Marcelo
 */
public class VentanaNuevoCanalUtil
{

    public VentanaNuevoCanalUtil()
    {
        
    }

    public Collection traerTodos(JTable tabla, Collection canales)
    {
        this.limpiar(tabla);
        CanalDao sql = new CanalDaoImp();
        canales.clear();
        canales = sql.getAll();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[3];
        Iterator it = canales.iterator();
        Canal c = new Canal();
        while(it.hasNext())
        {
            c = (Canal)it.next();
            datos[0] = String.valueOf(c.getCodigo()).trim();
            datos[1] = c.getNombreCanal().trim();
            datos[2] = String.valueOf(c.getFrecuencia());
            modelo.addRow(datos);
        }
        c = null;
        modelo = null;
        it = null;
        sql = null;
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

    public void agregarCanalesAPerfil(VentanaNuevoPerfil nuevoPerfil, JTable tabla, Collection canales)
    {
        Collection co = new ArrayList();
        for(int i=0; i<tabla.getRowCount(); i++)
            if(Boolean.parseBoolean(String.valueOf(tabla.getValueAt(i, 3))))
            {
                co.add(this.getCanal(Integer.parseInt(String.valueOf(tabla.getValueAt(i, 0))), canales));
                System.out.println("Se agrego un canal");
            }

        nuevoPerfil.setCanales(co);
    }

    private Canal getCanal(int id, Collection canales)
    {
        Iterator it = canales.iterator();
        Canal canal = new Canal();
        while(it.hasNext())
        {
            canal = (Canal)it.next();
            if(canal.getCodigo() == id)
            {
                return canal;
            }
        }
        return canal;
    }


    public void nuevoCanal(Canal canal)
    {
        CanalDao sql = new CanalDaoImp();
        sql.guardar(canal);
    }

    public void modificarCanal(Canal canal)
    {
        CanalDao sql = new CanalDaoImp();
        sql.modificar(canal);
    }

    public void eliminarCanal(Canal canal)
    {
        CanalDao sql = new CanalDaoImp();
        sql.borrar(canal);
    }

}
