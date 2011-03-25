/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios.interprete;

import dominio.Comando;

/**
 *
 * @author Administrador
 */
public class AnalizadorLexico
{
    private Comando comando;

    public AnalizadorLexico() {
    }

    public Comando getComando() {
        return comando;
    }

    public void setComando(Comando comando) {
        this.comando = comando;
        System.out.println("Nombre: "+comando.getNombre());
        System.out.println("Objeto: "+comando.getObjeto());
        System.out.println("Parametro: "+comando.getParmetro());
    }



}
