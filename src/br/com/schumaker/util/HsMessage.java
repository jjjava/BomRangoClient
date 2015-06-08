package br.com.schumaker.util;

import javax.swing.JOptionPane;

/**
 *
 * @author hudsonschumaker
 */
public class HsMessage {

    public static void mostrarMensagem(int type, String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, type);
    }
}
