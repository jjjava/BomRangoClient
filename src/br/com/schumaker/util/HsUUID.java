package br.com.schumaker.util;

import java.util.UUID;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsUUID {

    public static String getAnUUID() {
        return UUID.randomUUID().toString();
    }
}
