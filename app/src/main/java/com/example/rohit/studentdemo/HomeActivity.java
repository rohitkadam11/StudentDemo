package com.example.rohit.studentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    NoteAdapter noteAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView=findViewById(R.id.listView);

        noteAdapter=new NoteAdapter(HomeActivity.this);

        listView.setAdapter(noteAdapter);
        registerForContextMenu(listView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuitem,menu);
        
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selecteditem=item.getItemId();
        
        if(selecteditem == R.id.addNote){
            Intent intent=new Intent(HomeActivity.this,AddNotes.class);
            startActivityForResult(intent,1);
            Toast.makeText(this, "Add note selected", Toast.LENGTH_SHORT).show();
        }
        
        return super.onOptionsItemSelected(item);
    }


}
