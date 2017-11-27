package com.example.rohit.studentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNotes extends AppCompatActivity {
    EditText editTextNoteName,editTextDiscription;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        editTextNoteName=findViewById(R.id.editTextNoteName);
        editTextDiscription=findViewById(R.id.editTextDiscription);
        buttonAdd=findViewById(R.id.bottonAddNote);



        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            addNotes();
            }
        });

    }
    public void addNotes(){
        String name=editTextNoteName.getText().toString();
        String discription=editTextDiscription.getText().toString();

        Notes notes=new Notes();
        notes.setName(name);
        notes.setDiscription(discription);

        Intent intent=new Intent();
        intent.putExtra("name",name);
        intent.putExtra("discription",discription);

        NotesDatabase notesDatabase=new NotesDatabase(AddNotes.this);
        long id=notesDatabase.insertNote(notes);

        Log.d("AddNotes","Notes Add "+id);
        setResult(RESULT_OK,intent);
        finish();


    }
}
