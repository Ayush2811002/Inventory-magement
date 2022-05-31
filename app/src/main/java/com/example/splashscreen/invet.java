package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class invet extends AppCompatActivity {
    private EditText lope,roll,cour,dur;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invet);
        lope=findViewById(R.id.lope);
        roll=findViewById(R.id.roll);
        cour=findViewById(R.id.cour);
        dur=findViewById(R.id.dur);
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Roll=roll.getText().toString().trim();
                String name=lope.getText().toString().trim();
                String Course=cour.getText().toString().trim();
                String Duration=dur.getText().toString().trim();

                if(TextUtils.isEmpty(Roll)||TextUtils.isEmpty(name)||TextUtils.isEmpty(Course)||TextUtils.isEmpty(Duration)){

                    Toast.makeText(invet.this,"Please enter all feild ",Toast.LENGTH_SHORT).show();


                }

                else {

                    dataholder obj = new dataholder(name, Course, Duration);

                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference rec = db.getReference("Studentr");
                    rec.child(Roll).setValue(obj);

                    roll.setText("");
                    lope.setText("");
                    cour.setText("");
                    dur.setText("");


                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}