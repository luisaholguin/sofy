/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import dao.MusicaDao;
import dao.implementacion.MusicaDaoImp;
import dominio.Musica;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Marcelo
 */
public class Test {

    public Test()
    {

    }

    public void testCaro()
    {

        MusicaDao sql = new MusicaDaoImp();
        Collection co = sql.getAll();
        if (co.size()== 0)
        {
            System.out.println("No hay musicas ");
        }
        else
        {
            Iterator it = co.iterator();
            while (it.hasNext())
            {
                Musica musica = (Musica)it.next();
                System.out.println("Id: "+ musica.getCodigo());
                System.out.println("Nombre: "+ musica.getNombre());
                System.out.println("Genero: "+ musica.getGenero());

            }

        }
    }

    public void TestMarcelo()
    {
        
    }

}
