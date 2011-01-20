/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shell;

import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;

/**
 *
 * @author marcelo
 */
public class Shell extends Thread

{

    static Recognizer recognizer;
    String gst;
    private Kernel kernel;

    public Shell(Kernel k)
    {
        this.kernel = k;
//        this.init();
    }

   public void run()
   {
      try
        {
            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            recognizer.allocate();

            FileReader grammar1 =new FileReader("i:/SimpleGrammarES2.txt");

            RuleGrammar rg = recognizer.loadJSGF(grammar1);
            rg.setEnabled(true);
            recognizer.addResultListener(new Escucha());
            System.out.println("Empieze Dictado");
            recognizer.commitChanges();
            recognizer.requestFocus();
            recognizer.resume();
        }catch (Exception e)
        {
            System.out.println("Exception en " + e.toString());
            e.printStackTrace();
            System.exit(0);
        }
   }

//    private void init()
//    {
//        try
//        {
//            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
//            recognizer.allocate();
//
//            FileReader grammar1 =new FileReader("i:/SimpleGrammarES2.txt");
//
//            RuleGrammar rg = recognizer.loadJSGF(grammar1);
//            rg.setEnabled(true);
//            recognizer.addResultListener(new Escucha());
//            System.out.println("Empieze Dictado");
//            recognizer.commitChanges();
//            recognizer.requestFocus();
//            recognizer.resume();
//        }catch (Exception e)
//        {
//            System.out.println("Exception en " + e.toString());
//            e.printStackTrace();
//            System.exit(0);
//        }
//    }

}
