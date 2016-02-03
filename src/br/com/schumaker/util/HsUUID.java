package br.com.schumaker.util;

import java.util.UUID;

/**
 *
 * @author hudson schumaker @Samurai 1.0.20 08/11/15
 * @version 1.0.0
 * @since 1.0.20
 */
public class HsUUID {

    public static String getAnUUID() {
        return UUID.randomUUID().toString();
    }
}
