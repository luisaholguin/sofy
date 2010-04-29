/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package habstraccionhardware;

import contexto.ActualizadorContexto;
import contexto.ContextoCocina;
import contexto.ContextoComedor;
import contexto.ContextoHabitacion;
import controlador.PerfilInt;
import controlador.implementacion.PerfilImp;
import dao.ContextoDao;
import dao.implementacion.ContextoDaoImp;
import dominio.Contexto;
import dominio.Posicion;
import java.util.ArrayList;
import java.util.Collection;
import sensado.Lectura;
import sensado.Perfil;
//import dominio.Perfil;
import sensado.Peso;
import sensado.SensingConsern;
import sensado.Ubicacion;
import servicios.ServiciosCocina;
import servicios.ServiciosComedor;
import servicios.ServiciosHabitacion;


/**
 *
 * @author Marcelo
 */
public class Kernel
{
    private VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this);
    private VentanaResultados ventanaResultados = new VentanaResultados();
    private VentanaSensor ventanaSensor = new VentanaSensor(this);
    private SensingConsern sensingConsern;
    private VentanaSalidaHeladera heldera = new VentanaSalidaHeladera(this);
    private VentanaSalidaTelevisor televisor = new VentanaSalidaTelevisor(this);

    //sensores
    private Perfil sensorPerfil = new Perfil(this);
    private Ubicacion ubicacion;
    private Peso sensorPeso = new Peso();

    private dominio.Perfil perfil = new dominio.Perfil();

    //servicios
    private ServiciosCocina serviciosCocina = new ServiciosCocina(this);
    private ServiciosComedor serviciosComedor = new ServiciosComedor(this);
    private ServiciosHabitacion servisioHabitacion = new ServiciosHabitacion(this);

    //contextos
    private ActualizadorContexto observado = new ActualizadorContexto();;
    private ContextoCocina cocina;
    private ContextoHabitacion habitacion;
    private ContextoComedor comedor;

    //colecciones
    private Collection recetas = new ArrayList();
    private Collection canales = new ArrayList();



    public Kernel()
    {

    }

    public void inicializar()
    {
        ventanaPrincipal.setVisible(true);
        ventanaResultados.setVisible(true);
        ventanaSensor.setVisible(true);
        this.ubicacion = new Ubicacion(this);
        this.cocina = new ContextoCocina(this);
        this.habitacion = new ContextoHabitacion(this);
        this.comedor = new ContextoComedor(this);
        this.cargarContextos();
        this.sensingConsern = new SensingConsern(this);
        this.agregarObservadoresPerfil();
//        this.serviciosCocina = new ServiciosCocina(this);
        //cargar el perfil por defecto
        PerfilInt sql = new PerfilImp();
        this.perfil = sql.getPerfil("DEFECTO");
        this.sensorPerfil.notifyObserver(new Posicion());
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

    private void agregarObservadoresPerfil()
    {
        this.sensorPerfil.addObserver(this.serviciosCocina);
        this.sensorPerfil.addObserver(this.serviciosComedor);
        this.sensorPerfil.addObserver(this.servisioHabitacion);
    }
    

    public void cambiarPosicion(int x, int y)
    {
        sensingConsern.setPosicion(x, y);
    }

    public void mostrarHeladera(boolean o)
    {
        this.heldera.setVisible(o);
    }

    public void mostrarTelevisor(boolean o)
    {
        this.televisor.setVisible(o);
    }

    public void setRecetas(Collection recetas)
    {
        this.recetas = recetas;
        this.heldera.setRecetas(recetas);
    }

    public void setCanales(Collection canales)
    {
        this.canales = canales;
        this.televisor.setCanales(canales);
    }

    public dominio.Perfil getPerfil()
    {
        return perfil;
    }

    public void setPerfil(dominio.Perfil perfil)
    {
        this.perfil = perfil;
    }

    public Ubicacion getUbicacion()
    {
        return ubicacion;
    }

    public ActualizadorContexto getObservado()
    {
        return this.observado;
    }

    public Perfil getSensorPerfil()
    {
        return this.sensorPerfil;
    }

    public void escribirMensaje()
    {
        System.out.println("Soy el Kernel");
    }

    public void setTemperatura(double temperatura)
    {
        this.sensingConsern.setTemperatura(temperatura);
    }
    

}
