package br.com.schumaker.io;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Hudson Schumaker - HStudio 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".JPG") || file.getName().endsWith(".jpg")
                || file.getName().endsWith(".JPEG") || file.getName().endsWith(".jpeg")
                || file.getName().endsWith(".PNG") || file.getName().endsWith("png")
                || file.getName().endsWith(".BMP") || file.getName().endsWith(".bmp");
    }
}
