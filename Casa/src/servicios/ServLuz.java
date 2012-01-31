/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import dominio.Comando;
import dominio.Luz;
import dominio.Objeto;
import shell.Kernel;


/**
 *
 * @author Administrador
 */
public class ServLuz extends CommandService
{
    private Kernel kernel;

    public ServLuz(Kernel kernel)
    {
        this.kernel = kernel;
    }

    @Override
    public boolean run(Objeto p, Comando c)
    {
        boolean bandera = true;
        Luz luz;
        try
        {
            luz = (Luz)p;
            //apagar luz
            if(c.getNombre().trim().equals("APAGAR"))
                bandera = this.apagarLuz(luz);
            //cambiar la intensidad de luz
            if(c.getNombre().trim().equals("AJUSTAR"))
                bandera = this.ajustarIntensidad(luz, Integer.parseInt(c.getParmetro().trim()));
            //encender luz
            if(c.getNombre().trim().equals("ENCENDER"))
                bandera = this.encenderLuz(luz);
        }
        catch(Exception e)
        {
            bandera = false;
        }

        return bandera;
    }

    private boolean apagarLuz(Luz l)
    {
        boolean bandera = l.isEstado();
        if(bandera)
        {
            this.kernel.apagarLuz();
            bandera = true;
        }
        else
            bandera = false;
        return bandera;
    }

    private boolean ajustarIntensidad(Luz l, int intensidad)
    {
        boolean bandera = l.isEstado();
        if(bandera)
        {
            l.cambiarIntensidad(intensidad);
            bandera = true;
        }
        else
            bandera = false;
        return bandera;
    }

    private boolean encenderLuz(Luz l)
    {
        boolean bandera = l.isEstado();
        if(!bandera)
        {
            l.cambiarIntensidad(this.kernel.getPerfil().getIntesidadLuz());
            bandera = true;
        }
        else
            bandera = false;
        return bandera;
    }

    

}
