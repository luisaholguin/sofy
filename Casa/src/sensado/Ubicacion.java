/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sensado;

import contexto.ActualizadorContexto;
import contexto.ContextoCocina;
import contexto.ContextoComedor;
import contexto.ContextoHabitacion;
import dao.ContextoDao;
import dao.implementacion.ContextoDaoImp;
import dominio.Contexto;

/**
 *
 * @author Marcelo
 */
public class Ubicacion implements Lectura
{
    private ActualizadorContexto observado;
    private ContextoCocina cocina;
    private ContextoHabitacion habitacion;
    private ContextoComedor comedor;


    public Ubicacion()
    {
        this.observado = new ActualizadorContexto();
        this.cocina = new ContextoCocina();
        this.habitacion = new ContextoHabitacion();
        this.comedor = new ContextoComedor();
        this.cargarContextos();
    }

    private void cargarContextos()
    {
        ContextoDao sql = new ContextoDaoImp();
        Contexto c = sql.get("COCINA");
        this.cocina.setCodigo(c.getCodigo());
        this.cocina.setContexto(c.getContexto());
        this.cocina.setCoordenada_xn(c.getCoordenada_xn());
        this.cocina.setCoordenada_xs(c.getCoordenada_xs());
        this.cocina.setCoordenada_yn(c.getCoordenada_yn());
        this.cocina.setCoordenada_ys(c.getCoordenada_ys());

        c = sql.get("HABITACION");
        this.habitacion.setCodigo(c.getCodigo());
        this.habitacion.setContexto(c.getContexto());
        this.habitacion.setCoordenada_xn(c.getCoordenada_xn());
        this.habitacion.setCoordenada_xs(c.getCoordenada_xs());
        this.habitacion.setCoordenada_yn(c.getCoordenada_yn());
        this.habitacion.setCoordenada_ys(c.getCoordenada_ys());
        
        c = sql.get("COMEDOR");
        this.comedor.setCodigo(c.getCodigo());
        this.comedor.setContexto(c.getContexto());
        this.comedor.setCoordenada_xn(c.getCoordenada_xn());
        this.comedor.setCoordenada_xs(c.getCoordenada_xs());
        this.comedor.setCoordenada_yn(c.getCoordenada_yn());
        this.comedor.setCoordenada_ys(c.getCoordenada_ys());

        this.observado.addObserver(this.cocina);
        this.observado.addObserver(this.habitacion);
        this.observado.addObserver(this.comedor);
    }

    public void lectura(SensingConsern valor)
    {
        this.observado.notifyObserver(valor.getPosicion());
    }

}
