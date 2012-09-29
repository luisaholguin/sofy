/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shell;

import abstraccionhardware.EmisorAudio;
import abstraccionhardware.VentanaPrincipal;
//import abstraccionhardware.VentanaResultados;
import abstraccionhardware.VentanaSalidaHeladera;
import abstraccionhardware.VentanaSalidaMusica;
import abstraccionhardware.VentanaSalidaTelevisor;
//import abstraccionhardware.VentanaSensor;
import contexto.ActualizadorContexto;
import contexto.ContextoCocina;
import contexto.ContextoComedor;
import contexto.ContextoHabitacion;
import controlador.PerfilInt;
import controlador.implementacion.PerfilImp;
import dao.ContextoDao;
import dao.implementacion.ContextoDaoImp;
import dominio.Comando;
import dominio.Contexto;
import dominio.Luz;
import dominio.Objeto;
import dominio.Persiana;
import dominio.Posicion;
import dominio.Puerta;
import dominio.Stereo;
import dominio.Televisor;
import dominio.Temperatura;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import sensado.Peso;
import sensado.SensingConsern;
import sensado.Ubicacion;
import servicios.ServiceCoordinator;
import servicios.ServiciosCocina;
import servicios.ServiciosComedor;
import servicios.ServiciosHabitacion;
import servicios.adquisicion.Colector;
import servicios.adquisicion.Filtro;
import servicios.coordinador.Coordinador;
import servicios.coordinador.Ejecutor;
import servicios.interprete.AnalizadorLexico;
import servicios.interprete.PoliticasComandos;
import servicios.salida.Decodificador;


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

    //Televisor
    private Televisor televisor = new Televisor();

    //Stereo
    private Stereo stereo = new Stereo();

    //ventanas
    private VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this);
//    private VentanaResultados ventanaResultados = new VentanaResultados(this);
//    private VentanaSensor ventanaSensor = new VentanaSensor(this);
    private SensingConsern sensingConsern;
    private VentanaSalidaHeladera heldera = new VentanaSalidaHeladera(this);
    private VentanaSalidaTelevisor ventanaTelevisor = new VentanaSalidaTelevisor(this);
    private VentanaSalidaMusica ventanaStereo = new VentanaSalidaMusica(this);
    

    //sensores
    private dominio.Perfil sensorPerfil = new dominio.Perfil(this);
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
    private Collection objetos = new ArrayList();

    //Shell
    private PoliticasComandos politicasComando;
    private EmisorAudio emisorAudio;
    private Decodificador decodificador;
    private AnalizadorLexico analizadorLexico;
    private Coordinador coordinador;
    private Ejecutor ejecutor;
    private Comando comando = new Comando();
    private Filtro filtro;
    private Colector colector;
