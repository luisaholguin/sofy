/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import distribuciones.Binomial;
import distribuciones.Empirica;
import distribuciones.Erlang;
import distribuciones.Exponencial;
import distribuciones.Normal;
import distribuciones.Poisson;
import distribuciones.Triangular;
import distribuciones.Uniforme;
import distribuciones.Weibull;
import generadores.GeneradorBinomial;
import generadores.GeneradorEmpirico;
import generadores.GeneradorErlang;
import generadores.GeneradorExponencial;
import generadores.GeneradorNormal;
import generadores.GeneradorPoisson;
import generadores.GeneradorTriangular;
import generadores.GeneradorUniforme;
import generadores.GeneradorWeibull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vista.UIDistribucionEmpirica;
import vista.UIVentanaPrincipal;

/**
 *
 * @author marcelo
 */
public class UIVentanaPrincipalUtil
{
    private Collection distribucionesAGenerar = new ArrayList();
    private UIDistribucionEmpirica uiEmpirica = new UIDistribucionEmpirica(this);
    private UIVentanaPrincipal principal;

    public UIVentanaPrincipalUtil()
    {
    }

    public UIVentanaPrincipalUtil(UIVentanaPrincipal principal)
    {
        this.principal = principal;
    }


    public void seleccionarParametros(JComboBox combo, JTextField parametro1, JTextField parametro2, JTextField parametro3, JLabel label1, JLabel label2, JLabel label3)
    {
        int seleccion = combo.getSelectedIndex();
        switch(seleccion)
        {
            case 0:
                    break;
            case 1:
                    //distribucion uniforme
                    parametro1.setEnabled(true);
                    parametro2.setEnabled(true);
                    label1.setText("Minimo");
                    label2.setText("Maximo");
                    break;
            case 2:
                    //distribucion normal
                    parametro1.setEnabled(true);
                    parametro2.setEnabled(true);
                    label1.setText("Media");
                    label2.setText("Desviacion");
                    break;
            case 3:
                    //distribucion binomial
                    parametro1.setEnabled(true);
                    parametro2.setEnabled(true);
                    label1.setText("Nro Ensayos");
                    label2.setText("Prob. de Exito");
                    break;
            case 4:
                    //distribucion triangular
                    parametro1.setEnabled(true);
                    parametro2.setEnabled(true);
                    parametro3.setEnabled(true);
                    label1.setText("Minimo");
                    label2.setText("Medio");
                    label3.setText("Maximo");
                    break;
            case 5:
                    //distribucion exponencial
                    parametro1.setEnabled(true);
                    label1.setText("Lambda");
                    break;
            case 6:
                    //distribucion erlang
                    parametro1.setEnabled(true);
                    parametro2.setEnabled(true);
                    label1.setText("Media");
                    label2.setText("Varianza");
                    break;
            case 7:
                    //distribucion poisson
                    parametro1.setEnabled(true);
                    label1.setText("Alfa");
                    break;
            case 8:
                    //distribucion weibull
                    parametro1.setEnabled(true);
                    parametro2.setEnabled(true);
                    label1.setText("Alfa");
                    label2.setText("Beta");
                    break;
            case 9:
                    //distribucion empirica
                    
                    uiEmpirica.setVisible(true);
                    break;
        }
    }

    public boolean validar(JTextField parametro1, JTextField parametro2, JTextField parametro3, JTextField semilla,JTextField variable, JTextField cantidad)
    {
        boolean bandera = true;
        if(parametro1.getText().trim().length() == 0)
            bandera = false;
        if(parametro2.getText().trim().length() == 0)
            bandera = false;
        if(parametro3.getText().trim().length() == 0)
            bandera = false;
        if(semilla.getText().trim().length() == 0)
            bandera = false;
        if(variable.getText().trim().length() == 0)
            bandera = false;
        if(cantidad.getText().trim().length() == 0)
            bandera = false;
        else
        {
            try
            {
                int nu = Integer.parseInt(cantidad.getText());
            }
            catch(NumberFormatException e)
            {
                bandera = false;
                JOptionPane.showMessageDialog(null, "La cantidad a generar debe ser un valor numerico", "Error de parametros", JOptionPane.ERROR_MESSAGE);
            }
        }
        return bandera;
    }

