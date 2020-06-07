package com.example.segundaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    public GridView gridView;
    public ArrayList<String> list;
    private int counter = 0;
    public AdapterListPeople myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<String>(){{
            add("Christopher");
            add("Genaro");
            add("Coronado");
            add("Duarte");
        }};
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Nombre:" + list.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        myAdapter = new AdapterListPeople(GridActivity.this, R.layout.grid_item,list);
        gridView.setAdapter(myAdapter);

        registerForContextMenu(gridView);
    }//fin oncreate

    //Inflamos el layout del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }
    //evento click del menu de opciones
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                //agrega un nuevo elemento al arraylist
                this.list.add("Added n°" + (++counter));
                //Refresca el adaptador para agregar el valor nuevo del arraylist
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //Inflamos el layout del context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.list.get(info.position));

        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.context_menu:
                //Borrarmos item clickeado
                this.list.remove(info.position);
                //Refresca el adaptador para agregar el valor nuevo del arraylist
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
