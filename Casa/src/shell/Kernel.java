/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shell;

import abstraccionhardware.VentanaPrincipal;
import abstraccionhardware.VentanaResultados;
import abstraccionhardware.VentanaSalidaHeladera;
import abstraccionhardware.VentanaSalidaMusica;
import abstraccionhardware.VentanaSalidaTelevisor;
import abstraccionhardware.VentanaSensor;
import contexto.ActualizadorContexto;
import contexto.ContextoCocina;
import contexto.ContextoComedor;
import contexto.ContextoHabitacion;
import controlador.PerfilInt;
import controlador.implementacion.PerfilImp;
import dao.ContextoDao;
import dao.implementacion.ContextoDaoImp;
import dominio.Contexto;
import dominio.Luz;
import dominio.Persiana;
import dominio.Posicion;
import dominio.Puerta;
import dominio.Temperatura;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import sensado.Perfil;
import sensado.Peso;
import sensado.SensingConsern;
import sensado.Ubicacion;
import servicios.ServiceCoordinator;
import servicios.ServiciosCocina;
import servicios.ServiciosComedor;
import servicios.ServiciosHabitacion;


/**
 *
 * @author Marcelo
 */
public class Kernel
{

    //puertas
    private Puerta puerta1 = new Puerta();
    private Puerta puerta2 = new Puerta();
    private Puerta puerta3 = new Puerta();
    private Puerta puerta4 = new Puerta();
    private Puerta puerta5 = new Puerta();
    private Puerta puerta6 = new Puerta();
    private Puerta puerta7 = new Puerta();


    //persianas
    private Persiana persiana1 = new Persiana();
    private Persiana persiana2 = new Persiana();
    private Persiana persiana3 = new Persiana();
    private Persiana persiana4 = new Persiana();

    //focos
    private Luz foco1 = new Luz();
    private Luz foco2 = new Luz();
    private Luz foco3 = new Luz();

    //Temperatura
    private Temperatura temperatura = new Temperatura();

    //ventanas
    private VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this);
    private VentanaResultados ventanaResultados = new VentanaResultados(this);
//    private VentanaSensor ventanaSensor = new VentanaSensor(this);
    private SensingConsern sensingConsern;
    private VentanaSalidaHeladera heldera = new VentanaSalidaHeladera(this);
    private VentanaSalidaTelevisor televisor = new VentanaSalidaTelevisor(this);
    private VentanaSalidaMusica musica = new VentanaSalidaMusica(this);

    //sensores
    private Perfil sensorPerfil = new Perfil(this);
    private Ubicacion ubicacion;
    private Peso sensorPeso = new Peso();

    private dominio.Perfil perfil = new dominio.Perfil();

    //servicios
    private ServiciosCocina serviciosCocina = new ServiciosCocina(this);
    private ServiciosComedor serviciosComedor = new ServiciosComedor(this);
    private ServiciosHabitacion servisioHabitacion = new ServiciosHabitacion(this);
    private ServiceCoordinator serviceCoordinator = new ServiceCoordinator(this);

    //contextos
    private ActualizadorContexto observado = new ActualizadorContexto();;
    private ContextoCocina cocina;
    private ContextoHabitacion habitacion;
    private ContextoComedor comedor;

    //colecciones
    private Collection recetas = new ArrayList();
    private Collection canales = new ArrayList();
    private Collection temas = new ArrayList();
    private Collection perfiles = new ArrayList();

    //Shell
