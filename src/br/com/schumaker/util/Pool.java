package br.com.schumaker.util;

/**
 *
 * @author Hudson Schumaker
 * @param <T>
 */
public interface Pool<T> {
    T aquire();
    void release(T t);
}