    /**
     * Metodo para limpiar los registros de la tabla.
     * Quita todas las filas de la tabla.
     */
    public void limpiar(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        while(tabla.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }

    public Collection agregar(Datos d, Collection datosAgregados, JTable tabla, JCheckBox sem)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String datos[] = new String[7];
        this.distribucionesAGenerar = datosAgregados;
        if(this.validarDistribucion(d))
        {
                datos[0] = d.getNombreVariable().trim().toUpperCase();
                datos[1] = d.getDistribucion().trim().toUpperCase();
                datos[2] = d.getParametro1().trim();
                datos[3] = d.getParametro2().trim();
                datos[4] = d.getParametro3().trim();
                datos[5] = String.valueOf(d.getCantidad());
                if(sem.isSelected())
                     datos[6] = d.getSemilla().trim();
                else
                    datos[6] = "AUTOGENERADA";
                modelo.addRow(datos);
                this.distribucionesAGenerar.add(d);
        }
        return this.distribucionesAGenerar;
    }

    private boolean validarDistribucion(Datos d)
    {
        boolean bandera = true;
        if(d.getDistribucion().trim().toUpperCase().equals("TRIANGULAR"))
            bandera = this.validarTriangular(d);
        if(d.getDistribucion().trim().toUpperCase().equals("UNIFORME"))
            bandera = this.validarUniforme(d);
        if(d.getDistribucion().trim().toUpperCase().equals("EXPONENCIAL"))
            bandera = this.validarExponencial(d);
        if(d.getDistribucion().trim().toUpperCase().equals("POISSON"))
            bandera = this.validarPoisson(d);
        if(d.getDistribucion().trim().toUpperCase().equals("NORMAL"))
            bandera = this.validarNormal(d);
        if(d.getDistribucion().trim().toUpperCase().equals("BINOMIAL"))
            bandera = this.validarBinomial(d);
        if(d.getDistribucion().trim().toUpperCase().equals("WEIBULL"))
            bandera = this.validarWeibull(d);
        return bandera;
    }

