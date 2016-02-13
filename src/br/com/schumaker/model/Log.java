package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 04/02/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Log {
    private int id;
    private String clazz;
    private String error;
    private String date;
    
    public Log(){  
    }

    public Log(int id) {
        this.id = id;
    }

    public Log(int id, String clazz, String error, String date) {
        this.id = id;
        this.clazz = clazz;
        this.error = error;
        this.date = date;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", clazz=" + clazz + ", error=" + error + ", date=" + date + '}';
    }
    
}