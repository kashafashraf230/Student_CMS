package com.example.hafiz_lms;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_Details extends AppCompatActivity {
    EditText as, ae, s, sb, mn;
    Button btn;
    Details d;
    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        as=findViewById(R.id.AyatS);
        ae = findViewById(R.id.AyatE);
        s = findViewById(R.id.Surah);
        sb = findViewById(R.id.Sabqi);
        mn = findViewById(R.id.Manzil);
        btn = findViewById(R.id.editbutton1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ayats = Integer.parseInt(as.getText().toString());
                int ayate = Integer.parseInt(ae.getText().toString());
                int sbqi = Integer.parseInt(sb.getText().toString());
                int mnzil = Integer.parseInt(mn.getText().toString());
                String surah = s.getText().toString();
                Intent intent = getIntent();
                int rollno = intent.getIntExtra("roll", 0);
                d = new Details(rollno, surah, sbqi, mnzil, ayats, ayate);

                db = new DbHelper(Edit_Details.this);
                db.editDetails(d);

                Intent intent2 = new Intent(Edit_Details.this, Details_Page.class);
                intent2.putExtra("roll", rollno);
                startActivity(intent2);
            }
        });


    }
}