//    private Shell shell = new Shell(this);



    public Kernel()
    {

    }

    public void inicializar()
    {
        this.setPuertas();
        this.setPersianas();
        this.setFocos();
        this.setTemperatura();

        ventanaPrincipal.setVisible(true);
        
//        ventanaSensor.setVisible(true);
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
        this.perfiles = sql.getAll();
        ventanaResultados.inicializar(perfiles);
        this.setPerfil(this.ventanaResultados.buscarPerfil("FIESTA"));
//        ventanaResultados.setVisible(true);
        this.sensorPerfil.notifyObserver(new Posicion());
//        this.shell.start();
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

    public void mostrarTemas(boolean o)
    {
        this.musica.setVisible(o);
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

    public void setTemas(Collection temas)
    {
        this.temas = temas;
        this.musica.setTemas(temas);
    }

    public dominio.Perfil getPerfil()
    {
        return perfil;
    }

    public void setPerfil(dominio.Perfil perfil)
    {
        this.perfil = perfil;
        this.sensorPerfil.lectura();
        this.ventanaPrincipal.setCarita(perfil.getCarita());
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

    public void setTemperatura(int temperatura)
    {
        this.sensingConsern.setTemperatura(temperatura);
    }

    public Temperatura getTemperatura()
    {
        return this.temperatura;
    }

    public void setPeso()
    {
        this.sensingConsern.setPeso(0.0);
    }

    public ServiciosCocina getServiciosCocina() {
        return serviciosCocina;
    }
    
    public void updateContenedores()
    {
        this.serviciosCocina.updateContenedor();
        this.setPeso();
    }

    public void setIntesidadLuz(int luz)
    {
        this.ventanaPrincipal.setIntesidadLuz(luz);
    }

    public Collection getPerfiles() {
        return perfiles;
    }

    private void setPuertas()
    {
        this.puerta1.setEstado(true);
        this.puerta1.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta1());
        this.puerta1.setForma(1);
        this.puerta1.setNumeroPuerta(1);
        this.puerta1.setId(1);
        
        this.puerta2.setEstado(true);
        this.puerta2.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta2());
        this.puerta2.setForma(1);
        this.puerta2.setNumeroPuerta(2);
        this.puerta2.setId(2);

        this.puerta3.setEstado(true);
        this.puerta3.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta3());
        this.puerta3.setForma(1);
        this.puerta3.setNumeroPuerta(3);
        this.puerta3.setId(3);

        this.puerta4.setEstado(true);
        this.puerta4.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta4());
        this.puerta4.setForma(3);
        this.puerta4.setNumeroPuerta(4);
        this.puerta4.setId(4);

        this.puerta5.setEstado(true);
        this.puerta5.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta5());
        this.puerta5.setForma(2);
        this.puerta5.setNumeroPuerta(5);
        this.puerta5.setId(5);

        this.puerta6.setEstado(true);
        this.puerta6.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta6());
        this.puerta6.setForma(2);
        this.puerta6.setNumeroPuerta(6);
        this.puerta6.setId(6);

        this.puerta7.setEstado(true);
        this.puerta7.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta7());
        this.puerta7.setForma(4);
        this.puerta7.setNumeroPuerta(7);
        this.puerta7.setId(7);
    }

    private void setPersianas()
    {
        this.persiana1.setEstado(true);
        this.persiana1.setLabelVentana(this.ventanaPrincipal.getjLabelVentana1());
        this.persiana1.setVertical(true);
        this.persiana1.setNumeroPersiana(1);
        this.persiana1.setId(1);

        this.persiana2.setEstado(true);
        this.persiana2.setLabelVentana(this.ventanaPrincipal.getjLabelVentana2());
        this.persiana2.setVertical(true);
        this.persiana2.setNumeroPersiana(2);
        this.persiana2.setId(2);

        this.persiana3.setEstado(true);
        this.persiana3.setLabelVentana(this.ventanaPrincipal.getjLabelVentana3());
        this.persiana3.setVertical(true);
        this.persiana3.setNumeroPersiana(3);
        this.persiana3.setId(3);

        this.persiana4.setEstado(true);
        this.persiana4.setLabelVentana(this.ventanaPrincipal.getjLabelVentana4());
        this.persiana4.setVertical(false);
        this.persiana4.setNumeroPersiana(4);
        this.persiana4.setId(4);
    }

    private void setFocos()
    {
        this.foco1.setEncendida(false);
        this.foco1.setId(1);
        this.foco1.setNumeroFoco(1);
        this.foco1.setSlider(this.ventanaPrincipal.getMedidorLuz());
        this.foco1.setIntensidad(0);

        this.foco2.setEncendida(false);
        this.foco2.setId(2);
        this.foco2.setNumeroFoco(2);
        this.foco2.setSlider(this.ventanaPrincipal.getMedidorLuz());
        this.foco2.setIntensidad(0);

        this.foco3.setEncendida(false);
        this.foco3.setId(3);
        this.foco3.setNumeroFoco(3);
        this.foco3.setSlider(this.ventanaPrincipal.getMedidorLuz());
        this.foco3.setIntensidad(0);
    }

    private void setTemperatura()
    {
        this.temperatura.setSlider(this.ventanaPrincipal.getjSliderTemperatura());
        this.temperatura.setId(1);
    }

