package com.example.vivek.collegemanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ProfessorHome extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<String> classData = new ArrayList<>();

        classData.add("I-A");
        classData.add("II-B");
        classData.add("III-A");
        classData.add("IV-A");

        listView = (ListView)findViewById(R.id.listView);
        classes = new ArrayAdapter<>(ProfessorHome.this,android.R.layout.simple_selectable_list_item,classData);

        listView.setAdapter(classes);
    }

}
