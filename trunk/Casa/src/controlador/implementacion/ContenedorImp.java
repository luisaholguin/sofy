/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.implementacion;

import controlador.ContenedorInt;
import dao.ContenedorDao;
import dao.ElementoDao;
import dao.implementacion.ContenedorDaoImp;
import dao.implementacion.ElementoDaoImp;
import dominio.Contenedor;
import dominio.Elemento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Marcelo
 */
public class ContenedorImp implements ContenedorInt
{

    public void guardar(Contenedor contenedor)
    {
        ContenedorDao sql = new ContenedorDaoImp();
        sql.guardar(contenedor);
    }

    public void modificar(Contenedor contenedor)
    {
        ContenedorDao sql = new ContenedorDaoImp();
        sql.modificar(contenedor);
    }

    public void borrar(Contenedor contenedor)
    {
        ContenedorDao sql = new ContenedorDaoImp();
        sql.borrar(contenedor);
    }

    public Contenedor get(int id)
    {
        Contenedor contenedor;
        ContenedorDao sqlContenedor = new ContenedorDaoImp();
        contenedor = sqlContenedor.get(id);
        Elemento elemento = contenedor.getElemento();
        ElementoDao sqlElemento = new ElementoDaoImp();
        elemento = sqlElemento.get(elemento.getCodigo());
        contenedor.setElemento(elemento);
        return contenedor;
    }

    public Collection getAll()
    {
        Collection temp;
        Collection contenedores = new ArrayList();
        ContenedorDao sqlContenedor = new ContenedorDaoImp();
        ElementoDao sqlElemento = new ElementoDaoImp();
        temp = sqlContenedor.getAll();
        Iterator it = temp.iterator();
        while(it.hasNext())
        {
            Contenedor c = (Contenedor)it.next();
            c.setElemento(sqlElemento.get(c.getElemento().getCodigo()));
            contenedores.add(c);
            c = null;
        }
        return contenedores;
    }

}
