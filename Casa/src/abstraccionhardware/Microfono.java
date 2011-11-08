/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package abstraccionhardware;

import javax.speech.recognition.Recognizer;
import javax.speech.recognition.Result;
import javax.speech.recognition.ResultAdapter;
import javax.speech.recognition.ResultEvent;
import javax.speech.recognition.ResultToken;
import servicios.adquisicion.Filtro;

/**
 *
 * @author Administrador
 */
public class Microfono extends ResultAdapter
{
    static Recognizer recognizer;
    String palabra;
//    private Filtro filtro = new Filtro();

    public Microfono() {
    }



    @Override
     public void resultAccepted(ResultEvent re)
     {
//         try
//         {
//            Result res = (Result)(re.getSource());
//            ResultToken tokens[] = res.getBestTokens();
//
////            String args[]= new String[1];
////            args[0]="";
//            palabra = tokens[0].getSpokenText();
//            System.out.println("El tamaño de token es: "+tokens.length);
////            for (int i=0; i < tokens.length; i++)
////            {
////                palabra = tokens[i].getSpokenText();
////                args[0]+=palabra+" ";
////                System.out.print(palabra + " ");
////            }
//            palabra = palabra.toUpperCase().trim();
//            System.out.println(palabra);
//            if(palabra.trim().equals("TERMINAR"))
//            {
//                recognizer.deallocate();
//            }
//            this.filtro.filtrar(palabra);
////            if(gst.equals("cmop"))
////            {
////                recognizer.deallocate();
////                args[0]="Hasta la proxima Cmop!";
////                System.out.println(args[0]);
//////                Lee.main(args);
////                System.exit(0);
////            }
////            else
////            {
////                recognizer.suspend();
////                Lee.main(args);
////                recognizer.resume();
////            }
//          }catch(Exception ex)
//            {
//                System.out.println("Ha ocurrido algo inesperado " + ex);
//            }
    }


}
