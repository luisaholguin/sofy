/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import dao.CanalDao;
import dao.ContenedorDao;
import dao.ContextoDao;
import dao.ElementoDao;
import dao.EstadoAnimDao;
import dao.IngredienteDao;
import dao.MusicaDao;
import dao.PerfilDao;
import dao.RecetaDao;
import dao.implementacion.CanalDaoImp;
import dao.implementacion.ContenedorDaoImp;
import dao.implementacion.ContextoDaoImp;
import dao.implementacion.ElementoDaoImp;
import dao.implementacion.EstadoAnimoDaoImp;
import dao.implementacion.IngredienteDaoImp;
import dao.implementacion.MusicaDaoImp;
import dao.implementacion.PerfilDaoImp;
import dao.implementacion.RecetaDaoImp;
import dominio.Canal;
import dominio.Contenedor;
import dominio.Contexto;
import dominio.Elemento;
import dominio.EstadoAnimo;
import dominio.Ingrediente;
import dominio.Musica;
import dominio.Perfil;
import dominio.Receta;
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
////
//        ContextoDao  sql = new ContextoDaoImp();
//        Collection co = sql.getAll();
//        System.out.println("El tamaño de la coleccion es: "+ co.size());
//
//        if (co.size()== 0)
//        {
//            System.out.println("No existen elementos");
//        }
//        else
//        {
//            Iterator it = co.iterator();
//            while (it.hasNext())
//            {
//                Contexto contexto = (Contexto)it.next();
//                System.out.println("Id: "+ contexto.getCodigo());
//                System.out.println("Contexto: "+ contexto.getContexto());
//                System.out.println("Coordenada_xn: "+ contexto.getCoordenada_xn());
//                System.out.println("Coordenada_xs: "+ contexto.getCoordenada_xs());
//                System.out.println("Coordenada_ys: "+ contexto.getCoordenada_ys());
//                System.out.println("Coordenada_yn: "+ contexto.getCoordenada_yn());
//
//
//
//            }
//        }

//
        RecetaDao  sql = new RecetaDaoImp();
        Collection co = sql.getAll();
        System.out.println("El tamaño de la coleccion es: "+ co.size());

        if (co.size()== 0)
        {
            System.out.println("No existen ingredientes");
        }
        else
        {
            Iterator it = co.iterator();
            while (it.hasNext())
            {
                Receta receta = (Receta)it.next();
                System.out.println("Id: "+ receta.getCodigo());
                System.out.println("nombre: "+ receta.getNombre());
                System.out.println("instrucciones: "+receta.getInstrucciones() );
                System.out.println("tiempo preparacion: "+ receta.gettiempoPreparado());
                System.out.println("porciones: "+ receta.getPorciones());
                System.out.println("calorias: "+ receta.getCalorias());




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
