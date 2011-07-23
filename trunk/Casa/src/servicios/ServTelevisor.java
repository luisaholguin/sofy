/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import dominio.Canal;
import dominio.Comando;
import dominio.Objeto;
import dominio.Televisor;
import java.util.Iterator;

/**
 *
 * @author Administrador
 */
public class ServTelevisor extends CommandService
{

    public ServTelevisor()
    {
    }

    @Override
    public boolean run(Objeto televisor, Comando cmd)
    {
        boolean bandera = true;
        try
        {
            Televisor t = (Televisor)televisor;
            String comando = cmd.getNombre().trim().toUpperCase();
            if(comando.equals("ENCENDER"))
                bandera = this.encender(t);
            if(comando.equals("APAGAR"))
                bandera = this.apagar(t);
            if(comando.equals("FIJAR"))
                bandera = this.fijarCanal(t, cmd);
        }
        catch(Exception e)
        {
            bandera = false;
        }
        return bandera;
    }

    private boolean encender(Televisor televisor)
    {
        boolean bandera = true;
        if(!televisor.isEstado())
            televisor.encender();
        else
            bandera = false;
        return bandera;
    }

    private boolean apagar(Televisor televisor)
    {
        boolean bandera = true;
        if(televisor.isEstado())
            televisor.apagar();
        else
            bandera = false;
        return bandera;
    }

    private boolean fijarCanal(Televisor televisor, Comando cmd)
    {
        boolean bandera = false;
        int numero = Integer.parseInt(cmd.getParmetro());
        Iterator it = televisor.getCanales().iterator();
        while(it.hasNext())
        {
            Canal c = (Canal)it.next();
//            System.out.println("Frecuencia: "+c.getFrecuencia()+" nombre: "+c.getNombre());
            if(c.getFrecuencia() == numero)
            {
                televisor.fijarCanal(numero);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

}
