package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edNamaDepan;
    private EditText edNamaBelakang;
    private EditText edUmur;
    private Button btnSimpan;
    private ArrayList<String> daftarNama;
    private Intent intentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNamaDepan = findViewById(R.id.edNamaDepan);
        edNamaBelakang = findViewById(R.id.edNamaBelakang);
        edUmur = findViewById(R.id.edUmur);
        btnSimpan = findViewById(R.id.btnSimpan);

        daftarNama = new ArrayList<>();
        intentList = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isianNamaDepan = edNamaDepan.getText().toString();
                String isianNamaBelakang = edNamaBelakang.getText().toString();
                int isianUmur = Integer.parseInt(edUmur.getText().toString());

                int jumlah = 100;
                int totalUmur = isianUmur + jumlah;

                if (isianNamaDepan.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String namaLengkap = isianNamaDepan.concat(" ").concat(isianNamaBelakang);
                    daftarNama.add(namaLengkap);
                    edNamaDepan.setText("");
                    edNamaBelakang.setText("");
                    edUmur.setText(String.valueOf(totalUmur));
                    intentList.putStringArrayListExtra("daftar_nama", daftarNama);
                    startActivity(intentList);
                }
            }
        });

        // Looping saat input
        edNamaDepan.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    String isianNamaDepan = edNamaDepan.getText().toString();
                    if (!isianNamaDepan.isEmpty()) {
                        for (int i = 0; i < 100; i++) {
                            daftarNama.add(isianNamaDepan + " (" + (i + 100) + ")");
                        }
                    }
                }
            }
        });
    }
}
