/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import dao.EstadoAnimDao;
import dao.implementacion.EstadoAnimoDaoImp;
import dominio.EstadoAnimo;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo
 */
public class VentanaNuevoEstadoAnimoUtil
{

    public VentanaNuevoEstadoAnimoUtil()
    {

    }

    public Collection traerTodos(JTable tabla, Collection estados)
    {
        this.limpiar(tabla);
        EstadoAnimDao sql = new EstadoAnimoDaoImp();
        estados.clear();
        estados = sql.getAll();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[4];
        Iterator it = estados.iterator();
        EstadoAnimo m = new EstadoAnimo();
        while(it.hasNext())
        {
            m = (EstadoAnimo)it.next();
            datos[0] = String.valueOf(m.getCodigo()).trim();
            datos[1] = m.getNombre().trim();
            datos[2] = String.valueOf(m.getTempMin());
            datos[3] = String.valueOf(m.getTempMax());
            modelo.addRow(datos);
        }
        m = null;
        modelo = null;
        it = null;
        sql = null;
        return estados;
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


//    public void agregarEstadoAPerfil(VentanaNuevoPerfil nuevoPerfil, JTable tabla, Collection temas)
//    {
//        Collection co = new ArrayList();
//        for(int i=0; i<tabla.getRowCount(); i++)
//            if(Boolean.parseBoolean(String.valueOf(tabla.getValueAt(i, 3))))
//            {
//                co.add(this.getMusica(Integer.parseInt(String.valueOf(tabla.getValueAt(i, 0))), temas));
//                System.out.println("Se agrego uno");
//            }
//
//        nuevoPerfil.setTemas(co);
//    }

    private EstadoAnimo getEstadoAnimo(int id, Collection estados)
    {
        Iterator it = estados.iterator();
        EstadoAnimo e = new EstadoAnimo();
        while(it.hasNext())
        {
            e = (EstadoAnimo)it.next();
            if(e.getCodigo() == id)
            {
                return e;
            }
        }
        return e;
    }


    public void nuevoEstadoAnimo(EstadoAnimo e)
    {
        EstadoAnimDao sql = new EstadoAnimoDaoImp();
        sql.guardar(e);
    }

    public void modificarEstadoAnimo(EstadoAnimo e)
    {
        EstadoAnimDao sql = new EstadoAnimoDaoImp();
        sql.modificar(e);
    }

    public void eliminarEstadoAnimo(EstadoAnimo e)
    {
        EstadoAnimDao sql = new EstadoAnimoDaoImp();
        sql.borrar(e);
    }


}
