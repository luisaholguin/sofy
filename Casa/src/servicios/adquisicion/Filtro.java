/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios.adquisicion;

//import abstraccionhardware.EmisorAudio;
import dominio.Comando;
import servicios.interprete.AnalizadorLexico;
import servicios.salida.Decodificador;
import shell.Kernel;

/**
 *
 * @author Administrador
 */
public class Filtro
{

    private AnalizadorLexico interprete;
    private Decodificador decodificador;
    private int index = 0;
    private boolean aceptar = false;
    private Comando comando = new Comando();
    private Kernel kernel;

//    public Filtro()
//    {
//    }

    public Filtro(AnalizadorLexico interprete, Kernel kernel, Decodificador decodificador) 
    {
        this.interprete = interprete;
        this.kernel = kernel;
        this.decodificador = decodificador;
    }
    
    
    

    public void filtrar(String palabra)
    {
//        System.out.println("la bandera vale: "+this.aceptar);
        if(this.aceptar)
        {
//            System.out.println("Incrementando el contador");
            this.index++;
//            System.out.println("Ahora vale: "+this.index);
//            System.out.println("Armando el comando");
            this.armarComando(palabra);
        }
        else
        {
            if(palabra.trim().toUpperCase().equals("SOFIA"))
            {
//                System.out.println("Reconocio la palabra clave");
                aceptar = true;
                index = 1;
//                this.emisor.emitirSonido(0);
//                System.out.println("borrando el comando de la interfaz");
                this.kernel.borrarComando();
                this.decodificador.emitirMensaje("inf", 2);
            }
        }

    }
    
    private void armarComando(String palabra)
    {
        if(palabra.trim().toUpperCase().equals("CANCELAR"))
        {
            this.aceptar = false;
            this.decodificador.emitirMensaje("inf", 3);
            this.kernel.borrarComando();
        }
        else
        {
            switch(this.index)
            {
                case 2:
    //                System.out.println("Se esta agregando el nombre de comando");
                    this.comando.setNombre(palabra);
    //                System.out.println("Se escribe la palabra en el jlist");
    //                this.kernel.escribirPalabra(palabra);
    //                System.out.println("Se escribe el comando en el jtext");
                    this.kernel.escribirComando(palabra);
                    break;
                case 3:
                    this.comando.setObjeto(palabra);
    //                this.kernel.escribirPalabra(palabra);
                    this.kernel.escribirObjeto(palabra);
                    //aqui tengo que ver si el comando requiere o no parametros
                    if(!this.interprete.requiereParametros(comando))
                    {
                        this.aceptar = false;
                        this.interprete.setComando(comando);
                        this.interprete.analizarComando(comando);
                    }
                    break;
                case 4:
                    this.kernel.escribirParametros(palabra);
                    this.comando.setParmetro(palabra);
                    this.aceptar = false;
                    this.interprete.setComando(comando);
                    this.interprete.analizarComando(comando);

                    break;
            }
        }
        
        
    }



}
