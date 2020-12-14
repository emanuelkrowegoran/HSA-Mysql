package com.example.form;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class EditActivity extends AppCompatActivity {


    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    DatePickerDialog.OnDateSetListener date2;


    Spinner area;
    TextView tanggal_kunjungan, ttl;
    EditText nama, alamat, kontak, pemilik, kebutuhan, penanggungjawab, keterangan;
    String Tanggal_kunjungan, Nama, Alamat, Kontak,Id, Pemilik, Kebutuhan, Penanggungjawab, Keterangan, Ttl;
    Button button;
    Boolean valid = true;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final String[] Area = {"Kota", "Utara", "Timur", "Barat" , "Selatan"};
//getting views
        area = (Spinner) findViewById(R.id.area);

        tanggal_kunjungan = findViewById(R.id.tgl_kunjungan);
        nama = (EditText) findViewById(R.id.tmp);
        alamat = (EditText) findViewById(R.id.almt);
        kontak = (EditText) findViewById(R.id.ktk);
        penanggungjawab = (EditText) findViewById(R.id.pj);
        pemilik = (EditText) findViewById(R.id.pemilik);
        kebutuhan = (EditText) findViewById(R.id.butuh);
        keterangan = (EditText) findViewById(R.id.ket);
        ttl = findViewById(R.id.tgl_ultah);

        progressDialog = new ProgressDialog(this);
        button = (Button) findViewById(R.id.button);


        ArrayAdapter<CharSequence> adapterAreaa = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, Area);
        adapterAreaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        area.setAdapter(adapterAreaa);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                TextView tanggal = findViewById(R.id.tgl_kunjungan);
                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tanggal.setText(sdf.format(myCalendar.getTime()));
            }
        };

        tanggal_kunjungan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditActivity.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        date2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tgl = findViewById(R.id.tgl_ultah);
                String myFormat = "yyyy-MM-dd hh:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tgl.setText(sdf.format(myCalendar.getTime()));
            }
        };

        ttl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditActivity.this, date2,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        Id = getIntent().getStringExtra("id");
        tanggal_kunjungan.setText(getIntent().getStringExtra("tanggal_kunjungan"));
        nama.setText(getIntent().getStringExtra("nama"));
        alamat.setText(getIntent().getStringExtra("alamat"));
        kontak.setText(getIntent().getStringExtra("kontak"));
        pemilik.setText(getIntent().getStringExtra("pemilik"));
        kebutuhan.setText(getIntent().getStringExtra("kebutuhan"));
        penanggungjawab.setText(getIntent().getStringExtra("penanggungjawab"));
        keterangan.setText(getIntent().getStringExtra("keterangan"));
        ttl.setText(getIntent().getStringExtra("ttl"));



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tanggal_kunjungan = tanggal_kunjungan.getText().toString();
                Nama = nama.getText().toString();
                Alamat = alamat.getText().toString();
                Kontak = kontak.getText().toString();
                Pemilik = pemilik.getText().toString();
                Kebutuhan = kebutuhan.getText().toString();
                Penanggungjawab = penanggungjawab.getText().toString();
                Keterangan = keterangan.getText().toString();
                Ttl = ttl.getText().toString();
                final String Area = area.getSelectedItem().toString();

                if (TextUtils.isEmpty(Tanggal_kunjungan)) {
                    tanggal_kunjungan.setError("Tanggal Kunjungan Tidak Boleh Kosong");
                    valid = false;
                } else {
                    valid = true;

                    if (TextUtils.isEmpty(Nama)) {
                        nama.setError("Nama Tempat Tidak Boleh Kosong");
                        valid = false;
                    } else {
                        valid = true;

                        if (TextUtils.isEmpty(Alamat)) {
                            alamat.setError("Alamat Tidak Boleh Kosong");
                            valid = false;
                        } else {
                            valid = true;

                            if (TextUtils.isEmpty(Kontak)) {
                                kontak.setError("Kontak Tidak Boleh Kosong");
                                valid = false;
                            } else {
                                valid = true;

                                if (TextUtils.isEmpty(Pemilik)) {
                                    pemilik.setError("Pemilik Tidak Boleh Kosong");
                                    valid = false;
                                } else {
                                    valid = true;

                                    if (TextUtils.isEmpty(Penanggungjawab)) {
                                        penanggungjawab.setError("Penanggung jawab Tidak Boleh Kosong");
                                        valid = false;
                                    } else {
                                        valid = true;

                                        if (TextUtils.isEmpty(Kebutuhan)) {
                                            kebutuhan.setError("Kebutuhan Tidak Boleh Kosong");
                                            valid = false;
                                        } else {
                                            valid = true;

                                            if (TextUtils.isEmpty(Keterangan)) {
                                                keterangan.setError("Keterangan Tidak Boleh Kosong");
                                                valid = false;
                                            } else {
                                                valid = true;

                                                if (TextUtils.isEmpty(Ttl)) {
                                                    ttl.setError("Tanggal Ulang Tahun Tidak Boleh Kosong");
                                                    valid = false;
                                                } else {
                                                    valid = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if(valid){
                    progressDialog.setMessage("Loading");
                    progressDialog.show();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_UPDATE, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            try{
                                JSONObject jsonObject = new JSONObject(response);
                                Toast.makeText(EditActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                if(jsonObject.getString("message").equals("Edit Data Successful")){
                                    ListActivity.ma.refresh_list();
                                    finish();
                                }
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.hide();
                            Toast.makeText(EditActivity.this, "Failed",Toast.LENGTH_SHORT).show();
                        }
                    }){
                        protected Map<String , String> getParams() throws AuthFailureError {
                            Map<String , String> params = new HashMap<>();
                            params.put("id", Id);
                            params.put("nama", Nama);
                            params.put("tanggal_kunjungan", Tanggal_kunjungan);
                            params.put("kontak", Kontak);
                            params.put("alamat", Alamat);
                            params.put("penanggungjawab", Penanggungjawab);
                            params.put("pemilik", Pemilik);
                            params.put("kebutuhan", Kebutuhan);
                            params.put("keterangan", Keterangan);
                            params.put("ttl", Ttl);
                            params.put("area", Area);

                            return params;
                        }
                    };
                    RequestHandler.getInstance(EditActivity.this).addToRequestQueue(stringRequest);
                    Intent intent = new Intent(EditActivity.this, ListActivity.class);
                    startActivity(intent);

                }
            }
        });
    }
}
