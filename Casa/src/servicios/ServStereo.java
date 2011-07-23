/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import dominio.Comando;
import dominio.Objeto;
import dominio.Stereo;

/**
 *
 * @author Administrador
 */
public class ServStereo extends CommandService
{

    public ServStereo()
    {
    }

    @Override
    public boolean run(Objeto stereo, Comando cmd)
    {
        boolean bandera = true;
        try
        {
            Stereo t = (Stereo)stereo;
            String comando = cmd.getNombre().trim().toUpperCase();
            if(comando.equals("ENCENDER"))
                bandera = this.encender(t);
            if(comando.equals("APAGAR"))
                bandera = this.apagar(t);
            if(comando.equals("REPRODUCIR"))
                bandera = this.reproducir(t, cmd);
        }
        catch(Exception e)
        {
            bandera = false;
        }
        return bandera;
    }

    private boolean encender(Stereo stereo)
    {
        boolean bandera = true;
        if(!stereo.isEstado())
            stereo.encender();
        else
            bandera = false;
        return bandera;
    }

    private boolean apagar(Stereo stereo)
    {
        boolean bandera = true;
        if(stereo.isEstado())
            stereo.apagar();
        else
            bandera = false;
        return bandera;
    }

    private boolean reproducir(Stereo stereo, Comando comando)
    {
        boolean bandera = true;
        if(stereo.isEstado())
            stereo.reproducir();
        else
            bandera = false;
        return bandera;
    }

}
