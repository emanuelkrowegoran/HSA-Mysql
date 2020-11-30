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
    TextView tgl_kunjungan,tgl_ultah;
    EditText  namatmp, alamat, phone, pemilik, kebutuhan, penanggungjwb, keterangan;
    String Area,Tgl_kunjungan, Namatmp, Alamat, Phone,Id, Pemilik, Kebutuhan, Penanggungjwb, Keterangan, Tgl_ultah;
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
        tgl_kunjungan = findViewById(R.id.tgl_kunjungan);
        namatmp = (EditText) findViewById(R.id.tmp);
        alamat = (EditText) findViewById(R.id.almt);
        phone = (EditText) findViewById(R.id.ktk);
        pemilik = (EditText) findViewById(R.id.pemilik);
        kebutuhan = (EditText) findViewById(R.id.butuh);
        penanggungjwb = (EditText) findViewById(R.id.pj);
        keterangan = (EditText) findViewById(R.id.ket);
        tgl_ultah = findViewById(R.id.tgl_ultah);

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
                String myFormat = "dd MMMM yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tanggal.setText(sdf.format(myCalendar.getTime()));
            }
        };

        tgl_kunjungan.setOnClickListener(new View.OnClickListener() {
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
                String myFormat = "dd MMMM yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tgl.setText(sdf.format(myCalendar.getTime()));
            }
        };

        tgl_ultah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditActivity.this, date2,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        Id = getIntent().getStringExtra("id");
        tgl_kunjungan.setText(getIntent().getStringExtra("tgl_kunjungan"));
        namatmp.setText(getIntent().getStringExtra("namatmp"));
        alamat.setText(getIntent().getStringExtra("alamat"));
        phone.setText(getIntent().getStringExtra("phone"));
        pemilik.setText(getIntent().getStringExtra("pemilik"));
        kebutuhan.setText(getIntent().getStringExtra("kebutuhan"));
        penanggungjwb.setText(getIntent().getStringExtra("penanggungjwb"));
        keterangan.setText(getIntent().getStringExtra("keterangan"));
        tgl_ultah.setText(getIntent().getStringExtra("tgl_ultah"));



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tgl_kunjungan = tgl_kunjungan.getText().toString();
                Namatmp = namatmp.getText().toString();
                Alamat = alamat.getText().toString();
                Phone = phone.getText().toString();
                Pemilik = pemilik.getText().toString();
                Kebutuhan = kebutuhan.getText().toString();
                Penanggungjwb = penanggungjwb.getText().toString();
                Keterangan = keterangan.getText().toString();
                Tgl_ultah = tgl_ultah.getText().toString();
                final String Area = area.getSelectedItem().toString();

                if(TextUtils.isEmpty(Tgl_kunjungan)){
                    tgl_kunjungan.setError("Tanggal Kunjungan Cannot be Empty");
                    valid = false;
                }else {
                    valid = true;

                    if(TextUtils.isEmpty(Namatmp)){
                        namatmp.setError("Name Cannot be Empty");
                        valid = false;
                    }else {
                        valid = true;

                        if(TextUtils.isEmpty(Alamat)){
                            alamat.setError("Address Cannot be Empty");
                            valid = false;
                        }else {
                            valid = true;

                            if(TextUtils.isEmpty(Phone)){
                                phone.setError("Contact Number Cannot be Empty");
                                valid = false;
                            }else {
                                valid = true;

                                if(TextUtils.isEmpty(Pemilik)){
                                    pemilik.setError("Pemilik Cannot be Empty");
                                    valid = false;
                                }else {
                                    valid = true;

                                    if(TextUtils.isEmpty(Penanggungjwb)){
                                        penanggungjwb.setError("Penanggung jawab Cannot be Empty");
                                        valid = false;
                                    }else {
                                        valid = true;

                                        if(TextUtils.isEmpty(Kebutuhan)){
                                            kebutuhan.setError("Kebutuhan Cannot be Empty");
                                            valid = false;
                                        }else {
                                            valid = true;

                                            if(TextUtils.isEmpty(Keterangan)){
                                                keterangan.setError("Keterangan Cannot be Empty");
                                                valid = false;
                                            }else {
                                                valid = true;

                                                if(TextUtils.isEmpty(Tgl_ultah)){
                                                    tgl_ultah.setError("Tgl ultah Cannot be Empty");
                                                    valid = false;
                                                }else {
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
                            params.put("namatmp", Namatmp);
                            params.put("tgl_kunjungan", Tgl_kunjungan);
                            params.put("phone", Phone);
                            params.put("alamat",Alamat);
                            params.put("pemilik",Pemilik);
                            params.put("keterangan",Keterangan);
                            params.put("kebutuhan",Kebutuhan);
                            params.put("penanggungjwb",Penanggungjwb);
                            params.put("tgl_ultah", Tgl_ultah);
                            params.put("area",Area);

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
