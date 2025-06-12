package com.example.eommerce;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Common2 extends AppCompatActivity {

    TextView topic;

    ListView list;

    private static final String TAG = "MainActivity";
    private FirebaseFirestore firestore;
    private ArrayList<Product> products;

    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common2);

        topic=findViewById(R.id.commonTopicnew);
        list=findViewById(R.id.list);


    }
    protected void onStart() {
        super.onStart();
        list = findViewById(R.id.list);
        products = new ArrayList<>();
        firestore = FirebaseFirestore.getInstance();
        adapter = new ProductAdapter(this, products);
        list.setAdapter(adapter);
        fetchNotesFromFirestore();
    }


    private void fetchNotesFromFirestore() {
        Intent catchIntent=getIntent();
        String MainCategory=catchIntent.getStringExtra("MainCategory");
        String SubCategory=catchIntent.getStringExtra("SubCategory");
        topic.setText(SubCategory);
        firestore.collection("products").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            products.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product p = document.toObject(Product.class);
                                if(p.getCategory1().equals(MainCategory) && p.getType().equals(SubCategory)){
                                    products.add(p);}
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}