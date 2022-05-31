package com.example.splashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    private EditText user;
    private EditText pass;
    private Button lbutton;
    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user=findViewById(R.id.lope);
        pass=findViewById(R.id.pass);
        lbutton=findViewById(R.id.lbutton);
        Auth=FirebaseAuth.getInstance();
        lbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=user.getText().toString();
                String password=pass.getText().toString();
                if(TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
                    Toast.makeText(Home.this,"Enter user name and Password ",Toast.LENGTH_SHORT).show();
                }
                else{
                    login(username,password);

                }
            }
        });
    }
    private void login(String user,String pass){
        Auth.signInWithEmailAndPassword(user,pass).addOnSuccessListener(Home.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(Home.this,"Login successfully ",Toast.LENGTH_SHORT).show();
                Intent inte=new Intent(Home.this,Second_Activity.class);
                startActivity(inte);
                finish();


            }
        });
        Auth.signInWithEmailAndPassword(user,pass).addOnFailureListener(Home.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Home.this,"Incorect password or username ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}