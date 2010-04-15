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
        Contenedor contenedor;//creo el objeto contenedor
        ContenedorDao sqlContenedor = new ContenedorDaoImp(); //instancio un objeto de ContenedorDaoImp
        contenedor = sqlContenedor.get(id);//le asigno a contenedor los datos de la bd a traves del metodo get de ContenedorDaoImp
        //Hasta aqui tengo el objeto contenedor parcialmente cargado con los datos de contenedor y solo el id de elemento
        //tengo que cargar los restantes atributos de elemento
        Elemento elemento = contenedor.getElemento();//trae el elemento que esta en contenedor y se lo asigna al objeto elemento
        ElementoDao sqlElemento = new ElementoDaoImp();//instancia un elementoDaoImp para poder traer todos los datos de elementos
        elemento = sqlElemento.get(elemento.getCodigo());//a elemento le asigno el elemento completo que me devuelve el metodo get de ElementoDaoImp
        contenedor.setElemento(elemento);//le asigno al elemento de conenedor el elemento completo
        return contenedor;//devuelve el contenedor con todos los datos
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
