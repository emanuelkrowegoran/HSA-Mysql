package com.example.form;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Model> listItems;
    private Context context;
    private ProgressDialog dialog;


    public MyAdapter(List<Model> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView id;
        public TextView tanggal_kunjungan;
        public TextView nama;
        public TextView alamat;
        public TextView kontak;
        public TextView pemilik;
        public TextView kebutuhan;
        public TextView penanggungjawab;
        public TextView keterangan;
        public CardView card_view;
        public TextView ttl;
        public TextView area;

        public ViewHolder(View itemView ) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            tanggal_kunjungan = (TextView) itemView.findViewById(R.id.tgl_kunjungan);
            nama = (TextView) itemView.findViewById(R.id.tmp);
            alamat = (TextView) itemView.findViewById(R.id.almt);
            kontak = (TextView) itemView.findViewById(R.id.ktk);
            pemilik = (TextView) itemView.findViewById(R.id.pemilik);
            kebutuhan = (TextView) itemView.findViewById(R.id.butuh);
            penanggungjawab = (TextView) itemView.findViewById(R.id.pj);
            keterangan = (TextView) itemView.findViewById(R.id.ket);
            ttl = (TextView) itemView.findViewById(R.id.tgl_ultah);
            area = (TextView) itemView.findViewById(R.id.area) ;

            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Model listItem = listItems.get(position);
        holder.id.setText(listItem.getId());
        holder.tanggal_kunjungan.setText(listItem.getTanggal_kunjungan());
        holder.nama.setText(listItem.getNama());
        holder.alamat.setText(listItem.getAlamat());
        holder.kontak.setText(listItem.getKontak());
        holder.pemilik.setText(listItem.getPemilik());
        holder.kebutuhan.setText(listItem.getKebutuhan());
        holder.penanggungjawab.setText(listItem.getPenanggungjawab());
        holder.keterangan.setText(listItem.getKeterangan());
        holder.ttl.setText(listItem.getTtl());
        holder.area.setText(listItem.getArea());

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                final ProgressDialog dialog = new ProgressDialog(view.getContext());
                dialog.setMessage("Loading Delete Data");
                final CharSequence[] dialogitem = {"View Data","Edit Data","Delete Data"};
                builder.setTitle(listItem.getNama());
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0 :
                                Intent intent = new Intent(view.getContext(), DetailData.class);
                                intent.putExtra("id", listItem.getId());
                                intent.putExtra("tanggal_kunjungan",listItem.getTanggal_kunjungan());
                                intent.putExtra("nama",listItem.getNama());
                                intent.putExtra("alamat",listItem.getAlamat());
                                intent.putExtra("kontak", listItem.getKontak());
                                intent.putExtra("pemilik", listItem.getPemilik());
                                intent.putExtra("kebutuhan", listItem.getKebutuhan());
                                intent.putExtra("penanggungjawab", listItem.getPenanggungjawab());
                                intent.putExtra("keterangan", listItem.getKeterangan());
                                intent.putExtra("ttl", listItem.getTtl());
                                intent.putExtra("area",listItem.getArea());

                                view.getContext().startActivity(intent);
                                break;
                            case 1 :

                                Intent intent2 = new Intent(view.getContext(), EditActivity.class);
                                intent2.putExtra("id", listItem.getId());
                                intent2.putExtra("tanggal_kunjungan",listItem.getTanggal_kunjungan());
                                intent2.putExtra("nama",listItem.getNama());
                                intent2.putExtra("alamat",listItem.getAlamat());
                                intent2.putExtra("kontak", listItem.getKontak());
                                intent2.putExtra("pemilik", listItem.getPemilik());
                                intent2.putExtra("kebutuhan", listItem.getKebutuhan());
                                intent2.putExtra("penanggungjawab", listItem.getPenanggungjawab());
                                intent2.putExtra("keterangan", listItem.getKeterangan());
                                intent2.putExtra("ttl", listItem.getTtl());
                                intent2.putExtra("area", listItem.getArea());

                                view.getContext().startActivity(intent2);
                                break;
                            case 2 :

                                AlertDialog.Builder builderDel = new AlertDialog.Builder(view.getContext());
                                builderDel.setTitle(listItem.getNama());
                                builderDel.setMessage("Are You Sure, You Want to Delete Data?");
                                builderDel.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialog.show();

                                        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_DELETE, new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                dialog.hide();
                                                dialog.dismiss();
                                                Toast.makeText(view.getContext(),"Berhasil Delete Data "+ listItem.getNama(),Toast.LENGTH_LONG).show();
                                                ListActivity.ma.refresh_list();

                                            }
                                        }, new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                dialog.hide();
                                                dialog.dismiss();
                                            }
                                        }){
                                            protected HashMap<String, String> getParams() throws AuthFailureError {
                                                Map<String, String> params= new HashMap<>();
                                                params.put("id",listItem.getId());
                                                return (HashMap<String, String>) params;

                                            }
                                        };
                                        RequestHandler.getInstance(view.getContext()).addToRequestQueue(stringRequest);
                                        dialogInterface.dismiss();
                                    }
                                });

                                builderDel.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override

                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });


                                builderDel.create().show();
                                break;
                        }
                    }
                });

                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}