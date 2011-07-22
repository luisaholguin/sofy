/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import dominio.Comando;
import dominio.Objeto;
import dominio.Persiana;

/**
 *
 * @author Administrador
 */
public class ServPersiana extends CommandService
{

    public ServPersiana()
    {
    }


    
    @Override
    public boolean run(Objeto persiana, Comando cmd)
    {
        boolean bandera = true;
        try
        {
            Persiana p = (Persiana)persiana;
            String comando = cmd.getNombre().trim().toUpperCase();
            if(comando.equals("ABRIR"))
                bandera = this.abrirPersiana(p);
            if(comando.equals("CERRAR"))
                bandera = this.cerrarPersiana(p);
        }
        catch(Exception e)
        {
            bandera = false;
        }
        return bandera;
    }

    private boolean abrirPersiana(Persiana persiana)
    {
        boolean bandera = persiana.isEstado();
        if(!bandera)
        {
            persiana.abrirPersiana();
            bandera = true;
        }
        else
            bandera = false;
        return bandera;
    }

    private boolean cerrarPersiana(Persiana persiana)
    {
        boolean bandera = persiana.isEstado();
        if(bandera)
        {
            persiana.cerrarPersiana();
            bandera = true;
        }
        else
            bandera = false;
        return bandera;
    }

}