    private boolean validarErlang(Datos d)
    {
        boolean bandera = true;
        try
        {
            if((Double.parseDouble(d.getParametro1())<0) || (Double.parseDouble(d.getParametro2())<0))
            {
                bandera = false;
                JOptionPane.showMessageDialog(null, "La media y la varianza no pueden ser menos a cero", "Error de parametros", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Los valores de los parametros deben ser numericos", "Error de parametros", JOptionPane.ERROR_MESSAGE);
            bandera = false;
        }
        return bandera;
    }

    private boolean validarWeibull(Datos d)
    {
        boolean bandera = true;
        try
        {
            if((Double.parseDouble(d.getParametro1())<0) || (Double.parseDouble(d.getParametro2())<0))
            {
                JOptionPane.showMessageDialog(null, "Los parametros deben ser igual o mayor que cero", "Error de parametros", JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Los valores de los parametros deben ser numericos", "Error de parametros", JOptionPane.ERROR_MESSAGE);
            bandera = false;
        }
        return bandera;
    }

    private boolean validarBinomial(Datos d)
    {
        boolean bandera = true;
        try
        {
            if(Integer.parseInt(d.getParametro1()) > 0)
            {
                if((Double.parseDouble(d.getParametro2())<=0) || (Double.parseDouble(d.getParametro2())> 1) )
                {
                    bandera = false;
                    JOptionPane.showMessageDialog(null, "La probabilidad debe ser un valor entre 0 y 1", "Error de parametros", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                bandera = false;
                JOptionPane.showMessageDialog(null, "El numero de ensayos debe ser mayor a cero", "Error de parametros", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(NumberFormatException e)
        {
            bandera = false;
            JOptionPane.showMessageDialog(null, "Los parametros deben ser numerico entero para la cantidad de ensayos y numerico real para la probabilidad", "Error de parametros", JOptionPane.ERROR_MESSAGE);
        }
        return bandera;
    }

    private boolean validarNormal(Datos d)
    {
        boolean bandera = true;
        try
        {
            double num = Double.parseDouble(d.getParametro1());
            double num2 = Double.parseDouble(d.getParametro2());
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Los parametros deben ser numericos", "Error de parametros", JOptionPane.ERROR_MESSAGE);
            bandera = false;
        }
        return bandera;
    }

    private boolean validarTriangular(Datos d)
    {
        boolean bandera =  true;
        try
            {
                double min = Double.parseDouble(d.getParametro1());
                double max = Double.parseDouble(d.getParametro3());
                double med = Double.parseDouble(d.getParametro3());
                if((Double.parseDouble(d.getParametro1()) <= Double.parseDouble(d.getParametro2())) && (Double.parseDouble(d.getParametro2()) <= Double.parseDouble(d.getParametro3()) ))
                    bandera = true;
                else
                {
                    bandera = false;
                    JOptionPane.showMessageDialog(null, "Los parametros para la distribucion triangular son erroneos", "Error de parametros", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Los parametros deben ser numericos", "Error de parametros", JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        return bandera;
    }

    private boolean validarUniforme(Datos d)
    {
        boolean bandera = true;
        try
        {
            double min = Double.parseDouble(d.getParametro1());
            double max = Double.parseDouble(d.getParametro2());
            if(Double.parseDouble(d.getParametro1()) < Double.parseDouble(d.getParametro2()))
                bandera = true;
            else
            {
                bandera = false;
                JOptionPane.showMessageDialog(null, "Los parametros para la distribucion uniforme son erroneos", "Error de parametros", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(NumberFormatException e)
        {
            bandera = false;
            JOptionPane.showMessageDialog(null, "Los parametros deben ser numericos", "Error de parametros", JOptionPane.ERROR_MESSAGE);
        }
        return bandera;
    }

    private boolean validarExponencial(Datos d)
    {
        boolean bandera = true;
        try
        {
            double num = Double.parseDouble(d.getParametro1());
            if(Double.parseDouble(d.getParametro1()) != 0)
                bandera = true;
            else
            {
                bandera = false;
                JOptionPane.showMessageDialog(null, "El valor de lambda no puede ser cero", "Error de parametro", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(NumberFormatException e)
        {
            bandera = false;
            JOptionPane.showMessageDialog(null, "El valor de lambda debe ser numerico", "Error de parametro", JOptionPane.ERROR_MESSAGE);
        }
        return bandera;
    }

    private boolean validarPoisson(Datos d)
    {
        boolean bandera = true;
        try
        {
            if(Double.parseDouble(d.getParametro1()) >= 0)
                bandera = true;
            else
            {
                bandera = false;
                JOptionPane.showMessageDialog(null, "El valor del parametro no puede ser menor que cero", "Error de parametro", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(NumberFormatException e)
        {
            bandera = false;
            JOptionPane.showMessageDialog(null, "El valor del parametro debe ser numerico", "Error de parametro", JOptionPane.ERROR_MESSAGE);
        }
        return bandera;
    }

    public Collection generarNumeros(Collection distribuciones)
    {
        this.distribucionesAGenerar = distribuciones;
        Collection numerosAleatorios = new ArrayList();
        Iterator it = this.distribucionesAGenerar.iterator();
        while(it.hasNext())
        {
            Datos d = (Datos)it.next();
            if(d.getDistribucion().trim().toUpperCase().equals("UNIFORME"))
                numerosAleatorios.add(this.getUniforme(d));
            if(d.getDistribucion().trim().toUpperCase().equals("NORMAL"))
                numerosAleatorios.add(this.getNormal(d));
            if(d.getDistribucion().trim().toUpperCase().equals("BINOMIAL"))
                numerosAleatorios.add(this.getBinomial(d));
            if(d.getDistribucion().trim().toUpperCase().equals("TRIANGULAR"))
                numerosAleatorios.add(this.getTriangular(d));
            if(d.getDistribucion().trim().toUpperCase().equals("EXPONENCIAL"))
                numerosAleatorios.add(this.getExponencial(d));
            if(d.getDistribucion().trim().toUpperCase().equals("ERLANG"))
                numerosAleatorios.add(this.getErlang(d));
            if(d.getDistribucion().trim().toUpperCase().equals("POISSON"))
                numerosAleatorios.add(this.getPoisson(d));
            if(d.getDistribucion().trim().toUpperCase().equals("DIST. EMPIRICA"))
                numerosAleatorios.add(this.getEmpirica(d));
            if(d.getDistribucion().trim().toUpperCase().equals("WEIBULL"))
                numerosAleatorios.add(this.getWeibull(d));
            d = null;
        }
        return numerosAleatorios;
    }

    private Vector getUniforme(Datos d)
    {
        boolean bandera = true;
        Vector v = new Vector();
        Uniforme u = new Uniforme();
        u.setNombre(d.getDistribucion().trim());
        u.setMinimo(Double.parseDouble(d.getParametro1()));
        u.setMaximo(Double.parseDouble(d.getParametro2()));
        GeneradorUniforme g;
        if(d.getSemilla().trim().equals("AUTOGENERADA"))
            g = new GeneradorUniforme(u);
        else
            g = new GeneradorUniforme(u, Integer.parseInt(d.getSemilla()));
        for(int i=0; i<d.getCantidad(); i++)
        {
            if(bandera)
            {
                v.add(d.getNombreVariable().trim());
                bandera = false;
            }
            v.add(String.valueOf(g.getNumero()));
        }
        return v;
    }

    private Vector getWeibull(Datos d)
    {
        boolean bandera = true;
        Vector v = new Vector();
        Weibull w = new Weibull();
        w.setNombre(d.getDistribucion().trim());
        w.setAlfa(Double.parseDouble(d.getParametro1()));
        w.setBeta(Double.parseDouble(d.getParametro2()));
        GeneradorWeibull g;
        if(d.getSemilla().trim().equals("AUTOGENERADA"))
            g = new GeneradorWeibull(w);
        else
            g = new GeneradorWeibull(w, Integer.parseInt(d.getSemilla()));
        for(int i=0; i<d.getCantidad(); i++)
        {
            if(bandera)
            {
                v.add(d.getNombreVariable().trim());
                bandera = false;
            }
            v.add(String.valueOf(g.getNumero()));
        }
        return v;
    }

    private Vector getNormal(Datos d)
    {
        boolean bandera = true;
        Vector v = new Vector();
        Normal n = new Normal();
        n.setNombre(d.getDistribucion().trim());
        n.setMedia(Double.parseDouble(d.getParametro1()));
        n.setDesviacion(Double.parseDouble(d.getParametro2()));
        GeneradorNormal g;
        if(d.getSemilla().trim().equals("AUTOGENERADA"))
            g = new GeneradorNormal(n);
        else
            g = new GeneradorNormal(n, Integer.parseInt(d.getSemilla()));
        for(int i=0; i<d.getCantidad(); i++)
        {
            if(bandera)
            {
                v.add(d.getNombreVariable().trim());
                bandera = false;
            }
            v.add(String.valueOf(g.getNumero()));
        }
        return v;
    }

    private Vector getBinomial(Datos d)
    {
        boolean bandera = true;
        Vector v = new Vector();
        Binomial b = new Binomial();
        b.setNombre(d.getDistribucion().trim());
        b.setN(Integer.parseInt(d.getParametro1()));
        b.setP(Double.parseDouble(d.getParametro2()));
        GeneradorBinomial g;
        if(d.getSemilla().trim().equals("AUTOGENERADA"))
            g = new GeneradorBinomial(b);
        else
            g = new GeneradorBinomial(b, Integer.parseInt(d.getSemilla()));
        for(int i=0; i<d.getCantidad(); i++)
        {
            if(bandera)
            {
                v.add(d.getNombreVariable().trim());
                bandera = false;
            }
            v.add(String.valueOf(g.getNumero()));
        }
        return v;
    }

    private Vector getTriangular(Datos d)
    {
        boolean bandera = true;
        Vector v = new Vector();
        Triangular t = new Triangular();
        t.setNombre(d.getDistribucion().trim());
        t.setMinimo(Double.parseDouble(d.getParametro1()));
        t.setMedio(Double.parseDouble(d.getParametro2()));
        t.setMaximo(Double.parseDouble(d.getParametro3()));
        GeneradorTriangular g;
        if(d.getSemilla().trim().equals("AUTOGENERADA"))
            g = new GeneradorTriangular(t);
        else
            g = new GeneradorTriangular(t, Integer.parseInt(d.getSemilla()));
        for(int i=0; i<d.getCantidad(); i++)
        {
            if(bandera)
            {
                v.add(d.getNombreVariable().trim());
                bandera = false;
            }
            v.add(String.valueOf(g.getNumero()));
        }
        return v;
    }

    private Vector getExponencial(Datos d)
    {
        boolean bandera = true;
        Vector v = new Vector();
        Exponencial e = new Exponencial();
        e.setNombre(d.getDistribucion().trim());
        e.setLambda(Double.parseDouble(d.getParametro1()));
        GeneradorExponencial g;
        if(d.getSemilla().trim().equals("AUTOGENERADA"))
            g = new GeneradorExponencial(e);
        else
            g = new GeneradorExponencial(e, Integer.parseInt(d.getSemilla()));
        for(int i=0; i<d.getCantidad(); i++)
        {
            if(bandera)
            {
                v.add(d.getNombreVariable().trim());
                bandera = false;
            }
            v.add(String.valueOf(g.getNumero()));
        }
        return v;
    }

    private Vector getErlang(Datos d)
    {
        boolean bandera = true;
        Vector v = new Vector();
        Erlang e = new Erlang();
        e.setNombre(d.getDistribucion().trim());
        e.setMedia(Double.parseDouble(d.getParametro1()));
        e.setVarianza(Double.parseDouble(d.getParametro2()));
        GeneradorErlang g;
        if(d.getSemilla().trim().equals("AUTOGENERADA"))
            g = new GeneradorErlang(e);
        else
            g = new GeneradorErlang(e, Integer.parseInt(d.getSemilla()));
        for(int i=0; i<d.getCantidad(); i++)
        {
            if(bandera)
            {
                v.add(d.getNombreVariable().trim());
                bandera = false;
            }
            v.add(String.valueOf(g.getNumero()));
        }
        return v;
    }

    private Vector getPoisson(Datos d)
    {
        boolean bandera = true;
        Vector v = new Vector();
        Poisson p = new Poisson();
        p.setNombre(d.getDistribucion().trim());
        p.setMedia(Double.parseDouble(d.getParametro1()));
        GeneradorPoisson g;
        if(d.getSemilla().trim().equals("AUTOGENERADA"))
            g = new GeneradorPoisson(p);
        else
            g = new GeneradorPoisson(p, Integer.parseInt(d.getSemilla()));
        for(int i=0; i<d.getCantidad(); i++)
        {
            if(bandera)
            {
                v.add(d.getNombreVariable().trim());
                bandera = false;
            }
            v.add(String.valueOf(g.getNumero()));
        }
        return v;
    }

    private Vector getEmpirica(Datos d)
    {
        boolean bandera = true;
        Vector v = new Vector();
        Empirica e = new Empirica();
        e.setNombre(d.getDistribucion().trim());
        e.setA(d.getA());
        e.setR(d.getR());
        e.setX(d.getX());
        GeneradorEmpirico g = new GeneradorEmpirico(e);
        for(int i=0; i<d.getCantidad(); i++)
        {
            if(bandera)
            {
                v.add(d.getNombreVariable().trim());
                bandera = false;
            }
            v.add(String.valueOf(g.getNumero()));
        }
        return v;
    }



    public void cargarEmpirica(Empirica e, String nombre, int cantidad)
    {
        this.principal.agregarEmpirica(e, nombre, cantidad);
    }

}
