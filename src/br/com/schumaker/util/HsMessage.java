package br.com.schumaker.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsMessage {

    public static void mostrarMensagem(int type, String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, type);
    }
}
