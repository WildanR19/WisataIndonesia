package com.wildan.wisataindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.text.TextUtils.isEmpty;

public class AddWisataActivity extends AppCompatActivity {

    private DatabaseReference database;
    // variable fields EditText dan Button
    private Button btnTambah;
    private EditText etNama, etLat, etLong;
    private Spinner prov;
    Wisata wisata;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wisata);

        getSupportActionBar().setTitle("Tambah Tempat Wisata");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnTambah = (Button) findViewById(R.id.btn_tambah);
        etNama = (EditText) findViewById(R.id.input_nama);
        etLat = (EditText) findViewById(R.id.input_lat);
        etLong = (EditText) findViewById(R.id.input_long);
        prov = (Spinner) findViewById(R.id.spinProv);
        wisata = new Wisata();

        database = FirebaseDatabase.getInstance().getReference().child("wisata");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    maxid = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double lat = Double.parseDouble(etLat.getText().toString().trim());
                Double lon = Double.parseDouble(etLong.getText().toString().trim());
                String tprov = prov.getSelectedItem().toString().trim();
                wisata.setNama(etNama.getText().toString().trim());
                wisata.setLat(lat);
                wisata.setLon(lon);
                wisata.setProvinsi(tprov);
                database.child(String.valueOf(maxid + 1)).setValue(wisata);
                Toast.makeText(AddWisataActivity.this, "Data Berhasil Ditambahkan!", Toast.LENGTH_LONG).show();
                etNama.setText("");
                etLat.setText("");
                etLong.setText("");
                prov.setSelection(0);
            }
        });
    }
}