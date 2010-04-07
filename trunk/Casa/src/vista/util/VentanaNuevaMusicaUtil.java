/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import dao.MusicaDao;
import dao.implementacion.MusicaDaoImp;
import dominio.Musica;
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
public class VentanaNuevaMusicaUtil
{

    public VentanaNuevaMusicaUtil()
    {

    }

    public Collection traerTodos(JTable tabla, Collection temas)
    {
        this.limpiar(tabla);
        MusicaDao sql = new MusicaDaoImp();
        temas.clear();
        temas = sql.getAll();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[3];
        Iterator it = temas.iterator();
        Musica m = new Musica();
        while(it.hasNext())
        {
            m = (Musica)it.next();
            datos[0] = String.valueOf(m.getCodigo()).trim();
            datos[1] = m.getNombre().trim();
            datos[2] = m.getGenero().trim();
            modelo.addRow(datos);
        }
        m = null;
        modelo = null;
        it = null;
        sql = null;
        return temas;
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

    public void agregarTemasAPerfil(VentanaNuevoPerfil nuevoPerfil, JTable tabla, Collection temas)
    {
        Collection co = new ArrayList();
        for(int i=0; i<tabla.getRowCount(); i++)
            if(Boolean.parseBoolean(String.valueOf(tabla.getValueAt(i, 3))))
            {
                co.add(this.getMusica(Integer.parseInt(String.valueOf(tabla.getValueAt(i, 0))), temas));
                System.out.println("Se agrego uno");
            }
                
        nuevoPerfil.setTemas(co);
    }

    private Musica getMusica(int id, Collection temas)
    {
        Iterator it = temas.iterator();
        Musica musica = new Musica();
        while(it.hasNext())
        {
            musica = (Musica)it.next();
            if(musica.getCodigo() == id)
            {
                return musica;
            }
        }
        return musica;
    }


    public void nuevaMusica(Musica musica)
    {
        MusicaDao sql = new MusicaDaoImp();
        sql.guardar(musica);
    }

    public void modificarMusica(Musica musica)
    {
        MusicaDao sql = new MusicaDaoImp();
        sql.modificar(musica);
    }

    public void eliminarMusica(Musica musica)
    {
        MusicaDao sql = new MusicaDaoImp();
        sql.borrar(musica);
    }

}
