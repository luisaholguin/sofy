/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.util;

import java.io.File;
import javax.swing.filechooser.*;

/**
 *
 * @author Administrador
 */
public class Mp3Filter extends FileFilter {

    //Accept all directories and all gif, jpg, tiff, or png files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null)
        {
            /*if (extension.equals(Utils.tiff) || extension.equals(Utils.tif) || extension.equals(Utils.gif) ||
                extension.equals(Utils.jpeg) ||
                extension.equals(Utils.jpg) ||
                extension.equals(Utils.png)) */
            if (extension.equals(Utils.mp3))
            {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Just Mp3";
    }
}
