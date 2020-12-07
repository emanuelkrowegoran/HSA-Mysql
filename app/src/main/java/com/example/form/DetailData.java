package com.example.form;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.R;

public class DetailData extends AppCompatActivity {
    TextView area, tanggal_kunjungan, nama, alamat, kontak, pemilik, kebutuhan, keterangan, penanggungjawab, ttl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        tanggal_kunjungan = (TextView) findViewById(R.id.tgl_kunjungan);
        nama = (TextView) findViewById(R.id.tmp);
        alamat = (TextView) findViewById(R.id.almt);
        kontak = (TextView) findViewById(R.id.ktk);
        pemilik = (TextView) findViewById(R.id.pemilik);
        penanggungjawab = (TextView) findViewById(R.id.pj);
        kebutuhan = (TextView) findViewById(R.id.butuh);
        keterangan = (TextView) findViewById(R.id.ket);
        ttl = (TextView) findViewById(R.id.tgl_ultah);
        area = (TextView) findViewById(R.id.area);

        tanggal_kunjungan.setText(getIntent().getStringExtra("tanggal_kunjungan"));
        nama.setText(getIntent().getStringExtra("nama"));
        alamat.setText(getIntent().getStringExtra("alamat"));
        kontak.setText(getIntent().getStringExtra("kontak"));
        pemilik.setText(getIntent().getStringExtra("pemilik"));
        penanggungjawab.setText(getIntent().getStringExtra("penanggungjawab"));
        kebutuhan.setText(getIntent().getStringExtra("kebutuhan"));
        keterangan.setText(getIntent().getStringExtra("keterangan"));
        ttl.setText(getIntent().getStringExtra("ttl"));
        area.setText(getIntent().getStringExtra("area"));
    }
}
