package com.example.form;

public class Model {
    String id,tanggal_kunjungan,nama,kontak,alamat,pemilik,kebutuhan,penanggungjawab, keterangan, ttl, area;

    public Model(String id ,String tanggal_kunjungan, String nama, String kontak, String alamat, String pemilik, String penanggungjawab, String kebutuhan,  String keterangan, String ttl, String area ) {
        this.id = id;
        this.tanggal_kunjungan = tanggal_kunjungan;
        this.nama = nama;
        this.kontak = kontak;
        this.alamat = alamat;
        this.penanggungjawab = penanggungjawab;
        this.pemilik = pemilik;
        this.kebutuhan = kebutuhan;
        this.keterangan = keterangan;
        this.ttl = ttl;
        this.area = area;
    }

    public String getId(){
        return id;
    }
    public String getTanggal_kunjungan(){
        return tanggal_kunjungan;
    }
    public String getNama(){
        return nama;
    }

    public String getKontak(){
        return kontak;
    }

    public String getAlamat(){
        return alamat;
    }
    public String getPenanggungjawab(){
        return penanggungjawab;
    }

    public String getPemilik(){
        return pemilik;
    }
    public String getKebutuhan(){
        return kebutuhan;
    }
    public String getKeterangan(){
        return keterangan;
    }
    public String getTtl(){
        return ttl;
    }
    public  String getArea() { return  area;}

}
