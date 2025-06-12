package com.example.eommerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;

public class MainActivity3 extends AppCompatActivity {
    private Button singInButton;
    private String gmail,password;
    EditText emailInput,passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        singInButton=findViewById(R.id.singInButton);
        emailInput=findViewById(R.id.email);
        passwordInput=findViewById(R.id.password);

        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gmail=emailInput.getText().toString();
                password=passwordInput.getText().toString();
                if (gmail.equals("Dhananja@gmail.com") && password.equals("Dhananja")){
                    Intent intent =new Intent(getApplicationContext(),MainActivity5.class);
                    startActivity(intent);
                }else{
                    Toasty.warning(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT, true).show();
                }
            }

        });





    }

}