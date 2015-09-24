package com.example.usuario.listviewimagen;

import android.app.ListActivity;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        String[] lista = {"_id", "imagen", "titulo", "descripcion"};
        MatrixCursor cursor = new MatrixCursor(lista);
        cursor.addRow(new Object[]{"0", R.drawable.pudge, "Heroe", "Accesorio de DOTA2"});
        cursor.addRow(new Object[]{"1", R.drawable.bu, "Imagen", "Bailando con Bu"});

        String[] Desdeestascolumnas = {"imagen", "titulo", "Descripcion"};
        int[] Aestascolumnas = {R.id.Imag, R.id.Texto1, R.id.Texto2};
        SimpleCursorAdapter simple = new SimpleCursorAdapter(this, R.layout.activity_main, cursor, Desdeestascolumnas, Aestascolumnas, 0);

        final ListView l = getListView();
        l.setAdapter(simple);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(getApplicationContext(), "Profe una helenas", Toast.LENGTH_SHORT).show();
                        Intent item = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(item);
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Profe no quiere bailar n.n", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
