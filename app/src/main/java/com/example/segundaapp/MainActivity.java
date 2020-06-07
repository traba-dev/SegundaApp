package com.example.segundaapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public ArrayList<String> list;
    public ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Elemento de UI
        listView = (ListView) findViewById(R.id.list_view);
        //Datos para la UI
        list = new ArrayList<String>(){{
            add("Christopher");
            add("Genaro");
            add("Coronado");
            add("Duarte");
            add("Christopher");
            add("Genaro");
            add("Coronado");
            add("Duarte");
            add("Christopher");
            add("Genaro");
            add("Coronado");
            add("Duarte");
            add("Christopher");
            add("Genaro");
            add("Coronado");
            add("Duarte");
            add("Christopher");
            add("Genaro");
            add("Coronado");
            add("Duarte");
            add("Christopher");
            add("Genaro");
            add("Coronado");
            add("Duarte");
        }};
        //Se adapta los datos según el layout que queremos
        //arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //Pinta el adaptador de los datos
        //listView.setAdapter(arrayAdapter);

        //Enlace con adaptador personalizado
        AdapterListPeople myAdapter = new AdapterListPeople(MainActivity.this, R.layout.adapter_list_people,list);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Nombre:" + list.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
