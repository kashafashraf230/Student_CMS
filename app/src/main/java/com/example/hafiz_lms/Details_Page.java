package com.example.hafiz_lms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details_Page extends AppCompatActivity {
    TextView r, ayat, sabqi, manzil, sura;
    DbHelper db;
    Details student;

    Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        Intent intent = getIntent();
        int rollno = intent.getIntExtra("roll", 0);
        db = new DbHelper(Details_Page.this);
        student = db.getDetails(rollno);

        r= findViewById(R.id.Roll);
        r.setText("Roll No: "+ rollno);

        sabqi= findViewById(R.id.Sabqi);
        sabqi.setText("Sabqi: "+ student.getSabqi());

        ayat= findViewById(R.id.Ayat);
        ayat.setText("Ayaat: "+ student.getAyatStart()+ " - "+ student.getAyatEnd());

        manzil= findViewById(R.id.Manzil);
        manzil.setText("Manzil: "+ student.getManzil());

        sura = findViewById(R.id.surah);
        sura.setText("Surah: "+ student.getSurah());

        edit = findViewById(R.id.editbutton);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Details_Page.this, Edit_Details.class);
                intent.putExtra("roll", rollno);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        int rollno = intent.getIntExtra("roll", 0);
        db = new DbHelper(Details_Page.this);
        student = db.getDetails(rollno);

        r= findViewById(R.id.Roll);
        r.setText("Roll No: "+ rollno);

        sabqi= findViewById(R.id.Sabqi);
        sabqi.setText("Sabqi: "+ student.getSabqi());

        ayat= findViewById(R.id.Ayat);
        ayat.setText("Ayaat: "+ student.getAyatStart()+ " - "+ student.getAyatEnd());

        manzil= findViewById(R.id.Manzil);
        manzil.setText("Manzil: "+ student.getManzil());

        sura = findViewById(R.id.surah);
        sura.setText("Surah: "+ student.getSurah());

        edit = findViewById(R.id.editbutton);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Details_Page.this, Edit_Details.class);
                intent.putExtra("roll", rollno);
                startActivity(intent);
            }
        });

    }
}