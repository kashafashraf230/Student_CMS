package com.example.hafiz_lms;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    EditText n, a, c, r;
    DbHelper db;
    Button insert;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DbHelper(MainActivity.this);

        insert = findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=findViewById(R.id.Name);
                a=findViewById(R.id.Age);
                c=findViewById(R.id.Class);
                r=findViewById(R.id.Roll);

                String name = n.getText().toString();
                int age = Integer.parseInt( a.getText().toString());
                int clas = Integer.parseInt( c.getText().toString());
                int roll = Integer.parseInt( r.getText().toString());

                Students student = new Students(name, age, clas, roll);

                db.insertStudent(student);

                n.setText("");
                a.setText("");
                c.setText("");
                r.setText("");


            }
        });


    }

}