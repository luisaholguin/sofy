/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import abstraccionhardware.Kernel;


/**
 *
 * @author marcelo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
//        Canal canal = new Canal();
//        canal.setCodigo(3);
//        canal.setFrecuencia(6);
//        canal.setNombre("Cosmopolitan");
        
//        CanalDao sql = new CanalDaoImp();
//        Canal canal = sql.get(1);
//        if(canal.getCodigo() == 0)
//        {
//            System.out.println("No existe el canal");
//        }
//        else
//        {
//            System.out.println("El canal existe y los datos son");
//            System.out.println("Nombre: "+ canal.getNombre());
//            System.out.println("Frecuencia: "+ canal.getFrecuencia());
//        }
//        

       
//       Elemento elemento = new Elemento();
//        elemento.setCodigo(4);
//        elemento.setNombre("Merengada");
//        elemento.setTipo("lacteos");
//                
//               
//       // ElementoDao sql = new ElementoDaoImp();
        //sql.borrar(elemento);
//       
//         Contenedor contenedor = new Contenedor();
//         contenedor.setCodigo(3);
//         contenedor.setElemento(elemento);
//         contenedor.setCantidad(20);
//      
//      
        
         
    /* 
       EstadoAnimo estadoAnimo = new EstadoAnimo();

        estadoAnimo.setCodigo(5);
        estadoAnimo.setNombre("feliz");
        estadoAnimo.setTempMax(41);
        estadoAnimo.setTempMin(12);   
     
                
        EstadoAnimDao sql  = new EstadoAnimoDaoImp();
        sql.borrar(estadoAnimo);
       
    */
     /*  Contexto contexto = new Contexto();
        contexto.setContexto("Comedor");
        contexto.setCoordenada_xn(1);
        contexto.setCoordenada_xs(5);
        contexto.setCoordenada_yn(1);
        contexto.setCoordenada_ys(8);
        contexto.setCodigo(3);
     
   */
     
      // TemasPerfilesDao sql = new TemasPerfilesDaoImp();
       //sql.borrar(2);
     //  RecetasPerfilesDao sql = new RecetasPerfilesDaoImp();
      // sql.borrar(1);
      // RecetasIngredientesDao sql = new RecetasIngredientesDaoImp();
      
     //   sql.borrar(2);
        
              
     //  ContextoDao sql = new ContextoDaoImp();
      //   sql.borrar(contexto);
     
    
//     Ingrediente ingrediente = new Ingrediente();
//    
//         
//         ingrediente.setCodigo(5);
//         ingrediente.setCucharadas(9);
//        ingrediente.setElemento(elemento);
//        ingrediente.setPeso(8.9);
//        ingrediente.setTazas(9);
//        ingrediente.setSeleccion(3);
//        ingrediente.setUnidades(9);
//       
//      
//        RecetaDao sql = new RecetaDaoImp();
//        Receta receta = sql.get(4);
//        if (receta.getCodigo()== 0 )
//        {
//            System.out.println("La receta no existe");
//        }
//        else 
//        {
//            System.out.println("Id: "+ receta.getCodigo());
//            System.out.println("nombre:"+ receta.getNombre());
//            System.out.println("instrucciones: "+ receta.getInstrucciones());
//            System.out.println("tiempo de preparacion: "+ receta.gettiempoPreparado());
//            System.out.println("porciones: "+ receta.getPorciones());
//            System.out.println("calorias: "+ receta.getCalorias());
//                                               
//        }
        
//    
//        EstadoAnimDao sql = new EstadoAnimoDaoImp();
//        EstadoAnimo estadoAnimo = sql.get(44);
//        if ( estadoAnimo.getCodigo() == 0)
//        {
//            System.out.println("El estado de animo es inexistente ");
//        }
//        else
//        {
//            System.out.println("El estado de animo existe y los datos son: ");
//            System.out.println("Id : "+ estadoAnimo.getCodigo());
//            System.out.println("Nombre: " + estadoAnimo.getNombre());
//            System.out.println("Temperatura Maxima: " + estadoAnimo.getTempMax());
//            System.out.println("Temperatura Minima: "+ estadoAnimo.getTempMin());
//
//        }
//
        
                
        
      /*  Perfil perfil = new Perfil();
        perfil.setEstadoAnimo(estadoAnimo);
        perfil.setNombre("fiesta");
        perfil.setIntesidadLuz(1);
        perfil.setCategoria("Dversion");
        perfil.setCodigo(15);
       */
        //ContextoDao sql = new ContextoDaoImp();
         //sql.modificar(contexto);
       
      // PerfilDao sql = new PerfilDaoImp();
       // sql.borrar(perfil);
        
   
//        Receta receta = new Receta();
//        receta.setNombre("Gelatina");
//        receta.setInstrucciones("Mezclar todo");
//        receta.settiempoPreparado("45 min");
//        receta.setPorciones(8);
//        receta.setCalorias(200);
//        receta.setCodigo(1);
//        RecetaDao sql = new RecetaDaoImp();
//        sql.borrar(receta);
//        
    
     /*   Musica musica = new Musica();
        musica.setGenero("Romantico");
        musica.setNombre("ayer");
        musica.setCodigo(1);
        MusicaDao sql = new MusicaDaoImp();
        sql.borrar(musica);
       
      */ 
      // 
//        CanalesPerfilesDao sql = new CanalesPerfilesDaoImp();
//        System.out.println(sql.get)
//     //  RecetasIngredientesDao sql = new RecetasIngredientesDaoImp();
       //sql.modificar(1, 4, 2);
      //  ContenedorDao sql = new ContenedorDaoImp();
      //  sql.borrar(contenedor);
//      
//
//        Test test = new Test();
//        test.testCaro();
//        test.TestMarcelo();


        
        Kernel k = new Kernel();
        k.inicializar();
    }

}
