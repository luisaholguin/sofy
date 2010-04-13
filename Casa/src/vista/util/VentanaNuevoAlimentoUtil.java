/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import dao.ElementoDao;
import dao.implementacion.ElementoDaoImp;
import dominio.Elemento;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo
 */
public class VentanaNuevoAlimentoUtil
{
    public VentanaNuevoAlimentoUtil()
    {

    }

    public Collection traerTodos(JTable tabla, Collection alimentos)
    {
        this.limpiar(tabla);
        ElementoDao sql = new ElementoDaoImp();
        alimentos.clear();
        alimentos = sql.getAll();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[3];
        Iterator it = alimentos.iterator();
        Elemento e = new Elemento();
        while(it.hasNext())
        {
            e = (Elemento)it.next();
            datos[0] = String.valueOf(e.getCodigo()).trim();
            datos[1] = e.getTipo().trim();
            datos[2] = e.getNombre();
            modelo.addRow(datos);
        }
        e = null;
        modelo = null;
        it = null;
        sql = null;
        return alimentos;
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

//    public void agregarTemasAPerfil(VentanaNuevoPerfil nuevoPerfil, JTable tabla, Collection temas)
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

//    private Musica getMusica(int id, Collection temas)
//    {
//        Iterator it = temas.iterator();
//        Musica musica = new Musica();
//        while(it.hasNext())
//        {
//            musica = (Musica)it.next();
//            if(musica.getCodigo() == id)
//            {
//                return musica;
//            }
//        }
//        return musica;
//    }


    public void nuevoElemento(Elemento elemento)
    {
        ElementoDao sql = new ElementoDaoImp();
        sql.guardar(elemento);
    }

    public void modificarElemento(Elemento elemento)
    {
        ElementoDao sql = new ElementoDaoImp();
        sql.modificar(elemento);
    }

    public void eliminarElemento(Elemento elemento)
    {
        ElementoDao sql = new ElementoDaoImp();
        sql.borrar(elemento);
    }


}
