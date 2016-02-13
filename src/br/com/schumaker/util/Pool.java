package br.com.schumaker.util;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 * @param <T>
 */
public interface Pool<T> {
    T aquire();
    void release(T t);
}
