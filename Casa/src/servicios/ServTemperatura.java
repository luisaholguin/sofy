/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import dominio.Comando;
import dominio.Objeto;
import dominio.Temperatura;

/**
 *
 * @author Administrador
 */
public class ServTemperatura extends CommandService
{
    

    public ServTemperatura()
    {
    }

    @Override
    public boolean run(Objeto temperatura, Comando cmd)
    {
        boolean bandera = true;
        try
        {
            Temperatura t = (Temperatura)temperatura;
            String comando = cmd.getNombre().trim().toUpperCase();
            if(comando.equals("AJUSTAR"))
                bandera = this.ajustarTemperatura(t, cmd);
        }
        catch(Exception e)
        {
            bandera = false;
        }
        return bandera;
    }

    private boolean ajustarTemperatura(Temperatura t, Comando c)
    {
        int valor = Integer.parseInt(c.getParmetro());
        return t.cambiarTemperatura(valor);
    }

}