//    private Shell shell = new Shell(this);



    public Kernel()
    {

    }

    public void inicializar()
    {
        //Shell
        politicasComando = new PoliticasComandos(this);
        emisorAudio = new EmisorAudio();
        decodificador = new Decodificador(emisorAudio);
        ejecutor = new Ejecutor();
        coordinador = new Coordinador(ejecutor, decodificador, this);
        analizadorLexico = new AnalizadorLexico(politicasComando, decodificador, coordinador);
        filtro = new Filtro(analizadorLexico, this, decodificador);
        colector = new Colector(filtro);
        
        
        this.setPuertas();
        this.setPersianas();
        this.setFocos();
        this.setTemperatura();
        this.setTelevisor();
        this.setStereo();

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
//        ventanaResultados.inicializar(perfiles);
        //esta linea busca un perfil y lo activa
        this.perfil.setNombre("PERFIL");
//        this.setPerfil(this.ventanaResultados.buscarPerfil("FIESTA"));
//        ventanaResultados.setVisible(true);
        this.sensorPerfil.notifyObserver(new Posicion());
//        this.shell.start();
        colector.iniciar(filtro);
        
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

//    public void mostrarTelevisor(boolean o)
//    {
//        this.televisor.setVisible(o);
//    }

//    public void mostrarTemas(boolean o)
//    {
//        this.musica.setVisible(o);
//    }

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
        this.stereo.setCanciones(temas);
    }

    public dominio.Perfil getPerfil()
    {
        return perfil;
    }

    public void setPerfil(dominio.Perfil perfil)
    {
        this.perfil = perfil;
        this.sensorPerfil.notifyObserver(null);
//        this.ventanaPrincipal.mostrarNombrePerfil(perfil.getNombrePerfil());
//        this.ventanaPrincipal.mostrarIntensidadLuz(perfil.getIntesidadLuz());
//        this.ventanaPrincipal.setCarita(perfil.getCarita());
    }

    public Ubicacion getUbicacion()
    {
        return ubicacion;
    }

    public ActualizadorContexto getObservado()
    {
        return this.observado;
    }

    public dominio.Perfil getSensorPerfil()
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
        this.temperatura.cambiarTemperatura(temperatura);
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
        Iterator it = this.objetos.iterator();
        while(it.hasNext())
        {
            Objeto o = (Objeto)it.next();
            if(o.getNombre().trim().toUpperCase().equals("LUZ"))
                o.setIntensidad(luz);
        }
        this.ventanaPrincipal.setIntesidadLuz(luz);
    }

    public Collection getPerfiles() 
    {
        return perfiles;
    }
    
    public void escribirComando(String comando)
    {
        this.ventanaPrincipal.escribirComando(comando);
    }
    
    public void escribirObjeto(String objeto)
    {
        this.ventanaPrincipal.escribirObjeto(objeto);
    }
    
    public void escribirParametros(String parametros)
    {
        this.ventanaPrincipal.escribirParametros(parametros);
    }
    
    public void borrarComando()
    {
        this.ventanaPrincipal.limpiarComando();
    }
    
    public void escribirPalabra(String palabra)
    {
        this.ventanaPrincipal.escribirPalabra(palabra.trim());
    }

    private void setPuertas()
    {
        this.puerta1.setEstado(true);
        this.puerta1.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta1());
        this.puerta1.setForma(1);
        this.puerta1.setNumeroPuerta(1);
        this.puerta1.setId(1);
        this.puerta1.setNombre("PUERTA");
        
        this.puerta2.setEstado(true);
        this.puerta2.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta2());
        this.puerta2.setForma(1);
        this.puerta2.setNumeroPuerta(2);
        this.puerta2.setId(2);
        this.puerta2.setNombre("PUERTA");

        this.puerta3.setEstado(true);
        this.puerta3.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta3());
        this.puerta3.setForma(1);
        this.puerta3.setNumeroPuerta(3);
        this.puerta3.setId(3);
        this.puerta3.setNombre("PUERTA");

        this.puerta4.setEstado(true);
        this.puerta4.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta4());
        this.puerta4.setForma(3);
        this.puerta4.setNumeroPuerta(4);
        this.puerta4.setId(4);
        this.puerta4.setNombre("PUERTA");

        this.puerta5.setEstado(true);
        this.puerta5.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta5());
        this.puerta5.setForma(2);
        this.puerta5.setNumeroPuerta(5);
        this.puerta5.setId(5);
        this.puerta5.setNombre("PUERTA");

        this.puerta6.setEstado(true);
        this.puerta6.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta6());
        this.puerta6.setForma(2);
        this.puerta6.setNumeroPuerta(6);
        this.puerta6.setId(6);
        this.puerta6.setNombre("PUERTA");

        this.puerta7.setEstado(true);
        this.puerta7.setLabelPuerta(this.ventanaPrincipal.getjLabelPuerta7());
        this.puerta7.setForma(4);
        this.puerta7.setNumeroPuerta(7);
        this.puerta7.setId(7);
        this.puerta7.setNombre("PUERTA");
    }

    private void setPersianas()
    {
        this.persiana1.setEstado(true);
        this.persiana1.setLabelVentana(this.ventanaPrincipal.getjLabelVentana1());
        this.persiana1.setVertical(true);
        this.persiana1.setNumeroPersiana(1);
        this.persiana1.setId(1);
        this.persiana1.setNombre("PERSIANA");

        this.persiana2.setEstado(true);
        this.persiana2.setLabelVentana(this.ventanaPrincipal.getjLabelVentana2());
        this.persiana2.setVertical(true);
        this.persiana2.setNumeroPersiana(2);
        this.persiana2.setId(2);
        this.persiana2.setNombre("PERSIANA");

        this.persiana3.setEstado(true);
        this.persiana3.setLabelVentana(this.ventanaPrincipal.getjLabelVentana3());
        this.persiana3.setVertical(true);
        this.persiana3.setNumeroPersiana(3);
        this.persiana3.setId(3);
        this.persiana3.setNombre("PERSIANA");

        this.persiana4.setEstado(true);
        this.persiana4.setLabelVentana(this.ventanaPrincipal.getjLabelVentana4());
        this.persiana4.setVertical(false);
        this.persiana4.setNumeroPersiana(4);
        this.persiana4.setId(4);
        this.persiana4.setNombre("PERSIANA");
    }

    private void setFocos()
    {
        this.foco1.setId(1);
        this.foco1.setNumeroFoco(1);
        this.foco1.setSlider(this.ventanaPrincipal.getMedidorLuz());
        this.foco1.setNombre("LUZ");
        this.foco1.setPanel(this.ventanaPrincipal.getPanel2());
        this.foco1.setImagen("/imagenes/iluminacionCocina.jpg");
        this.foco1.setEstado(false); //luz de la cocina
        this.foco1.setIntensidad(0);

        
        this.foco2.setId(2);
        this.foco2.setNumeroFoco(2);
        this.foco2.setSlider(this.ventanaPrincipal.getMedidorLuz());
        this.foco2.setNombre("LUZ");
        this.foco2.setPanel(this.ventanaPrincipal.getPanel2());
        this.foco2.setImagen("/imagenes/iluminacionComedor.jpg");
        this.foco2.setEstado(false); // luz del comedor
        this.foco2.setIntensidad(0);

        
        this.foco3.setId(3);
        this.foco3.setNumeroFoco(3);
        this.foco3.setSlider(this.ventanaPrincipal.getMedidorLuz());
        this.foco3.setNombre("LUZ");
        this.foco3.setPanel(this.ventanaPrincipal.getPanel2());
        this.foco3.setImagen("/imagenes/iluminacionHabitacion.jpg");
        this.foco3.setEstado(false); // luz de la habitacion
        this.foco3.setIntensidad(0);
    }

    private void setTemperatura()
    {
        this.temperatura.setSlider(this.ventanaPrincipal.getjSliderTemperaturaInterior());
        this.temperatura.setId(1);
        this.temperatura.setNombre("TEMPERATURA");
    }

    private void setTelevisor()
    {
        this.televisor.setTele(ventanaTelevisor);
        this.televisor.setId(1);
        this.televisor.setNombre("TV");
    }

    private void setStereo()
    {
        this.stereo.setVentana(ventanaStereo);
        this.stereo.encender();
        this.stereo.apagar();
        this.stereo.setId(1);
        this.stereo.setNombre("ESTEREO");
    }

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

    public Televisor getTelevisor() {
        return televisor;
    }

    public Stereo getStereo() {
        return stereo;
    }

    public Collection getObjetos() {
        return objetos;
    }
    
    public Collection getCanales()
    {
        return this.canales;
    }
    
    public Collection getCanciones()
    {
        return this.temas;
    }
    
    

    public void armarListaObjetosCocina()
    {
        this.objetos.clear();
        this.objetos.add(this.puerta1);
        this.objetos.add(this.puerta2);
        this.objetos.add(this.persiana1);
        this.objetos.add(this.foco1);
        this.objetos.add(this.temperatura);
        this.sensorPerfil.setNombre("PERFIL");
        this.objetos.add(this.sensorPerfil);
    }
    
    public void armarListaObjetosComedor()
    {
        this.objetos.clear();
        this.objetos.add(this.persiana2);
        this.objetos.add(this.puerta4);
        this.objetos.add(this.puerta7);
        this.objetos.add(this.foco2);
        this.objetos.add(this.stereo);
        this.objetos.add(this.temperatura);
        this.sensorPerfil.setNombre("PERFIL");
        this.objetos.add(this.sensorPerfil);
    }
    
    public void armarListaObjetosHabitacion()
    {
        this.objetos.clear();
        this.objetos.add(this.persiana3);
        this.objetos.add(this.persiana4);
        this.objetos.add(this.foco3);
        this.objetos.add(this.televisor);
        this.objetos.add(this.temperatura);
        this.sensorPerfil.setNombre("PERFIL");
        this.objetos.add(this.sensorPerfil);
    }
    
    ///////// aqui empieza la zona de comandos ////////////////

    public void setComando(Comando comando) 
    {
        this.comando = comando;
    }
    
    public Comando getComando()
    {
        return this.comando;
    }
    
    
    
    public void analizarComando(Comando comando)
    {
        this.analizadorLexico.analizarComando(comando);
    }
    
    ///// Zona puertas ///////////
    //Abrir puertas
    public void abrirPuerta1()
    {
        this.puerta1.abrirPuerta();
    }

    public void abrirPuerta2()
    {
        this.puerta2.abrirPuerta();
    }
    
    public void abrirPuerta3()
    {
        this.puerta3.abrirPuerta();
    }
    
    public void abrirPuerta4()
    {
        this.puerta4.abrirPuerta();
    }
    
    public void abrirPuerta5()
    {
        this.puerta5.abrirPuerta();
    }
    
    public void abrirPuerta6()
    {
        this.puerta6.abrirPuerta();
    }
    
    public void abrirPuerta7()
    {
        this.puerta7.abrirPuerta();
    }
    
    //Cerrar puertas
    public void cerrarPuerta1()
    {
        this.puerta1.cerrarPuerta();
    }
    
    public void cerrarPuerta2()
    {
        this.puerta2.cerrarPuerta();
    }
    
    public void cerrarPuerta3()
    {
        this.puerta3.cerrarPuerta();
    }
    
    public void cerrarPuerta4()
    {
        this.puerta4.cerrarPuerta();
    }
    
    public void cerrarPuerta5()
    {
        this.puerta5.cerrarPuerta();
    }
    
    public void cerrarPuerta6()
    {
        this.puerta6.cerrarPuerta();
    }
    
    public void cerrarPuerta7()
    {
        this.puerta7.cerrarPuerta();
    }
    
    //////// zona persianas /////////
    //Abrir Persianas
    public void abrirPersiana1()
    {
        this.persiana1.abrirPersiana();
    }
    
    public void abrirPersiana2()
    {
        this.persiana2.abrirPersiana();
    }
    
    public void abrirPersiana3()
    {
        this.persiana3.abrirPersiana();
    }
    
    public void abrirPersiana4()
    {
        this.persiana4.abrirPersiana();
    }
    
    //Cerrar Persianas
    public void cerrarPersiana1()
    {
        this.persiana1.cerrarPersiana();
    }
    
    public void cerrarPersiana2()
    {
        this.persiana2.cerrarPersiana();
    }
    
    public void cerrarPersiana3()
    {
        this.persiana3.cerrarPersiana();
    }
    
    public void cerrarPersiana4()
    {
        this.persiana4.cerrarPersiana();
    }
    
    // televisor
    public void prenderTv()
    {
        this.televisor.encender();
    }
    public void apagarTv()
    {
        this.televisor.apagar();
    }
    public void fijarCanal(int canal)
    {
        this.televisor.fijarCanal(canal);
    }
    
    //Stereo
    public void prenderStereo()
    {
        this.stereo.encender();
    }
    
    public void apagarStereo()
    {
        this.stereo.apagar();
    }
    
    public void reproducirCanciones()
    {
        this.stereo.reproducir();
    }
    
    public void encenderLuz()
    {
        Iterator it = this.objetos.iterator();
        while(it.hasNext())
        {
            Objeto o = (Objeto)it.next();
            
            if(o.getNombre().trim().toUpperCase().equals("LUZ"))
            {
                if(this.getIntesidadLuzAmbiente() < 30)
                    o.setEstado(true);
                else
                    o.setEstado(false);
                System.out.println("El valor de la intensidad de luz es: "+o.getIntensidad());
                this.ventanaPrincipal.mostrarIntensidadLuz(o.getIntensidad());
            }
                
        }
    }
    
    public void apagarLuz()
    {
        Iterator it = this.objetos.iterator();
        while(it.hasNext())
        {
            Objeto o = (Objeto)it.next();
            if(o.getNombre().trim().toUpperCase().equals("LUZ"))
                o.setEstado(false);
        }
    }
    
    public void fijarCancion(int cancion)
    {
        if (!this.ventanaStereo.reproducirCancion(cancion))
            System.out.println("Reproduciendo una cancion");
    }
    
    public void detenerCancion()
    {
        this.ventanaStereo.stop();
    }
    
    public void mostrarPalabraInterpretada(String palabra)
    {
        DefaultListModel modelo = (DefaultListModel) this.ventanaPrincipal.getJListPalabras().getModel();
        modelo.addElement(palabra);
    }
    
    public void mostrarNombrePerfil(String nombre)
    {
        this.ventanaPrincipal.mostrarNombrePerfil(nombre);
    }
    
    public void entrarSalirCocina()
    {
        this.serviciosCocina.entrarSalirCocina();
    }
    
    public void entrarCocina()
    {
        this.serviciosCocina.entrarCocina();
    }
    
    public void salirCocina()
    {
        this.serviciosCocina.salirCocina();
    }
    
    public void entrarComedor()
    {
        this.serviciosComedor.entrarHabitacion();
    }
    
    public void entrarHabitacion()
    {
        this.servisioHabitacion.entrarHabitacion();
    }
    
    public int getIntesidadLuzAmbiente()
    {
        return this.ventanaPrincipal.getjSliderIntesidadLuzAmbiente().getValue();
    }
    
//    public void prenderLuzCocina()
//    {
//        this.foco1.prenderLuz("/imagenes/iluminacionCocina.jpg");
//    }
//    
//    public void apagarLuzCocina()
//    {
//        this.foco1.apagarLuz();
//    }
    
    
}
