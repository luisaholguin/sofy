/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.adquisicion;

import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;
import servicios.interprete.AnalizadorLexico;

/**
 *
 * @author Administrator
 */
public class Colector extends ResultAdapter 
{
    

     static Recognizer recognizer;
     String gst;
     private Filtro filtro;

    
    public Colector() 
    {
    }

    public Colector(Filtro filtro) 
    {
        this.filtro = filtro;
    }
    
    
    

//    public Colector(final AnalizadorLexico analizador) 
//    {
////        this.analizador = analizador;
//        
//    }
    
    public void iniciar(Filtro filtro)
    {
//        Thread t = new Thread()
//        {
//            public void run()
//            {
                try
             {
                 recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ENGLISH));
    //             ReconocedorEs es = new ReconocedorEs();
    //             recognizer = es.getSpanishDictation("MARCELO");
                 recognizer.allocate();

    //             FileReader grammar1 =new FileReader("c:/SimpleGrammarES2E.txt");
                 FileReader grammar1 =new FileReader("c:/SimpleGrammarEnglish.txt");

                 RuleGrammar rg = recognizer.loadJSGF(grammar1);
                 rg.setEnabled(true);

                 recognizer.addResultListener(new Colector(this.filtro));

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
//            }
//        };
//        t.start();
    }
    
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
             System.out.println("");
//             System.out.println("Filtrando");
             filtro.filtrar(gst);
//             System.out.println("Terminado el filtro");
//             System.out.println();
//             if(gst.equals("cmop"))
//             {
//                 recognizer.deallocate();
//                 args[0]="Hasta la proxima Cmop!";
//                 System.out.println(args[0]);
////                 Lee.main(args);
////                 System.exit(0);
//             }
//             else
//             {
//             System.out.println("Suspendiendo");
                 recognizer.suspend();
//                 Lee.main(args);
//                 System.out.println("Reanudando");
                 recognizer.resume();
//             }
         }catch(Exception ex)
         {
             System.out.println("Ha ocurrido algo inesperado " + ex);
         }
     }

//    public void run() 
//    {
////        Filtro filtro = new Filtro();
//        try
//         {
//             recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ENGLISH));
////             ReconocedorEs es = new ReconocedorEs();
////             recognizer = es.getSpanishDictation("MARCELO");
//             recognizer.allocate();
//
////             FileReader grammar1 =new FileReader("c:/SimpleGrammarES2E.txt");
//             FileReader grammar1 =new FileReader("c:/SimpleGrammarEnglish.txt");
//
//             RuleGrammar rg = recognizer.loadJSGF(grammar1);
//             rg.setEnabled(true);
//
//             recognizer.addResultListener(new Colector());
//
//             System.out.println("Empieze Dictado");
//             recognizer.commitChanges();
//
//             recognizer.requestFocus();
//             recognizer.resume();
//         }catch (Exception e)
//         {
//             System.out.println("Exception en " + e.toString());
//             e.printStackTrace();
//             System.exit(0);
//         }
//    }

    
    
    
    
    
    
}
