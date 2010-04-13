/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import dao.EstadoAnimDao;
import dao.MusicaDao;
import dao.PerfilDao;
import dao.implementacion.EstadoAnimoDaoImp;
import dao.implementacion.MusicaDaoImp;
import dao.implementacion.PerfilDaoImp;
import dominio.Canal;
import dominio.EstadoAnimo;
import dominio.Musica;
import dominio.Perfil;
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

    public Collection cargarTablaEstadosDeAnimo(JTable tabla, Collection estados)
    {
        this.limpiar(tabla);
        EstadoAnimDao sql = new EstadoAnimoDaoImp();
        estados.clear();
        estados = sql.getAll();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[2];
        Iterator it = estados.iterator();
        EstadoAnimo e = new EstadoAnimo();
        while(it.hasNext())
        {
            e = (EstadoAnimo)it.next();
            datos[0] = String.valueOf(e.getCodigo());
            datos[1] = e.getNombre();
            modelo.addRow(datos);
        }
        e = null;
        modelo = null;
        it = null;
        return estados;
    }

    public Collection cargarTablaPerfiles(JTable tabla, Collection perfiles)
    {
        this.limpiar(tabla);
        PerfilDao sql = new PerfilDaoImp();
        perfiles.clear();
        perfiles = sql.getAll();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[2];
        Iterator it = perfiles.iterator();
        Perfil p = new Perfil();
        while(it.hasNext())
        {
            p = (Perfil)it.next();
            datos[0] = String.valueOf(p.getCodigo());
            datos[1] = p.getNombre();
            modelo.addRow(datos);
        }
        p = null;
        modelo = null;
        it = null;
        return perfiles;
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

    public void desmarcar(JTable tabla, boolean marca, int fila)
    {
        
        int size = tabla.getRowCount();
        if(marca)
            for(int i=0; i<size; i++)
                if(fila != i)
                    tabla.setValueAt(false, i, 2);
    }

}
