package com.example.rohit.studentdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class NoteAdapter extends BaseAdapter {
    ArrayList<Notes> notesList;
    Context context;
    public  NoteAdapter(Context context){
        this.context=context;
        notesList=new ArrayList<Notes>();
    }
    @Override
    public int getCount() {
        return notesList.size();
    }

    @Override
    public Object getItem(int position) {
        return notesList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Notes notes=notesList.get(position);

        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View rootView=layoutInflater.inflate(R.layout.item_notes,viewGroup,false);

        TextView name=rootView.findViewById(R.id.textViewName);
        TextView discription=rootView.findViewById(R.id.textViewDiscription);

        name.setText(notes.getName());
        discription.setText(notes.getDiscription());

        return rootView;
    }
}
