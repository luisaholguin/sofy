/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import controlador.ContenedorInt;
import controlador.implementacion.ContenedorImp;
import dao.ElementoDao;
import dao.implementacion.ElementoDaoImp;
import dominio.Contenedor;
import dominio.Elemento;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo
 */
public class VentanaNuevoContenedorUtil
{


    public VentanaNuevoContenedorUtil()
    {

    }

    public Collection cargarCombo(JComboBox combo, Collection alimentos)
    {
        ElementoDao sql = new ElementoDaoImp();
        alimentos = sql.getAll();
        Iterator it = alimentos.iterator();
        while(it.hasNext())
        {
            Elemento e = (Elemento)it.next();
            combo.addItem(e.getNombre().trim());
            e = null;
        }
        return alimentos;
    }
    
    public Collection traerTodos(JTable tabla, Collection contenedores, Collection alimentos)
    {
        this.limpiar(tabla);
        ContenedorInt sql = new ContenedorImp();
        contenedores.clear();
        contenedores = sql.getAll();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[3];

        //llenar primero los alimentos
        Iterator i = alimentos.iterator();
        while(i.hasNext())
        {
            Elemento e = (Elemento)i.next();
            datos[1] = e.getNombre().trim();
            datos[2] = e.getNombre().trim();
            modelo.addRow(datos);
            e = null;
        }
        int filas = tabla.getRowCount();
        //ahora llenar los contenedores creados
        Iterator it = contenedores.iterator();
        Contenedor c;
        while(it.hasNext())
        {
            c = (Contenedor)it.next();
            for(int j = 0; j<filas; j++)
                if(String.valueOf(tabla.getValueAt(j, 2)).equals(c.getElemento().getNombre().trim()))
                {
                    tabla.setValueAt(String.valueOf(c.getCodigo()), j, 0);
                    tabla.setValueAt(true, j, 3);
                    break;
                }
        }
        c = null;
        modelo = null;
        it = null;
        sql = null;
        return contenedores;
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

    public void nuevoContenedor(Contenedor contenedor)
    {
        ContenedorInt sql = new ContenedorImp();
        sql.guardar(contenedor);
    }

    public void modificarContenedor(Contenedor contenedor)
    {
        ContenedorInt sql = new ContenedorImp();
        sql.modificar(contenedor);
    }

    public void eliminarContenedor(Contenedor contenedor)
    {
        ContenedorInt sql = new ContenedorImp();
        sql.borrar(contenedor);
    }

    public Contenedor getContenedor(Collection contenedores, int codigo)
    {
        Contenedor contenedor = new Contenedor();
        Iterator it = contenedores.iterator();
        while(it.hasNext())
        {
            contenedor = (Contenedor)it.next();
            if(contenedor.getCodigo() == codigo)
                return contenedor;
        }
        return contenedor;
    }

    public Contenedor getContenedor(JComboBox combo, Contenedor contenedor, Collection alimentos)
    {
        Elemento elemento = new Elemento();
        elemento.setNombre(String.valueOf(combo.getSelectedItem()));
        Iterator it = alimentos.iterator();
        while(it.hasNext())
        {
            Elemento e = (Elemento)it.next();
            if(e.getNombre().trim().toUpperCase().equals(elemento.getNombre().trim().toUpperCase()))
            {
                contenedor.setElemento(e);
                break;
            }
        }
        return contenedor;
    }

}
