/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import dominio.Comando;
import dominio.Objeto;
import dominio.Puerta;

/**
 *
 * @author Administrador
 */
public class ServPuerta extends CommandService
{

    public ServPuerta() {
    }


    @Override
    public boolean run(Objeto p, Comando c)
    {
        boolean bandera = true;
        Puerta puerta;
        try
        {
            puerta = (Puerta)p;
            if(c.getNombre().trim().equals("ABRIR"))
                this.abrirPuerta(puerta);
            else
                this.cerrarPuerta(puerta);
        }
        catch(Exception e)
        {
            bandera = false;
        }

        return bandera;
        
    }

    private boolean abrirPuerta(Puerta p)
    {
        boolean bandera = p.isEstado();
        if(!bandera)
        {
            p.abrirPuerta();
            bandera = true;
        }
        else
            bandera = false;
        return bandera;
    }

    public boolean cerrarPuerta(Puerta p)
    {
        boolean bandera = p.isEstado();
        if(bandera)
        {
            p.cerrarPuerta();
            bandera = true;
        }
        else
            bandera = false;
        return bandera;
    }

}
