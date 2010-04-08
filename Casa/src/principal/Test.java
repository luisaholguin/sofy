/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import dao.CanalDao;
import dao.ContenedorDao;
import dao.ElementoDao;
import dao.EstadoAnimDao;
import dao.MusicaDao;
import dao.PerfilDao;
import dao.implementacion.CanalDaoImp;
import dao.implementacion.ContenedorDaoImp;
import dao.implementacion.ElementoDaoImp;
import dao.implementacion.EstadoAnimoDaoImp;
import dao.implementacion.MusicaDaoImp;
import dao.implementacion.PerfilDaoImp;
import dominio.Canal;
import dominio.Contenedor;
import dominio.Elemento;
import dominio.EstadoAnimo;
import dominio.Musica;
import dominio.Perfil;
import java.util.Collection;
import java.util.Iterator;
import vista.VentanaAgregarTema;
import vista.VentanaNuevaMusica;

/**
 *
 * @author Marcelo
 */
public class Test {

    public Test()
    {

    }

    public void testCaro()
    {

//        MusicaDao sql = new MusicaDaoImp();
//        Collection co = sql.getAll();
//        if (co.size()== 0)
//        {
//            System.out.println("No hay musicas ");
//        }
//        else
//        {
//            Iterator it = co.iterator();
//            while (it.hasNext())
//            {
//                Musica musica = (Musica)it.next();
//                System.out.println("Id: "+ musica.getCodigo());
//                System.out.println("Nombre: "+ musica.getNombre());
//                System.out.println("Genero: "+ musica.getGenero());
//
//            }
//
//        }
    

//        ContenedorDao sql = new ContenedorDaoImp();
//        Collection co = sql.getAll();
//        if (co.size()== 0)
//        {
//            System.out.println("No hay contenedor ");
//        }
//        else
//        {
//            Iterator it = co.iterator();
//            while (it.hasNext())
//            {
//                Contenedor contenedor = (Contenedor)it.next();
//                System.out.println("Id: "+ contenedor.getCodigo());
//                System.out.println("Nombre: " + contenedor.getNombre());
//                System.out.println("Cantidad: "+ contenedor.getCantidad());
//                System.out.println("Id Elemento: "+ contenedor.getElemento().getCodigo());
//
//
//            }
//
//        }
//
//
////
//         CanalDao CanalDao  sql = new CanalDaoImp();
//        Collection co = sql.getAll();
//        if (co.size()== 0)
//        {
//            System.out.println("No existen elementos");
//        }
//        else
//        {
//            Iterator it = co.iterator();
//            while (it.hasNext())
//            {
//                Canal canal = (Canal)it.next();
//                System.out.println("Id: "+ canal.getCodigo());
//                System.out.println("Nombre: "+ canal.getNombre());
//                System.out.println("Frecuencia: "+ canal.getFrecuencia());
//
//
//
//            }
        EstadoAnimDao  sql = new EstadoAnimoDaoImp();
        Collection co = sql.getAll();
        if (co.size()== 0)
        {
            System.out.println("No existen elementos");
        }
        else
        {
            Iterator it = co.iterator();
            while (it.hasNext())
            {
                EstadoAnimo estadoAnimo = (EstadoAnimo)it.next();
                System.out.println("Id: "+ estadoAnimo.getCodigo());
                System.out.println("Nombre: "+ estadoAnimo.getNombre());
                System.out.println("Temperatura Maxima: "+ estadoAnimo.getTempMax());
                System.out.println("Temperatura Minima: "+ estadoAnimo.getTempMin());



            }
        }
    }
    public void TestMarcelo()
    {

//        VentanaNuevaMusica ventana = new VentanaNuevaMusica();
//        ventana.setVisible(true);
//        VentanaAgregarTema ventana = new VentanaAgregarTema();
//        ventana.setVisible(true);
//        
    }

}