//    private void inicializarPuertas()
//    {
//        ImageIcon i = createImageIcon("/imagenes/Puerta Arriba Abierta.jpg");
//        //poner imagen a puerta 1
//        ImageIcon tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelPuerta1.getWidth(), this.jLabelPuerta1.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelPuerta1.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelPuerta1(jLabelPuerta1);
//        //poner imagen puerta 2
//        tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelPuerta2.getWidth(), this.jLabelPuerta2.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelPuerta2.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelPuerta2(jLabelPuerta2);
//        //poner imagen puerta 3
//        tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelPuerta3.getWidth(), this.jLabelPuerta3.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelPuerta3.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelPuerta3(jLabelPuerta3);
//        i = createImageIcon("/imagenes/Puerta Abajo Abierta.jpg");
//        tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelPuerta4.getWidth(), this.jLabelPuerta4.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelPuerta4.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelPuerta4(jLabelPuerta4);
//        i = createImageIcon("/imagenes/Puerta Izquierda Abierta.jpg");
//        tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelPuerta5.getWidth(), this.jLabelPuerta5.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelPuerta5.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelPuerta5(jLabelPuerta5);
//        this.jLabelPuerta6.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelPuerta6(jLabelPuerta6);
//        i = createImageIcon("/imagenes/Puerta Doble Abierta.jpg");
//        tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelPuerta7.getWidth(), this.jLabelPuerta7.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelPuerta7.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelPuerta7(jLabelPuerta7);
//    }
//
//    private void inicializarPersianas()
//    {
//        ImageIcon i = createImageIcon("/imagenes/Ventana Vertical Cerrada.jpg");
//        ImageIcon tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelVentana1.getWidth(), this.jLabelVentana1.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelVentana1.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelVentana1(jLabelVentana1);
//        tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelVentana2.getWidth(), this.jLabelVentana2.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelVentana2.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelVentana2(jLabelVentana2);
//        tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelVentana3.getWidth(), this.jLabelVentana3.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelVentana3.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelVentana3(jLabelVentana3);
//        i = createImageIcon("/imagenes/Ventana Horizontal Cerrada.jpg");
//        tmpIcon = new ImageIcon(i.getImage().getScaledInstance(this.jLabelVentana4.getWidth(), this.jLabelVentana4.getHeight(), Image.SCALE_DEFAULT));
//        this.jLabelVentana4.setIcon(tmpIcon);
//        this.ventanaPrincipal.setjLabelVentana4(jLabelVentana4);
//    }

    protected static ImageIcon createImageIcon(String path)
    {
        //FrmLogin es el nombre de la clase
        java.net.URL imgURL = VentanaPrincipal.class.getResource(path);
//        System.out.println("Path:" + imgURL.getPath());
        if (imgURL != null)
            return new ImageIcon(imgURL);
        else
            return null;
    }

    public Persiana getPersiana1() {
        return persiana1;
    }

    public Persiana getPersiana2() {
        return persiana2;
    }

    public Persiana getPersiana3() {
        return persiana3;
    }

    public Persiana getPersiana4() {
        return persiana4;
    }

    public Puerta getPuerta1() {
        return puerta1;
    }

    public Puerta getPuerta2() {
        return puerta2;
    }

    public Puerta getPuerta3() {
        return puerta3;
    }

    public Puerta getPuerta4() {
        return puerta4;
    }

    public Puerta getPuerta5() {
        return puerta5;
    }

    public Puerta getPuerta6() {
        return puerta6;
    }

    public Puerta getPuerta7() {
        return puerta7;
    }

    public ServiceCoordinator getServiceCoordinator() {
        return serviceCoordinator;
    }

    public Luz getFoco1() {
        return foco1;
    }

    public Luz getFoco2() {
        return foco2;
    }

    public Luz getFoco3() {
        return foco3;
    }


    


}
