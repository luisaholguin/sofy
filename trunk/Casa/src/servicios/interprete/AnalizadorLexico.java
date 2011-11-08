/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios.interprete;

import dominio.Comando;
import servicios.coordinador.Coordinador;
import servicios.salida.Decodificador;

/**
 *
 * @author Administrador
 */
public class AnalizadorLexico
{
    private Comando comando;
    private PoliticasComandos politicas;
    private Decodificador decodificador;
    private Coordinador coordinador;

    public AnalizadorLexico() 
    {
    }

    public AnalizadorLexico(PoliticasComandos politicas, Decodificador decodificador, Coordinador coordinador) 
    {
        this.politicas = politicas;
        this.decodificador = decodificador;
        this.coordinador = coordinador;
    }
    
    

    public Comando getComando() 
    {
        return comando;
    }

    public void setComando(Comando comando) {
        this.comando = comando;
//        System.out.println("Nombre: "+comando.getNombre());
//        System.out.println("Objeto: "+comando.getObjeto());
//        System.out.println("Parametro: "+comando.getParmetro());
        //
    }
    
    public void analizarComando(Comando cmd)
    {
        
        if(this.analisisSintactico(cmd))
        {
//            System.out.println("paso el test sintactico");
            if(this.analisisContextual(cmd))
            {
                System.out.println("paso el test contextual");
                this.coordinador.analisisEstado(cmd);
            }
            else
                System.out.println("No paso el analisis contextual");
        }
        else
        {
//            System.out.println("No paso el analisis sintactico");
            System.out.println("Comando rechazado");
        }
    }
    
    private boolean analisisSintactico(Comando cmd)
    {
        boolean bandera = this.politicas.analisisSintactico(cmd);
        if(!bandera)
            this.decodificador.emitirMensaje("err", 2);
        else
        {
            bandera = this.politicas.analizarParametros(cmd);
            if(!bandera)
                this.decodificador.emitirMensaje("err", 1);
        }
        return bandera;
    }
    
    private boolean analisisContextual(Comando cmd)
    {
        boolean bandera = true;
        int respuesta = this.politicas.analisisContextual(cmd);
        if(respuesta != 0)
        {
            bandera = false;
            this.decodificador.emitirMensaje("err", respuesta);
        }
            
        return bandera;
    }
   
    public boolean requiereParametros(Comando cmd)
    {
        return this.politicas.requiereParametros(cmd);
    }

}
