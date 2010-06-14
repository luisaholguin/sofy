/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportes;

import com.csvreader.CsvWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author marcelo
 */
public class ExportarCsv
{

    public ExportarCsv()
    {
    }

    public String reemplazarAzterisco(String path)
    {
        String n = path.replace('\\', '*');
        return n;
    }

    public void exportar(Collection valores, String path)
    {
        boolean bandera  = true;
        Iterator it = valores.iterator();
        while(it.hasNext())
        {
            bandera = true;
            Vector v = (Vector)it.next();
//            CsvWriter writer = new CsvWriter (path+"/"+String.valueOf(v.elementAt(0))+".csv");
            CsvWriter writer = new CsvWriter (path+"\\"+String.valueOf(v.elementAt(0))+".csv");
            try
            {
                for(int i=1; i<v.size(); i++)
                {
                    if(bandera)
                    {
                        writer.write(String.valueOf(v.elementAt(0)));
                        writer.endRecord();
                        bandera = false;
                    }
                    writer.write(String.valueOf(v.elementAt(i)));
                    writer.endRecord();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
               writer.close();
            }
        }
    }

}
