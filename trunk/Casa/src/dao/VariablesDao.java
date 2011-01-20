/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Variable;
import java.util.Collection;

/**
 *
 * @author marcelo
 */
public interface VariablesDao
{

    public Variable get(int id);
    public Collection getAll();

}
