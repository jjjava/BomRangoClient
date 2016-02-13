package br.com.schumaker.io;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Hudson Schumaker - HStudio 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsFile {

    public static void writeOnDisk(BufferedImage img, String type, String path, String name) {
        try {
            ImageIO.write(img, type, new File(path + "/" + name));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static Image readFromDisk(String path) {
        Image image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return image;
    }

    public static Image readFromDisk(File file) {
        Image image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return image;
    }

    public static boolean verifyFileExtension(String filename) {
        String ext[] = filename.split("\\.");
        int i = ext.length;
        String result = "";
        if (i > 1) {
            result = ext[i - 1];
        }
        return result.equalsIgnoreCase("png") || result.equalsIgnoreCase("jpg") || result.equalsIgnoreCase("bmp");
    }

    public static String getFileExtension(String filename) {
        String ext[] = filename.split("\\.");
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
}
