/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios.adquisicion;

import abstraccionhardware.EmisorAudio;
import dominio.Comando;
import servicios.interprete.AnalizadorLexico;

/**
 *
 * @author Administrador
 */
public class Filtro
{

    private AnalizadorLexico interprete = new AnalizadorLexico();
    private EmisorAudio emisor = new EmisorAudio();
    private int index;
    private boolean aceptar = false;
    private Comando comando = new Comando();

    public Filtro()
    {
    }

    public void filtrar(String palabra)
    {
        if(this.aceptar)
        {
            this.index++;
            this.armarComando(palabra);
        }
        else
        {
            if(palabra.trim().toUpperCase().equals("COMPUTADORA"))
            {
                System.out.println("Reconocio computadora");
                aceptar = true;
                index = 1;
                this.emisor.emitirSonido(0);
            }
        }

    }
    
    private void armarComando(String palabra)
    {
        switch(this.index)
        {
            case 2:
                this.comando.setNombre(palabra);
                break;
            case 3:
                this.comando.setObjeto(palabra);
                break;
            case 4:
                this.comando.setParmetro(palabra);
                this.aceptar = false;
                this.interprete.setComando(comando);
                break;
        }
    }



}
