/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import dao.ContextoDao;
import dao.implementacion.ContextoDaoImp;
import dominio.Contexto;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo
 */
public class VentanaNuevoContextoUtil
{

    public VentanaNuevoContextoUtil()
    {

    }

    public Collection traerTodos(JTable tabla, Collection contextos)
    {
        this.limpiar(tabla);
        ContextoDao sql = new ContextoDaoImp();
        contextos.clear();
        contextos = sql.getAll();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[4];
        Iterator it = contextos.iterator();
        Contexto c = new Contexto();
        while(it.hasNext())
        {
            c = (Contexto)it.next();
            datos[0] = String.valueOf(c.getCodigo()).trim();
            datos[1] = c.getContexto().trim();
            datos[2] = c.getParOrdenadoNoroeste().trim();
            datos[3] = c.getParOrdenadoSureste().trim();
            modelo.addRow(datos);
        }
        c = null;
        modelo = null;
        it = null;
        sql = null;
        return contextos;
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

//    public void agregarCanalesAPerfil(VentanaNuevoPerfil nuevoPerfil, JTable tabla, Collection canales)
//    {
//        Collection co = new ArrayList();
//        for(int i=0; i<tabla.getRowCount(); i++)
//            if(Boolean.parseBoolean(String.valueOf(tabla.getValueAt(i, 3))))
//            {
//                co.add(this.getCanal(Integer.parseInt(String.valueOf(tabla.getValueAt(i, 0))), canales));
//                System.out.println("Se agrego un canal");
//            }
//
//        nuevoPerfil.setCanales(co);
//    }

    public Contexto getContexto(int id, Collection contextos)
    {
        Iterator it = contextos.iterator();
        Contexto contexto = new Contexto();
        while(it.hasNext())
        {
            contexto = (Contexto)it.next();
            if(contexto.getCodigo() == id)
            {
                return contexto;
            }
        }
        return contexto;
    }


    public void nuevoContexto(Contexto contexto)
    {
        ContextoDao sql = new ContextoDaoImp();
        sql.guardar(contexto);
    }

    public void modificarCanal(Contexto contexto)
    {
        ContextoDao sql = new ContextoDaoImp();
        sql.modificar(contexto);
    }

    public void eliminarCanal(Contexto contexto)
    {
        ContextoDao sql = new ContextoDaoImp();
        sql.borrar(contexto);
    }


}
