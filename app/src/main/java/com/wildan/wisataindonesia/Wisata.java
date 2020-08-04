package com.wildan.wisataindonesia;

import java.io.Serializable;

public class Wisata implements Serializable {
    private String nama;
    private Double lat;
    private Double lon;
    private String provinsi;

    public Wisata(){

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    /*@Override
    public String toString() {
        return " "+nama +"\n" +
                " "+lat +"\n" +
                " "+lon +"\n" +
                " "+provinsi;
    }
    public Wisata(String nm, Double lt, Double ln, String prov){
        nama = nm;
        lat = lt;
        lon = ln;
        provinsi = prov;
    }*/
}
