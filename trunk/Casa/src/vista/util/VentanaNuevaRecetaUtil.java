/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import controlador.RecetaInt;
import controlador.implementacion.RecetaImp;
import dao.ElementoDao;
//import dao.IngredienteDao;
import dao.implementacion.ElementoDaoImp;
import dominio.Elemento;
import dominio.Ingrediente;
import dominio.Receta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo
 */
public class VentanaNuevaRecetaUtil
{



    public VentanaNuevaRecetaUtil()
    {

    }

    public Collection traerTodos(JTable tabla)
    {
        this.limpiar(tabla);
        RecetaInt sql = new RecetaImp();
        Collection recetas = sql.getAll();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[2];
        Iterator it = recetas.iterator();
        Receta r = new Receta();
        while(it.hasNext())
        {
            r = (Receta)it.next();
            datos[0] = String.valueOf(r.getCodigo()).trim();
            datos[1] = r.getNombre().trim();
            modelo.addRow(datos);
        }
        r = null;
        modelo = null;
        it = null;
        sql = null;
        return recetas;
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

    public Collection cargarComboElementos(JComboBox combo)
    {
        ElementoDao sql = new ElementoDaoImp();
        Collection elementos = sql.getAll();
        Iterator it = elementos.iterator();
        while(it.hasNext())
        {
            Elemento e = (Elemento)it.next();
            combo.addItem(e.getNombre().trim());
            e = null;
        }
        return elementos;
    }

    public void cargarIngredientes(JTable tabla, Collection ingredientes)
    {
        this.limpiar(tabla);
        Iterator it = ingredientes.iterator();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[3];
        Ingrediente i = new Ingrediente();
        while(it.hasNext())
        {
            i = (Ingrediente)it.next();
            datos[0] = String.valueOf(i.getCodigo());
            datos[1] = i.getElemento().getNombre().trim();
            switch(i.getSeleccion())
            {
                case 0:
                        datos[2]= String.valueOf(i.getCucharadas());
                        break;
                case 1:
                        datos[2] = String.valueOf(i.getTazas());
                        break;
                case 2:
                        datos[2] = String.valueOf(i.getPeso());
                        break;
                case 3:
                        datos[2] = String.valueOf(i.getUnidades());
                        break;
            }
            modelo.addRow(datos);
        }
        modelo = null;
    }
    
    public Collection agregarAlimento(JComboBox combo, Ingrediente ingrediente, Collection elementos, Collection ingredientes, JTable tabla)
    {
        ingrediente.setElemento(this.buscarElemento(String.valueOf(combo.getSelectedItem()), elementos));
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[3];
        datos[0] = "";
        datos[1] = ingrediente.getElemento().getNombre().trim();
        switch(ingrediente.getSeleccion())
        {
            case 0:
                    datos[2]= String.valueOf(ingrediente.getCucharadas());
                    break;
            case 1:
                    datos[2] = String.valueOf(ingrediente.getTazas());
                    break;
            case 2:
                    datos[2] = String.valueOf(ingrediente.getPeso());
                    break;
            case 3:
                    datos[2] = String.valueOf(ingrediente.getUnidades());
                    break;
        }
        modelo.addRow(datos);
        modelo = null;
        ingredientes.add(ingrediente);
        return ingredientes;
    }

    private Elemento buscarElemento(String nombre, Collection elementos)
    {
        Elemento e = new Elemento();
        Iterator it = elementos.iterator();
        while(it.hasNext())
        {
            e = (Elemento)it.next();
            if(e.getNombre().trim().equals(nombre.trim()))
                return e;
        }
        it = null;
        return e;
    }

    public void guardarReceta(Receta receta)
    {
        RecetaInt sql = new RecetaImp();
        sql.guardar(receta);
    }

    public void modificarReceta(Receta receta)
    {
        RecetaInt sql = new RecetaImp();
        sql.modificar(receta);
    }

    public void borrarReceta(Receta receta)
    {
        RecetaInt sql = new RecetaImp();
        sql.borrar(receta);
    }

    public Receta seleccionarReceta(int codigo, Collection recetas)
    {
        Iterator it = recetas.iterator();
        Receta receta = new Receta();
        while(it.hasNext())
        {
            receta = (Receta)it.next();
            if(receta.getCodigo() == codigo)
                return receta;
            receta = null;
        }
        it = null;
        return receta;
    }

    public Ingrediente getIngrediente(int codigo, Collection ingredientes)
    {
        Iterator it = ingredientes.iterator();
        Ingrediente i = new Ingrediente();

        while(it.hasNext())
        {
            i = (Ingrediente)it.next();
            if(i.getCodigo() == codigo)
                return i;
        }
        it = null;
        return i;
    }

    public Collection quitarIngrediente(int codigo, Collection ingredientes)
    {
        Collection devolver = new ArrayList();
        Iterator it = ingredientes.iterator();
        while(it.hasNext())
        {
            Ingrediente i = (Ingrediente)it.next();
            if(i.getCodigo() != codigo)
                devolver.add(i);
            i = null;
        }
        return devolver;
    }


    public Collection obtenerRecetas(JTable tabla, Collection recetas)
    {
        Collection devolver = new ArrayList();
        int size = tabla.getRowCount();
        for(int i=0; i<size; i++)
        {
            if(Boolean.parseBoolean(String.valueOf(tabla.getValueAt(i, 2))))
            {
                Iterator it = recetas.iterator();
                while(it.hasNext())
                {
                    Receta r = (Receta)it.next();
                    if(r.getCodigo() == Integer.parseInt(String.valueOf(tabla.getValueAt(i, 0))))
                    {
                        devolver.add(r);
                        break;
                    }
                    r = null;
                }
                it = null;
            }
        }
        return devolver;
    }




}
