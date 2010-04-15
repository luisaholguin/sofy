/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import controlador.RecetaInt;
import controlador.implementacion.RecetaImp;
import dao.ElementoDao;
import dao.IngredienteDao;
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

}
