/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.coordinador;

import dominio.Canal;
import dominio.Cancion;
import dominio.Comando;
import java.util.Iterator;
import servicios.salida.Decodificador;
import shell.Kernel;

/**
 *
 * @author Administrator
 */
public class Coordinador 
{
    
    private Ejecutor ejecutor;
    private Decodificador decodificador;
    private Kernel kernel;

    public Coordinador() 
    {
    }

    public Coordinador(Ejecutor ejecutor, Decodificador decodificador, Kernel kernel) {
        this.ejecutor = ejecutor;
        this.decodificador = decodificador;
        this.kernel = kernel;
    }
    
    

    public Coordinador(Ejecutor ejecutor, Decodificador decodificador) 
    {
        this.ejecutor = ejecutor;
        this.decodificador = decodificador;
    }
    
    public void analisisEstado(Comando comando)
    {
        int codigo = this.analizarEstadoObjeto(comando);
        if(codigo != 0)
            this.decodificador.emitirMensaje("err", codigo);
        else
        {
            this.decodificador.emitirMensaje("inf", 1);
            this.ejecutor.ejecutar(kernel, kernel.getComando());
        }
    }
    
    private int analizarEstadoObjeto(Comando cmd)
    {
        int codigo = 0;
        if(cmd.getNombre().trim().toUpperCase().equals("TURN ON"))
        {
            if(cmd.getObjeto().trim().toUpperCase().equals("STEREO"))
                if(this.kernel.getStereo().isEstado())
                    codigo = 5;
            if(cmd.getObjeto().trim().toUpperCase().equals("TV"))
                if(this.kernel.getTelevisor().isEstado())
                    codigo = 7;
        }
        if(cmd.getNombre().trim().toUpperCase().equals("TURN OFF"))
        {
            if(cmd.getObjeto().trim().toUpperCase().equals("STEREO"))
                if(!this.kernel.getStereo().isEstado())
                    codigo = 6;
            if(cmd.getObjeto().trim().toUpperCase().equals("TV"))
                if(!this.kernel.getTelevisor().isEstado())
                    codigo = 8;
        }
        if(cmd.getNombre().trim().toUpperCase().equals("SET"))
        {
            if(cmd.getObjeto().trim().toUpperCase().equals("CHANNEL"))
            {
                //me fijo si el televisor esta encendido
                if(!this.kernel.getTelevisor().isEstado())
                    codigo = 8;
                else
                {
                    //si el televisor esta encendido me fijo si el canal que el usuario quiere ver
                    //esta disponible.
                    boolean band = false;
                    Iterator it = this.kernel.getCanales().iterator();
                    while(it.hasNext())
                    {
                        Canal c = (Canal)it.next();
                        if(c.getFrecuencia() == Integer.parseInt(cmd.getParmetro()))
                            band = true;
                        c = null;
                    }
                    it = null;
                    if(!band)
                        codigo = 9;
                }
            }
            if(cmd.getObjeto().trim().toUpperCase().equals("SONG"))
            {
                //pregunto si el estereo esta encendido
                if(!this.kernel.getStereo().isEstado())
                    codigo = 6;
                else
                {
                    //si el estereo esta encendido me fijo si la cancion que el usuario desea reproducir
                    //esta disponible
                    boolean band = false;
                    Iterator it = this.kernel.getCanciones().iterator();
                    while(it.hasNext())
                    {
                        Cancion c = (Cancion)it.next();
                        if(c.getCodigo() == Integer.parseInt(cmd.getParmetro()))
                            band = true;
                        c = null;
                    }
                    it = null;
                    if(!band)
                        codigo = 10;
                }
            }
        }
        return codigo;
    }
    
}
