/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.coordinador;

import dominio.Comando;
import dominio.Objeto;
import dominio.Perfil;
import java.util.Collection;
import java.util.Iterator;
import shell.Kernel;

/**
 *
 * @author Administrator
 */
public class Ejecutor 
{

    public Ejecutor() 
    {
    }
    
    public void ejecutar(Kernel kernel, Comando comando)
    {
//        System.out.println("El comando a ejecutar es: "+comando.getNombre());
        if(comando.getNombre().toUpperCase().trim().equals("OPEN"))
        {
            if(comando.getObjeto().trim().toUpperCase().equals("DOOR")) 
            {
                int contador = 0;
                Iterator it = kernel.getObjetos().iterator();
                int numeroPuerta = 0;
                while(it.hasNext())
                {
                    Objeto o = (Objeto)it.next();
                    if(o.getNombre().trim().toUpperCase().equals(comando.getObjeto().trim().toUpperCase()))
                    {
                        contador++;
                        if(comando.isParametroRequerido())
                        {
                            if(contador == Integer.parseInt(comando.getParmetro()))
                                numeroPuerta = o.getId();
                        }
                        else
                        {
                            numeroPuerta = o.getId();
                            break;
                        }
                    }
                }
                switch(numeroPuerta)
                {
                    case 1:
                            kernel.abrirPuerta1();
                            break;
                    case 2:
                            kernel.abrirPuerta2();
                            break;
                    case 3:
                            kernel.abrirPuerta3();
                            break;
                    case 4:
                            kernel.abrirPuerta4();
                            break;
                    case 5:
                            kernel.abrirPuerta5();
                            break;
                    case 6:
                            kernel.abrirPuerta6();
                            break;
                    case 7:
                            kernel.abrirPuerta7();
                            break;
                }
            }
        
            if(comando.getObjeto().trim().toUpperCase().equals("WINDOW"))
            {
                int contador = 0;
                Iterator it = kernel.getObjetos().iterator();
                int numeroPersiana = 0;
                while(it.hasNext())
                {
                    Objeto o = (Objeto)it.next();
                    if(o.getNombre().trim().toUpperCase().equals(comando.getObjeto().trim().toUpperCase()))
                    {
                        contador++;
                        if(comando.isParametroRequerido())
                        {
                            if(contador == Integer.parseInt(comando.getParmetro()))
                                numeroPersiana = o.getId();
                        }
                        else
                        {
                            numeroPersiana = o.getId();
                            break;
                        }
                    }
                }
                switch(numeroPersiana)
                {
                    case 1:
                            kernel.abrirPersiana1();
                            break;
                    case 2:
                            kernel.abrirPersiana2();
                            break;
                    case 3:
                            kernel.abrirPersiana3();
                            break;
                    case 4:
                            kernel.abrirPersiana4();
                            break;
                }
            }
        }
        //si el comando ingresado es "CERRAR"
        if(comando.getNombre().toUpperCase().trim().equals("CLOSE"))
        {
            if(comando.getObjeto().trim().toUpperCase().equals("DOOR")) 
            {
                int contador = 0;
                Iterator it = kernel.getObjetos().iterator();
                int numeroPuerta = 0;
                while(it.hasNext())
                {
                    Objeto o = (Objeto)it.next();
                    if(o.getNombre().trim().toUpperCase().equals(comando.getObjeto().trim().toUpperCase()))
                    {
                        contador++;
                        if(comando.isParametroRequerido())
                        {
                            if(contador == Integer.parseInt(comando.getParmetro()))
                                numeroPuerta = o.getId();
                        }
                        else
                        {
                            numeroPuerta = o.getId();
                            break;
                        }
                    }
                }
                switch(numeroPuerta)
                {
                    case 1:
                            kernel.cerrarPuerta1();
                            break;
                    case 2:
                            kernel.cerrarPuerta2();
                            break;
                    case 3:
                            kernel.cerrarPuerta3();
                            break;
                    case 4:
                            kernel.cerrarPuerta4();
                            break;
                    case 5:
                            kernel.cerrarPuerta5();
                            break;
                    case 6:
                            kernel.cerrarPuerta6();
                            break;
                    case 7:
                            kernel.cerrarPuerta7();
                            break;
                }
            }
        
            if(comando.getObjeto().trim().toUpperCase().equals("WINDOW"))
            {
            int contador = 0;
            Iterator it = kernel.getObjetos().iterator();
            int numeroPersiana = 0;
            while(it.hasNext())
            {
                Objeto o = (Objeto)it.next();
                if(o.getNombre().trim().toUpperCase().equals(comando.getObjeto().trim().toUpperCase()))
                {
                    contador++;
                    if(comando.isParametroRequerido())
                    {
                        if(contador == Integer.parseInt(comando.getParmetro()))
                            numeroPersiana = o.getId();
                    }
                    else
                    {
                        numeroPersiana = o.getId();
                        break;
                    }
                }
            }
                switch(numeroPersiana)
                {
                    case 1:
                            kernel.cerrarPersiana1();
                            break;
                    case 2:
                            kernel.cerrarPersiana2();
                            break;
                    case 3:
                            kernel.cerrarPersiana3();
                            break;
                    case 4:
                            kernel.cerrarPersiana4();
                            break;
                }
            }
        }
        //si el comando ingresado es "ENCENDER"
        if(comando.getNombre().toUpperCase().trim().equals("TURNON"))
        {
            if(comando.getObjeto().trim().toUpperCase().equals("STEREO"))
                kernel.prenderStereo();
            if(comando.getObjeto().trim().toUpperCase().equals("TV"))
                kernel.prenderTv();
            if(comando.getObjeto().trim().toUpperCase().equals("LIGHT"))
                kernel.encenderLuz();
        }
        //si el comando ingresado es "APAGAR"
        if(comando.getNombre().toUpperCase().trim().equals("TURNOFF"))
        {
            if(comando.getObjeto().trim().toUpperCase().equals("STEREO")) 
                kernel.apagarStereo();
            if(comando.getObjeto().trim().toUpperCase().equals("TV"))
                kernel.apagarTv();
            if(comando.getObjeto().trim().toUpperCase().equals("LIGHT"))
                kernel.apagarLuz();
        }
        //si el comando ingresado es "AJUSTAR"
        if(comando.getNombre().toUpperCase().trim().equals("SET"))
        {
            if(comando.getObjeto().trim().toUpperCase().equals("LIGHT"))
                kernel.setIntesidadLuz(Integer.parseInt(comando.getParmetro()));
            if(comando.getObjeto().trim().toUpperCase().equals("TEMPERATURE"))
                kernel.setTemperatura(Integer.parseInt(comando.getParmetro()));
            if(comando.getObjeto().trim().toUpperCase().equals("CHANNEL"))
                kernel.fijarCanal(Integer.parseInt(comando.getParmetro()));
            if(comando.getObjeto().trim().toUpperCase().equals("SONG"))
                kernel.fijarCancion(Integer.parseInt(comando.getParmetro()));
            if(comando.getObjeto().trim().toUpperCase().equals("PROFILE"))
            {
                Collection perfiles = kernel.getPerfiles();
                Iterator it = perfiles.iterator();
                Perfil p = new Perfil();
                while(it.hasNext())
                {
                    p = (Perfil)it.next();
                    if(p.getNombrePerfil().trim().toUpperCase().equals(comando.getParmetro().trim().toUpperCase()))
                    {
                        System.out.println("El perfil a activar es: "+p.getNombrePerfil());
                        break;
                    }
                        
                }
                kernel.setPerfil(p);
            }
        }
    }
}
