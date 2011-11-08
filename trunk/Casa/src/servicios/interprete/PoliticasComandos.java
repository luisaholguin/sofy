/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.interprete;

import dao.PerfilDao;
import dao.implementacion.PerfilDaoImp;
import dominio.Comando;
import dominio.Objeto;
import java.util.Collection;
import java.util.Iterator;
import shell.Kernel;

/**
 *
 * @author Administrator
 */
public class PoliticasComandos 
{

    private Kernel kernel;
    
    public PoliticasComandos() 
    {
    }
    
    public PoliticasComandos(Kernel kernel) 
    {
        this.kernel = kernel;
    }
    
    public boolean analisisSintactico (Comando cmd)
    {
        this.kernel.setComando(cmd);
        boolean bandera = false;
        //si el comando ingresado es "ABRIR"
        if(cmd.getNombre().toUpperCase().trim().equals("OPEN"))
            bandera = this.analizarComandoAbrir(cmd);
        if(cmd.getNombre().toUpperCase().trim().equals("CLOSE"))
            bandera = this.analizarComandoCerrar(cmd);
        if(cmd.getNombre().toUpperCase().trim().equals("TURN ON"))
            bandera = this.analizarComandoEncender(cmd);
        if(cmd.getNombre().toUpperCase().trim().equals("TURN OFF"))
            bandera = this.analizarComandoApagar(cmd);
        if(cmd.getNombre().toUpperCase().trim().equals("SET"))
            bandera = this.analizarComandoAjustar(cmd);
        return bandera;
    }
    
    private boolean analizarComandoAbrir(Comando cmd)
    {
        boolean bandera = false;
        if((cmd.getObjeto().trim().toUpperCase().equals("DOOR")) || (cmd.getObjeto().trim().toUpperCase().equals("WINDOW")))
            bandera = true;
        return bandera;
    }
    
    private boolean analizarComandoCerrar(Comando cmd)
    {
        boolean bandera = false;
        if((cmd.getObjeto().trim().toUpperCase().equals("DOOR")) || (cmd.getObjeto().trim().toUpperCase().equals("WINDOW")))
            bandera = true;
        return bandera;
    }
    
    private boolean analizarComandoEncender(Comando cmd)
    {
        boolean bandera = false;
        if((cmd.getObjeto().trim().toUpperCase().equals("STEREO")) || (cmd.getObjeto().trim().toUpperCase().equals("TV")))
            bandera = true;
        return bandera;
    }

    private boolean analizarComandoApagar(Comando cmd)
    {
        boolean bandera = false;
        if((cmd.getObjeto().trim().toUpperCase().equals("STEREO")) || (cmd.getObjeto().trim().toUpperCase().equals("TV")))
            bandera = true;
        return bandera;
    }

    private boolean analizarComandoAjustar(Comando cmd)
    {
        boolean bandera = false;
        if((cmd.getObjeto().trim().toUpperCase().equals("LIGHT")) || (cmd.getObjeto().trim().toUpperCase().equals("TEMPERATURE")) || (cmd.getObjeto().trim().toUpperCase().equals("CHANNEL")) || (cmd.getObjeto().trim().toUpperCase().equals("SONG")) || (cmd.getObjeto().trim().toUpperCase().equals("PROFILE")))
            bandera = true;
        return bandera;
    }
    
    

    
    public boolean analizarParametros(Comando cmd)
    {
        boolean bandera = true;
        if(cmd.getNombre().toUpperCase().trim().equals("SET"))
        {
            //si el objeto que estoy analizando es la luz
            if(cmd.getObjeto().trim().toUpperCase().equals("LIGHT"))
            {
                try
                {
                    int numero = Integer.parseInt(cmd.getParmetro().trim());
                    if((numero > 100) || (numero < 0))
                        bandera = false;
                }
                catch (Exception e)
                {
                    bandera = false;
                }
            }
            //si el objeto que estoy analizando es la temperatura
            if(cmd.getObjeto().trim().toUpperCase().equals("TEMPERATURE"))
            {
                try
                {
                    int numero = Integer.parseInt(cmd.getParmetro().trim());
                    if((numero > 50) || (numero < 0))
                        bandera = false;
                }
                catch (Exception e)
                {
                    bandera = false;
                }
            }
            //si el objeto que estoy analizando es el canal de television
            if(cmd.getObjeto().trim().toUpperCase().equals("CHANNEL"))
            {
                try
                {
                    int numero = Integer.parseInt(cmd.getParmetro().trim());
                    if(numero <= 0)
                        bandera = false;
                }
                catch (Exception e)
                {
                    bandera = false;
                }
            }
            //si el objeto que estoy analizando es una cancion
            if(cmd.getObjeto().trim().toUpperCase().equals("SONG"))
            {
                try
                {
                    int numero = Integer.parseInt(cmd.getParmetro().trim());
                    if(numero <= 0)
                        bandera = false;
                }
                catch (Exception e)
                {
                    bandera = false;
                }
            }
            //si el objeto que estoy analizando es un perfil
            if(cmd.getObjeto().trim().toUpperCase().equals("PROFILE"))
            {
                PerfilDao p = new PerfilDaoImp();
                bandera = p.isPerfil(cmd.getParmetro().trim().toUpperCase());
            }
        }
        return bandera;
    }
    
    public int analisisContextual(Comando cmd)
    {
        int bandera = 0;
        boolean band = true;
        Collection objetos = this.kernel.getObjetos();
        Iterator it = objetos.iterator();
        int contador = 0;
        //verifico que la orden se pueda emitir en el contexto actual
        while(it.hasNext())
        {
            Objeto o = (Objeto)it.next();
//            System.out.println(o.getNombre());
            if(cmd.getObjeto().trim().toUpperCase().equals(o.getNombre().trim().toUpperCase()))
            {
                band = false;
                contador++;
            }
        }
        if(band)
        {
            bandera = 4;
            System.out.println("El objeto de comando no se encuentra en este contexto");
        }
            
        //ahora verifico que si existen dos objetos a los cuales es posible aplicar un comando,
        //en el comando exista un parametro que defina a que objeto aplicarlo
        if(contador > 1)
        {
            try
            {
                int numero = Integer.parseInt(cmd.getParmetro());
                if((numero > 0) && (numero <= contador))
                {
                    bandera = 0;
                    cmd.setParametroRequerido(true);
                    this.kernel.setComando(cmd);
                }
                    
                else
                    bandera = 1;
            }
            catch(Exception e)
            {
                bandera = 1;
            }
        }
        
//        if(bandera == 0)
//            bandera = this.analizarEstadoObjeto(cmd);
        return bandera;
    }
    
    
    public boolean requiereParametros(Comando cmd)
    {
        boolean bandera = true;
        if(cmd.getObjeto().trim().toUpperCase().equals("TV"))
            bandera = false;
        if(cmd.getObjeto().trim().toUpperCase().equals("STEREO"))
            bandera = false;
        return bandera;
    }
    
}
