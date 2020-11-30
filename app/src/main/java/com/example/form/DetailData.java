package com.example.form;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.R;

public class DetailData extends AppCompatActivity {
    TextView area, tgl_kunjungan, namatmp, alamat, phone, pemilik, kebutuhan, keterangan, penanggungjwb, tgl_ultah ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        tgl_kunjungan = (TextView) findViewById(R.id.tgl_kunjungan);
        namatmp = (TextView) findViewById(R.id.tmp);
        alamat = (TextView) findViewById(R.id.almt);
        phone = (TextView) findViewById(R.id.ktk);
        pemilik = (TextView) findViewById(R.id.pemilik);
        penanggungjwb = (TextView) findViewById(R.id.pj);
        kebutuhan = (TextView) findViewById(R.id.butuh);
        keterangan = (TextView) findViewById(R.id.ket);
        tgl_ultah = (TextView) findViewById(R.id.tgl_ultah);
        area = (TextView) findViewById(R.id.area);

        tgl_kunjungan.setText(getIntent().getStringExtra("tgl_kunjungan"));
        namatmp.setText(getIntent().getStringExtra("namatmp"));
        alamat.setText(getIntent().getStringExtra("alamat"));
        phone.setText(getIntent().getStringExtra("phone"));
        pemilik.setText(getIntent().getStringExtra("pemilik"));
        penanggungjwb.setText(getIntent().getStringExtra("penanggungjwb"));
        kebutuhan.setText(getIntent().getStringExtra("kebutuhan"));
        keterangan.setText(getIntent().getStringExtra("keterangan"));
        tgl_ultah.setText(getIntent().getStringExtra("tgl_ultah"));
        area.setText(getIntent().getStringExtra("area"));
    }
}
