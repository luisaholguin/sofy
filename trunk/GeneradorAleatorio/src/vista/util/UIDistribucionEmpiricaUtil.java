/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import java.util.Arrays;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carolina
 */
public class UIDistribucionEmpiricaUtil
{

    private Vector intervaloFrecuencia = new Vector();
    private Vector intervaloNoFrecuencia = new Vector();


    public UIDistribucionEmpiricaUtil()
    {
    }

    public void cargarIntervalo(JTable tabla, double valor)
    {

    }

    public boolean validar(JTextField campo)
    {
        boolean bandera = true;
        if(campo.getText().trim().length() == 0)
        {
            bandera = false;
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor a cargar", "Error de parametro", JOptionPane.ERROR_MESSAGE);
        }

        else
        {
            try
            {
                double valor = Double.parseDouble(campo.getText());
            }
            catch(NumberFormatException e)
            {
                bandera = false;
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico", "Error de parametro", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return bandera;
    }

    /**
     *
     * @param nombre
     * @param cantidad
     * @param frecuencia
     * @param noFrecuencia
     * @param selecion verdader indica que hay que validar la tabla frecuencia. Falso, hay que evaluar la tabla noFrecuencia
     * @return
     */
    public boolean validar(JTextField nombre, JTextField cantidad, JTable frecuencia, JTable noFrecuencia, boolean seleccion)
    {
        //validar TextFields
        boolean bandera = true;
        boolean banderaTabla = true;
        if(nombre.getText().trim().length() == 0)
            bandera = false;
        else
        {
            if(cantidad.getText().trim().length() == 0)
                bandera = false;
            else
            {
                try
                {
                    int valor = Integer.parseInt(cantidad.getText());
                }
                catch(NumberFormatException e)
                {
                    bandera = false;
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor entero como cantidad", "Error de parametro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(!bandera)
            JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error de parametro", JOptionPane.ERROR_MESSAGE);

        if(seleccion)
        {
            //verificar que la tabla tenga todos los campos llenos
            for(int i=0; i<frecuencia.getRowCount(); i++)
            {
                String campo1 = String.valueOf(frecuencia.getValueAt(i, 1));
                String campo2 = String.valueOf(frecuencia.getValueAt(i, 2));
                String campo3 = String.valueOf(frecuencia.getValueAt(i, 3));
                if(((campo1.trim().length() == 0) || (campo1.trim().equals("null"))) || ((campo2.trim().length() == 0) || (campo2.trim().equals("null"))) || ((campo3.trim().length() == 0) || (campo3.trim().equals("null"))))
                    banderaTabla = false;
            }
        }
        else
        {
            for(int i=0; i<noFrecuencia.getRowCount(); i++)
            {
                String campo1 = String.valueOf(noFrecuencia.getValueAt(i, 1));
                String campo2 = String.valueOf(noFrecuencia.getValueAt(i, 2));
                if(((campo1.trim().length() == 0) || (campo1.trim().equals("null"))) || ((campo2.trim().length() == 0) || (campo2.trim().equals("null"))))
                    banderaTabla = false;
            }
        }
        if(!banderaTabla)
            JOptionPane.showMessageDialog(null, "Hay campos vacios en la tabla", "Error de parametro", JOptionPane.ERROR_MESSAGE);
        if(!banderaTabla || !bandera)
            bandera = false;
        
        return bandera;
    }

    public void deshabilitar(JTable tabla, JTextField campo, JButton boton)
    {
        tabla.setEnabled(false);
        campo.setEnabled(false);
        boton.setEnabled(false);
    }

    public void habilitar(JTable tabla, JTextField campo, JButton boton)
    {
        tabla.setEnabled(true);
        campo.setEnabled(true);
        boton.setEnabled(true);
    }
    
    public void limpiar(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        while(tabla.getRowCount() != 0)
                modelo.removeRow(0);
        modelo = null;
    }

    /**
     *
     * @param vector
     * @param valor
     * @param tabla
     * @param frecuencia el parametro frecuencia si es verdadero quiere decir que la frecuencia fue ingresada por el usuario.
     * Si es falso es porque la frecuencia es autogenerada
     * @return
     */
    public Vector cargar(Vector vector, JTextField valor, JTable tabla, boolean frecuencia)
    {
        vector.add(Double.parseDouble(valor.getText()));
        double[] v = this.convertVectorToDouble(vector);
//        double[] v = new double[vector.size()];
//        for(int i=0; i<vector.size(); i++)
//        {
//            v[i] = Double.parseDouble(String.valueOf(vector.elementAt(i)));
//        }
        if((Arrays.binarySearch(v, 0.0) == -1) && !frecuencia)
        {
            vector.add(0.0);
            v = this.convertVectorToDouble(vector);
        }
        Arrays.sort(v);
        this.mostrar(tabla, v);
        vector.clear();
        for(int j=0; j<v.length; j++)
        {
            vector.add(v[j]);
        }
        return vector;
    }

    private void mostrar(JTable tabla, double[] v)
    {
        this.limpiar(tabla);
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String[] campo = new String[1];
        if(v.length > 1)
        {
            for(int i=0; i<(v.length - 1); i++)
            {
                campo[0] = String.valueOf(v[i])+" < x <= "+String.valueOf(v[i+1]);
                modelo.addRow(campo);
            }
        }
    }

    public Vector generarProbabilidades(JTable tabla)
    {
        Vector pAcum = new Vector();
        double probabilidad = 1.0/tabla.getRowCount();
        double acumulada = 0.0;
        String[] datos = new String[3];
        for(int i=0; i<tabla.getRowCount(); i++)
        {
            datos[1] = String.valueOf(probabilidad);
            acumulada = acumulada + probabilidad;
            datos[2] = String.valueOf(acumulada);
            tabla.setValueAt(Double.parseDouble(datos[1]), i, 1);
            tabla.setValueAt(Double.parseDouble(datos[2]), i, 2);
            if(pAcum.size() == 0)
                pAcum.add(0.0);
            pAcum.add(acumulada);
        }
        return pAcum;
    }

    /**
     * calcula la frecuencia acumulada y devuelve un vector con las frecuencias acumuladas
     * @param tabla
     * @return
     */
    public Vector calcularFrecuencias(JTable tabla)
    {
        Vector frecAcum = new Vector();
        double N = 0.0;
        double acumulada = 0.0;
        for(int i=0; i<tabla.getRowCount(); i++)
        {
            if(tabla.getValueAt(i, 1) != null)
                N = N + Double.parseDouble(String.valueOf(tabla.getValueAt(i, 1)));
        }

        for(int i=0; i<tabla.getRowCount(); i++)
        {
            if(tabla.getValueAt(i, 1) != null)
            {
                double relativa = Double.parseDouble(String.valueOf(tabla.getValueAt(i, 1)))/N;
                tabla.setValueAt(relativa, i, 2);
                acumulada = acumulada + relativa;
                tabla.setValueAt(acumulada, i, 3);
                if(frecAcum.size() == 0)
                    frecAcum.add(0.0);
                frecAcum.add(acumulada);
            }
        }
        return frecAcum;
    }

    public double[] convertVectorToDouble(Vector v)
    {
        int size = v.size();
        double[] vec = new double[size];
        for(int i=0; i<size; i++)
            vec[i] = Double.parseDouble(String.valueOf(v.elementAt(i)));
        return vec;
    }
    
    public Vector calcularPendiente(Vector r, Vector x)
    {
        Vector pendiente = new Vector();
        double p = 0.0;
        int size = x.size();
        for(int i=0; i<(size -1); i++)
        {
            p = (Double.parseDouble(String.valueOf(x.elementAt(i+1))) - Double.parseDouble(String.valueOf(x.elementAt(i))))
                    / 
                (Double.parseDouble(String.valueOf(r.elementAt(i+1))) - Double.parseDouble(String.valueOf(r.elementAt(i))));
            pendiente.add(p);
        }
        return pendiente;
    }
}
