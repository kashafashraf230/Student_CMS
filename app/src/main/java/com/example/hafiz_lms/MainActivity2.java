package com.example.hafiz_lms;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity implements myRecyclerViewAdapter.OnItemClickListener{

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    DbHelper db;
    RecyclerView.LayoutManager layoutManager;
    Button i, u, d;
    public void onButtonClick(int position, int roll) {
        // Handle the button click event here
        // Start the new activity, perform some action, etc.
        Intent intent = new Intent(MainActivity2.this, Details_Page.class);
        intent.putExtra("position", position);
        intent.putExtra("roll", roll);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Students> studentsList = new ArrayList<>();
        setContentView(R.layout.activity_main2);
        db = new DbHelper(MainActivity2.this);
        i=findViewById(R.id.insert);
        u = findViewById(R.id.update);
        d = findViewById(R.id.delete);

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, update.class);
                startActivity(intent);
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, Delete.class);
                startActivity(intent);
            }
        });

        studentsList.addAll(db.selectAllStudents());
        recyclerView = findViewById(R.id.RecView);


        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(MainActivity2.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(studentsList, MainActivity2.this) ;
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Students> studentsList = new ArrayList<>();
        db = new DbHelper(MainActivity2.this);
        studentsList.addAll(db.selectAllStudents());
        recyclerView = findViewById(R.id.RecView);


        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(MainActivity2.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(studentsList, MainActivity2.this) ;
        recyclerView.setAdapter(adapter);
    }

    public void ButtonClicked(int pos) {
        Intent intent = new Intent(MainActivity2.this, Details_Page.class);
        intent.putExtra("position", pos);

    }

}