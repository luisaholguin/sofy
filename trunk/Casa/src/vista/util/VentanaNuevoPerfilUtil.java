/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import controlador.PerfilInt;
import controlador.implementacion.PerfilImp;
import dao.EstadoAnimDao;
import dao.implementacion.EstadoAnimoDaoImp;
import dominio.Canal;
import dominio.EstadoAnimo;
import dominio.Cancion;
import dominio.Perfil;
import dominio.Receta;
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
        Cancion m = new Cancion();
        while(it.hasNext())
        {
            m = (Cancion)it.next();
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

    public void cargarTablaRecetas(JTable tabla, Collection recetas)
    {
        this.limpiar(tabla);
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[1];
        Iterator it = recetas.iterator();
        Receta r = new Receta();
        while(it.hasNext())
        {
            r = (Receta)it.next();
            datos[0] = r.getNombre().trim();
            modelo.addRow(datos);
        }
        r = null;
        modelo = null;
        it = null;
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

    public Perfil getPerfil(int codigo, Collection perfiles)
    {
        Perfil perfil = new Perfil();
        Iterator it = perfiles.iterator();
        while(it.hasNext())
        {
            perfil = (Perfil)it.next();
            if(perfil.getCodigo() == codigo)
                return perfil;
        }
        return perfil;
    }

    public void marcarEstadoDeAnimo(JTable tabla, int codigo)
    {
        this.descmarcarTodo(tabla);
        for(int i=0; i<tabla.getRowCount(); i++)
        {
            if(codigo == Integer.parseInt(String.valueOf(tabla.getValueAt(i, 0))))
                tabla.setValueAt(true, i, 2);
        }
    }

    public Collection cargarTablaPerfiles(JTable tabla)
    {
        this.limpiar(tabla);
        PerfilInt sql = new PerfilImp();
        Collection perfiles = sql.getAll();
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
    public void limpiar(JTable tabla)
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

    /**
     * Este metodo controla que haya un elemento marcado
     * @param tabla
     * @return bandera devuelve verdadero si hay un elemento marcado y falso si no lo hay
     */
    public boolean controlarMarca(JTable tabla)
    {
        boolean bandera = false;
        for(int i=0; i<tabla.getRowCount();i++)
        {
            if(Boolean.parseBoolean(String.valueOf(tabla.getValueAt(i, 2))))
                bandera = true;
        }
        return bandera;
    }

    public void descmarcarTodo(JTable tabla)
    {
        int fila = tabla.getRowCount();
        fila++;
        this.desmarcar(tabla, true, fila);
    }

    public EstadoAnimo getEstadoDeAnimo(JTable tabla, Collection estados)
    {
        EstadoAnimo e = new EstadoAnimo();
        for(int i=0; i<tabla.getRowCount(); i++)
        {
            if(Boolean.parseBoolean(String.valueOf(tabla.getValueAt(i, 2))))
            {
                Iterator it = estados.iterator();
                while(it.hasNext())
                {
                    e = (EstadoAnimo)it.next();
                    if(e.getCodigo() == Integer.parseInt(String.valueOf(tabla.getValueAt(i, 0))))
                        return e;
                }
            }
        }
        return e;
    }

    public void guardar(Perfil perfil)
    {
        PerfilInt sql = new PerfilImp();
        sql.guardar(perfil);
    }

    public void modificar(Perfil perfil)
    {
        PerfilInt sql = new PerfilImp();
        sql.modificar(perfil);
    }

    public void borrar(Perfil perfil)
    {
        PerfilInt sql = new PerfilImp();
        sql.borrar(perfil);
    }

}
