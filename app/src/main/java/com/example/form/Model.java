package com.example.form;

public class Model {
    String id,tgl_kunjungan,namatmp,phone,alamat,pemilik,kebutuhan,penanggungjwb, keterangan, tgl_ultah, area;

    public Model(String id ,String tgl_kunjungan, String namatmp, String phone, String alamat, String pemilik, String penanggungjwb, String kebutuhan,  String keterangan, String tgl_ultah, String area ) {
        this.id = id;
        this.tgl_kunjungan = tgl_kunjungan;
        this.namatmp = namatmp;
        this.phone = phone;
        this.alamat = alamat;
        this.penanggungjwb = penanggungjwb;
        this.pemilik = pemilik;
        this.kebutuhan = kebutuhan;
        this.keterangan = keterangan;
        this.tgl_ultah = tgl_ultah;
        this.area = area;
    }

    public String getId(){
        return id;
    }
    public String getTgl_kunjungan(){
        return tgl_kunjungan;
    }
    public String getNamatmp(){
        return namatmp;
    }

    public String getPhone(){
        return phone;
    }

    public String getAlamat(){
        return alamat;
    }
    public String getPenanggungjwb(){
        return penanggungjwb;
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
    public String getTgl_ultah(){
        return tgl_ultah;
    }
    public  String getArea() { return  area;}

}
