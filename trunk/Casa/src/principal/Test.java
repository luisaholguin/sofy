/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import controlador.RecetaInt;
import controlador.implementacion.RecetaImp;
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
import java.util.ArrayList;
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
//
        Receta receta = new Receta();
        receta.setNombre("Tarta de manzanas");
        receta.setCategoria("postres");
        receta.settiempoPreparado("30 min");
        receta.setInstrucciones("mezclar ingredientes, horno a 45°C.Retirar ");
        receta.setCalorias(3200);
        receta.setPorciones(8);

        Collection ingredientes = new ArrayList();
        ElementoDao sql = new ElementoDaoImp();
        Elemento e1 = sql.get(1);
        Ingrediente i1 = new Ingrediente();
        i1.setElemento(e1);
        i1.setUnidades(3);
        i1.setSeleccion(2);
        ingredientes.add(i1);

        Elemento e2 = sql.get(2);
        Ingrediente i2 = new Ingrediente();
        i2.setElemento(e2);
        i2.setCucharadas(5);
        i2.setSeleccion(0);
        ingredientes.add(i2);

        Elemento e3 = sql.get(3);
        Ingrediente i3 = new Ingrediente();
        i3.setElemento(e3);
        i3.setUnidades(8);
        i3.setSeleccion(2);
        ingredientes.add(i3);

        receta.setIngrediente(ingredientes);
        RecetaInt re = new RecetaImp();
        re.guardar(receta);


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
