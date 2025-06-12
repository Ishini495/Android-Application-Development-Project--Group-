package com.example.eommerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    private ImageView men,women,kid;

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        men=findViewById(R.id.image2);
        women=findViewById(R.id.image1);
        kid=findViewById(R.id.image3);
        back=findViewById(R.id.backButton);

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Common1.class);
                intent.putExtra("Topic", "Men Items");
                intent.putExtra("Category1", "Formal Wear");
                intent.putExtra("Category2", "Sports Wear");
                intent.putExtra("Category3", "Shoes");
                intent.putExtra("Image1", R.drawable.menformal);
                intent.putExtra("Image2", R.drawable.mensport);
                intent.putExtra("Image3", R.drawable.shoes);
                startActivity(intent);
            }
        });

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Common1.class);
                intent.putExtra("Topic", "Women Items");
                intent.putExtra("Category1", "Casual Wear");
                intent.putExtra("Category2", "Party Wear");
                intent.putExtra("Category3", "Formal Wear");
                intent.putExtra("Image1", R.drawable.womencasual);
                intent.putExtra("Image2", R.drawable.womenparty);
                intent.putExtra("Image3", R.drawable.womenformal);
                startActivity(intent);
            }
        });

        kid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Common1.class);
                intent.putExtra("Topic", "Kids Items");
                intent.putExtra("Category1", "Bags");
                intent.putExtra("Category2", "Watches");
                intent.putExtra("Category3", "Books");
                intent.putExtra("Image1", R.drawable.bag);
                intent.putExtra("Image2", R.drawable.watch);
                intent.putExtra("Image3", R.drawable.books);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


    }
}