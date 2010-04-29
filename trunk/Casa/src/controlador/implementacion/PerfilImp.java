/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.implementacion;

import controlador.PerfilInt;
import controlador.RecetaInt;
import dao.CanalDao;
import dao.CanalesPerfilesDao;
import dao.EstadoAnimDao;
import dao.MusicaDao;
import dao.PerfilDao;
import dao.RecetasPerfilesDao;
import dao.TemaPerfilDao;
import dao.implementacion.CanalDaoImp;
import dao.implementacion.CanalesPerfilesDaoImp;
import dao.implementacion.EstadoAnimoDaoImp;
import dao.implementacion.MusicaDaoImp;
import dao.implementacion.PerfilDaoImp;
import dao.implementacion.RecetasPerfilesDaoImp;
import dao.implementacion.TemaPerfilDaoImp;
import dominio.Canal;
import dominio.Musica;
import dominio.Perfil;
import dominio.PerfilCanal;
import dominio.PerfilReceta;
import dominio.PerfilTema;
import dominio.Receta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Marcelo
 */
public class PerfilImp implements PerfilInt
{

    public PerfilImp()
    {

    }

    public void guardar(Perfil perfil)
    {
        PerfilDao sql = new PerfilDaoImp();
        sql.guardar(perfil);
        perfil.setCodigo(sql.getCodigo());
        this.guardarCanales(perfil);
        this.guardarTemas(perfil);
        this.guardarRecetas(perfil);
    }

    private void guardarCanales(Perfil perfil)
    {
        Collection canales = perfil.getCanales();
        Iterator it = canales.iterator();
        CanalesPerfilesDao sql = new CanalesPerfilesDaoImp();
        while(it.hasNext())
        {
            Canal c = (Canal)it.next();
            sql.guardar(perfil.getCodigo(), c.getCodigo());
            c = null;
        }
        it = null;
        canales = null;
        sql = null;
    }

    private void guardarTemas(Perfil perfil)
    {
        Collection temas = perfil.getMusica();
        Iterator it = temas.iterator();
        TemaPerfilDao sql = new TemaPerfilDaoImp();
        while(it.hasNext())
        {
            Musica m = (Musica)it.next();
            sql.guardar(perfil.getCodigo(), m.getCodigo());
            m = null;
        }
        it= null;
        temas = null;
        sql = null;
    }

    private void guardarRecetas(Perfil perfil)
    {
        Collection recetas = perfil.getReceta();
        RecetasPerfilesDao sql = new RecetasPerfilesDaoImp();
        Iterator it = recetas.iterator();
        while(it.hasNext())
        {
            Receta r = (Receta)it.next();
            sql.guardar(r.getCodigo(), perfil.getCodigo());
            r = null;
        }
        it = null;
        recetas = null;
        sql = null;
    }

    /**
     * Modificar un perfil implica eliminar todas las entradas relacionadas con el perfil en las teas
     * canales_perfiles, temas_perfiles y recetas perfiles, luego cargar de nuevo las relaciones
     * y por ultimo, modificar la clase perfil en si.
     * @param perfil
     */
    public void modificar(Perfil perfil)
    {
        //quitar las relaciones con perfil
        this.quitarRelaciones(perfil);

        //Ahora hay que agregar las nuevas relaciones
        //guardar canales
        this.guardarCanales(perfil);
        //guardar temas
        this.guardarTemas(perfil);
        //guardar recetas
        this.guardarRecetas(perfil);
        
        //por ultimo, modifico el perfil
        PerfilDao sqlPerfil = new PerfilDaoImp();
        sqlPerfil.modificar(perfil);

        // y parapin parapan, se acabo
    }

    /**
     * Borrar un perfil implica borrar las relaciones en las tablas canales_perfiles, temas_perfiles y recetas_perfiles
     * y por ultimo borrar el perfil en si de la tabla perfiles
     * @param perfil
     */
    public void borrar(Perfil perfil)
    {
        //quitar las relaciones con perfil
        this.quitarRelaciones(perfil);

        //Ahora borrar el perfil
        PerfilDao sql = new PerfilDaoImp();
        sql.borrar(perfil);

    }

    private void quitarRelaciones(Perfil perfil)
    {
        //quitar las relaciones con perfil
        //quitar canales_perfiles
        CanalesPerfilesDao sqlCanal = new CanalesPerfilesDaoImp();
        sqlCanal.borrarCanales(perfil.getCodigo());
        //quitar temas_perfiles
        TemaPerfilDao sqlTema = new TemaPerfilDaoImp();
        sqlTema.borrarTemas(perfil.getCodigo());
        //quitar recetas_perfiles
        RecetasPerfilesDao sqlReceta = new RecetasPerfilesDaoImp();
        sqlReceta.borrarRecetas(perfil.getCodigo());
    }

