/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shell;

//import javax.speech.*;
import javax.speech.recognition.*;
//import java.io.FileReader;
//import java.util.Locale;


/**
 *
 * @author marcelo
 */
public class Escucha extends ResultAdapter
{

    static Recognizer recognizer;
    String gst;


 @Override
 public void resultAccepted(ResultEvent re)
 {
 try
 {
    Result res = (Result)(re.getSource());
    ResultToken tokens[] = res.getBestTokens();

    String args[]= new String[1];
    args[0]="";
    for (int i=0; i < tokens.length; i++)
    {
        gst = tokens[i].getSpokenText();
        args[0]+=gst+" ";
        System.out.print(gst + " ");
    }
    System.out.println();
    if(gst.equals("cmop"))
    {
        recognizer.deallocate();
        args[0]="Hasta la proxima Cmop!";
        System.out.println(args[0]);
//        Lee.main(args);
        System.exit(0);
    }
    else
    {
        recognizer.suspend();
//        Lee.main(args);
        recognizer.resume();
    }
  }catch(Exception ex)
    {
        System.out.println("Ha ocurrido algo inesperado " + ex);
    }
}

}
