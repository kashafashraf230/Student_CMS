package com.example.hafiz_lms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class Delete extends AppCompatActivity {


    EditText r;
    DbHelper db;
    Button delete;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        db = new DbHelper(Delete.this);

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                r=findViewById(R.id.Roll);
                String roll =  r.getText().toString();


                db.deleteStudent(roll);

                r.setText("");

            }
        });


    }

}