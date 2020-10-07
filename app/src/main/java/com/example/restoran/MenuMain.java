package com.example.restoran;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuMain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private ArrayList<Menu> menuArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_menu);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new MenuAdapter(menuArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MenuMain.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
    void addData(){
        menuArrayList = new ArrayList<>();
        menuArrayList.add(new Menu("KODE : B01", "JENIS : Minuman", "NAMA : Kopi Hitam", "PENJELASAN : Kopi hitam dengan dibuat dengan teknik espresso, dimana biji koppi yang digunakan yaitu berasal dari Aceh Gayo jenis Arabika, disajikan dengan gula terpisah", "10.000"));
        menuArrayList.add(new Menu("KODE : B02", "JENIS : Minuman", "NAMA : Cappuccino", "PENJELASAN : Paduan kopi dengan buih susu kental serta mengandung sirup karamel, dimana biji kopi yang digunakan berasal dari gunung puntang jawa barat jenis robusta", "20.000"));
        menuArrayList.add(new Menu("KODE : M03", "JENIS : Minuman", "NAMA : Sparkling Tea", "PENJELASAN : Minuman teh yang menggunakan daun teh dari pegunungan daerah garut dengan tambahan sari melati asli dan gula merah alami", "15.000"));
        menuArrayList.add(new Menu("KODE : F01", "JENIS : Makanan", "NAMA : Batagor", "PENJELASAN : Baso dan Tahu Goreng dengan sajian bumbu kacang dan kecap khas bandung", "25.000"));
        menuArrayList.add(new Menu("KODE : F02", "JENIS : Makanan", "NAMA : Cireng", "PENJELASAN : Makanan ringan berupa tepung kanji goreng isi bahan dasar tempe fermentasi yang disebut oncom, disajikan dengan bumbu kacang pedas", "10.000"));
        menuArrayList.add(new Menu("KODE : F03", "JENIS : Makanan", "NAMA : Nasi Goreng", "PENJELASAN : Nasi goreng ayam yang disajikan dengan telur mata sapi disertai satai ayam", "50.000"));
        menuArrayList.add(new Menu("KODE : DO1", "JENIS : Dessert", "NAMA : Cheese Cake", "PENJELASAN : Kue Tart 1 slice dengan bahan utama cream cheese dengan topping buah buahan asli seperti anggurn jeruh, kiwi", "40.000"));
        menuArrayList.add(new Menu("KODE : DO2", "JENIS : Dessert", "NAMA : Black Salad", "PENJELASAN : Potongan buah-buahan segar yang terdiri dari pepaya, jambu, melon, dan Mangga disajikan dengan bumbu rujak kacang pedas dan gula merah", "30.000"));
    }
}
