package com.example.ujianandroid;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = (ListView) findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        if(daftar_nama.isEmpty()){
            daftar_nama.add("data masih kosong");
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);

        lvNama.setAdapter(ad_nama);
        ArrayList<Integer> daftar_umur = new ArrayList<>();

        for (String nama : daftar_nama) {
            // Lakukan sesuatu dengan nama, misalnya mencetaknya
            System.out.println(daftar_nama);
        }


    }
}