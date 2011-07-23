/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import dominio.Comando;
import dominio.Objeto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import shell.Kernel;

/**
 *
 * @author Administrador
 */
public class ServiceCoordinator
{

    private Collection serviciosContexto = new ArrayList();
    private Collection serviciosInterprete = new ArrayList();
    private Kernel kernel;

    public ServiceCoordinator(Kernel kernel)
    {
        this.kernel = kernel;
        this.cargarServiciosComando();
    }

    //ejecutar servicios del interprete de comandos
    public void run(Objeto obj, Comando comando)
    {
        Iterator it = this.serviciosInterprete.iterator();
        while(it.hasNext())
        {
            CommandService s = (CommandService)it.next();
            s.run(obj, comando);
        }
    }

    private void cargarServiciosComando()
    {
        CommandService servPuerta = new ServPuerta();
        CommandService servPersiana = new ServPersiana();
        CommandService servLuz = new ServLuz(this.kernel);
        CommandService servTemperatura = new ServTemperatura();
        CommandService servTelevisor = new ServTelevisor();
        CommandService servStereo = new ServStereo();
        this.serviciosInterprete.add(servPuerta);
        this.serviciosInterprete.add(servPersiana);
        this.serviciosInterprete.add(servLuz);
        this.serviciosInterprete.add(servTemperatura);
        this.serviciosInterprete.add(servTelevisor);
        this.serviciosInterprete.add(servStereo);
    }
    

}
