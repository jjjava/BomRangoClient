
package br.com.schumaker.util;

import java.io.File;

/**
 *
 * @author hudson
 */
public class HsFileTools {

    public static String getFileExtension(String fileName) {
        String ext[] = fileName.split("\\.");
        int i = ext.length;
        String result = "";
        if (i > 1) {
            result = ext[i - 1];
        }
        return result;
    }

    public static String getFileExtension(File file) {
        String ext[] = file.getName().split("\\.");
        int i = ext.length;
        String result = "";
        if (i > 1) {
            result = ext[i - 1];
        }
        return result;
    }

    public static String getClearName(String fileName) {
        String name[] = fileName.split("\\.");
        return name[0];
    }

    public static String getClearName(File file) {
        String name[] = file.getName().split("\\.");
        return name[0];
    }
}
