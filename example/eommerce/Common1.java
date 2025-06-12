package com.example.eommerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Common1 extends AppCompatActivity {
    ImageView commonImage1,commonImage2,commonImage3;
    TextView commonTopic,commonText1,commonText2,commonText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common1);

        commonImage1=findViewById(R.id.commonImage1);
        commonImage2=findViewById(R.id.commonImage2);
        commonImage3=findViewById(R.id.commonImage3);

        commonTopic=findViewById(R.id.commonTopic);
        commonText1=findViewById(R.id.commonText1);
        commonText2=findViewById(R.id.commonText2);
        commonText3=findViewById(R.id.commonText3);

        Intent catchIntent=getIntent();
        String topic=catchIntent.getStringExtra("Topic");
        String category1=catchIntent.getStringExtra("Category1");
        String category2=catchIntent.getStringExtra("Category2");
        String category3=catchIntent.getStringExtra("Category3");


        int image1 = catchIntent.getIntExtra("Image1",R.drawable.defaultimg);
        int image2 = catchIntent.getIntExtra("Image2",R.drawable.defaultimg);
        int image3 = catchIntent.getIntExtra("Image3",R.drawable.defaultimg);


        commonTopic.setText(topic);
        commonText1.setText(category1);
        commonText2.setText(category2);
        commonText3.setText(category3);

        commonImage1.setImageResource(image1);
        commonImage2.setImageResource(image2);
        commonImage3.setImageResource(image3);



        commonText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Common2.class);
                intent.putExtra("MainCategory", topic);
                intent.putExtra("SubCategory", category1);
                startActivity(intent);
            }
        });

        commonText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Common2.class);
                intent.putExtra("MainCategory", topic);
                intent.putExtra("SubCategory", category2);
                startActivity(intent);
            }
        });
        commonText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Common2.class);
                intent.putExtra("MainCategory", topic);
                intent.putExtra("SubCategory", category3);
                startActivity(intent);
            }
        });



    }
}