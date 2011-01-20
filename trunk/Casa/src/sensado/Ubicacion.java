/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensado;

import contexto.ActualizadorContexto;
import shell.Kernel;

/**
 *
 * @author Marcelo
 */
public class Ubicacion implements Lectura
{
    private ActualizadorContexto observado = new ActualizadorContexto();
    private Kernel kernel;


    public Ubicacion(Kernel kernel)
    {
        this.kernel = kernel;
        this.observado = this.kernel.getObservado();
    }

    

    public void lectura(SensingConsern valor)
    {
        this.observado.notifyObserver(valor.getPosicion());
    }



}