    public int getCodigoReceta(int CodPerfil)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public Perfil getPerfil(String nombre)
    {
//        Collection perfiles = new ArrayList();
        Perfil p = new Perfil();
//        RecetasPerfilesDao sqlTea = new RecetasPerfilesDaoImp();
        CanalesPerfilesDao sqlTeaCanal = new CanalesPerfilesDaoImp();
        TemaPerfilDao sqlTemas = new TemaPerfilDaoImp();
        EstadoAnimDao sqlEstado = new EstadoAnimoDaoImp();

        Collection tea = new ArrayList();
        PerfilDao sqlPerfil = new PerfilDaoImp();
        //traigo todos los perfiles almacenados
        p = sqlPerfil.get(nombre.trim().toUpperCase());
//        Iterator it = perfilesTemp.iterator();
//        while(it.hasNext())
//        {
//            Perfil p = (Perfil)it.next();
            tea.clear();
//            tea = sqlTea.getRecetasPerfil(p.getCodigo()); // traigo solo las recetas que pertenecen a un perfil
            p.setReceta(this.getRecetas(p.getCodigo()));
            tea.clear();
            tea = sqlTeaCanal.getCanalPerfil(p.getCodigo()); // traigo solo los canales que pertenecen a un perfil
            p.setCanales(this.getCanales(tea));
            tea.clear();
            tea = sqlTemas.getTemaPerfil(p.getCodigo());
            p.setMusica(this.getTemas(tea));
            p.setEstadoAnimo(sqlEstado.get(p.getEstadoAnimo().getCodigo()));

//            perfiles.add(p);
//            p = null;
//        }

        return p;
    }

    public Collection getAll()
    {
        Collection perfiles = new ArrayList();
//        RecetasPerfilesDao sqlTea = new RecetasPerfilesDaoImp();
        CanalesPerfilesDao sqlTeaCanal = new CanalesPerfilesDaoImp();
        TemaPerfilDao sqlTemas = new TemaPerfilDaoImp();
        EstadoAnimDao sqlEstado = new EstadoAnimoDaoImp();

        Collection tea = new ArrayList();
        PerfilDao sqlPerfil = new PerfilDaoImp();
        //traigo todos los perfiles almacenados
        Collection perfilesTemp = sqlPerfil.getAll();
        Iterator it = perfilesTemp.iterator();
        while(it.hasNext())
        {
            Perfil p = (Perfil)it.next();
            tea.clear();
//            tea = sqlTea.getRecetasPerfil(p.getCodigo()); // traigo solo las recetas que pertenecen a un perfil
            p.setReceta(this.getRecetas(p.getCodigo()));
            tea.clear();
            tea = sqlTeaCanal.getCanalPerfil(p.getCodigo()); // traigo solo los canales que pertenecen a un perfil
            p.setCanales(this.getCanales(tea));
            tea.clear();
            tea = sqlTemas.getTemaPerfil(p.getCodigo());
            p.setMusica(this.getTemas(tea));
            p.setEstadoAnimo(sqlEstado.get(p.getEstadoAnimo().getCodigo()));

            perfiles.add(p);
            p = null;
        }

        return perfiles;
    }

    private Collection getRecetas(Collection tea)
    {
        Collection recetas = new ArrayList();
        RecetaInt sql = new RecetaImp();
        Iterator it = tea.iterator();
        while(it.hasNext())
        {
            PerfilReceta r = (PerfilReceta)it.next();
            recetas.add(sql.get(r.getCodigoReceta()));
            r = null;
        }
        return recetas;
    }

    private Collection getRecetas(int idPerfil)
    {
        Collection recetas = new ArrayList();
        RecetaInt sql = new RecetaImp();
        recetas = sql.getRecetasPerfil(idPerfil);
        return recetas;
    }

    private Collection getCanales(Collection tea)
    {
        Collection canales = new ArrayList();
        CanalDao sql = new CanalDaoImp();

        Iterator it = tea.iterator();
        while(it.hasNext())
        {
            PerfilCanal r = (PerfilCanal)it.next();
            canales.add(sql.get(r.getCodigoCanal()));
            r = null;
        }
        return canales;
    }

    private Collection getTemas(Collection tea)
    {
        Collection temas = new ArrayList();
        MusicaDao sql = new MusicaDaoImp();

        Iterator it = tea.iterator();
        while(it.hasNext())
        {
            PerfilTema r = (PerfilTema)it.next();
            temas.add(sql.get(r.getIdTema()));
            r = null;
        }
        return temas;
    }

}
