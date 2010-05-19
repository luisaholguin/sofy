/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import contexto.Observer;
import dao.ContenedorDao;
import dao.implementacion.ContenedorDaoImp;
import dominio.Contenedor;
import dominio.Ingrediente;
import dominio.Posicion;
import dominio.Receta;
import abstraccionhardware.Kernel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Marcelo
 */
public class ServiciosCocina implements Observer
{
    private Kernel kernel;
    private dominio.Perfil perfil = new dominio.Perfil();
    private ContenedorDao sqlContenedor;

    public ServiciosCocina()
    {

    }

    public ServiciosCocina(Kernel kernel)
    {
        this.kernel = kernel;
//        this.perfil = new dominio.Perfil();
        this.sqlContenedor = new ContenedorDaoImp();
    }

    public void update(Posicion p)
    {
        this.mostrarRecetas();
    }

    /**
     * mostrar una receta implica obtener las recetas pertenecientes a un perfil
     * y checar que exista la cantidad necesaria de ingredientes en la heladera
     * para ello hay que obtener el correspondiente contenedor de cada ingrediente
     */
    private void mostrarRecetas()
    {
        Contenedor c;
        boolean bandera;
        this.perfil = kernel.getPerfil();
        Collection temp = this.perfil.getReceta();
        Collection recetas = new ArrayList();
        Collection ingredientes;
        Iterator it = temp.iterator();
        while(it.hasNext()) //a partir de aqui se hace el filtrado las recetas de acuerdo a la cantidad de elemntos en la heldera
        {
            Receta r = (Receta)it.next();
            ingredientes = r.getIngrediente();
            Iterator i = ingredientes.iterator();
            bandera = true;
            while(i.hasNext())
            {
                Ingrediente in = (Ingrediente)i.next();
                c = this.getContenedor(in.getElemento().getNombre().trim());
                switch(in.getSeleccion())
                {
                    case 0:
                            if(in.getCucharadas() > c.getCantidad())
                                bandera = false;
                            break;
                    case 1:
                            if(in.getTazas() > c.getCantidad())
                                bandera = false;
                            break;
                    case 2:
                            if(in.getPeso() > c.getCantidad())
                                bandera = false;
                            break;
                    case 3:
                            if(in.getUnidades() > c.getCantidad())
                                bandera = false;
                            break;
                }
            }
            if(bandera)
            {
                recetas.add(r);
            }
        }
        this.kernel.setRecetas(recetas);
    }

    private Contenedor getContenedor(String nombre)
    {
        Contenedor c = new Contenedor();
        c = this.sqlContenedor.get(nombre.trim());
        return c;
    }

}
