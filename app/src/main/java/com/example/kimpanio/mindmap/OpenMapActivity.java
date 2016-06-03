package com.example.kimpanio.mindmap;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class OpenMapActivity extends AppCompatActivity {

    private FileInputStream fileInputStream;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.openMapListView);

        File dir = new File(getFilesDir().getPath());
        final File[] fileList = dir.listFiles();
        final ArrayList<File> theNamesOfFiles = new ArrayList<File>();

        for (int i = 0; i < fileList.length; i++) {
            theNamesOfFiles.add(fileList[i]);
        }

        final ArrayAdapter<File> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, theNamesOfFiles);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void deleteFile(Intent intent){

    }

    public void openFile(File file) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.open_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.open_settings) {
            deleteFile(item.getIntent());
        }

        if (id == R.id.delete_settings) {
            System.out.println("Delete");
        }


        return super.onOptionsItemSelected(item);
    }

}