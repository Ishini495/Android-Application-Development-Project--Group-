package com.example.eommerce;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddProduct extends AppCompatActivity {

    private static final int IMAGE_REQUEST_CODE = 100;
    private ImageView imageSelect;
    private EditText productNameInput, productPriceInput,productCatogaryInput,productTypeInput;
    private Button buttonSaveProduct,imageAdd;
    private Uri selectedImageUri;
    private String imageUrl;
    private FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        // Initialize the imageSelect ImageView
        imageSelect = findViewById(R.id.imageSelect);
        productNameInput = findViewById(R.id.t6);
        productCatogaryInput = findViewById(R.id.t7);
        productPriceInput = findViewById(R.id.t8);
        productTypeInput = findViewById(R.id.t9);
        buttonSaveProduct = findViewById(R.id.productSave);
        imageAdd = findViewById(R.id.imageAdd);


        imageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectImageIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(selectImageIntent, IMAGE_REQUEST_CODE);
            }
        });

        buttonSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedImageUri != null) {
                    uploadImageToFirebase(selectedImageUri);
                } else {
                    Toast.makeText(AddProduct.this, "Please select an image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();

            if (selectedImageUri != null) {
                imageSelect.setImageURI(selectedImageUri);
            }
        }
    }

    private void uploadImageToFirebase(Uri imageUri) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference imageRef = storageRef.child("images/" + imageUri.getLastPathSegment());

        imageRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                imageUrl = uri.toString();
                                saveProductToDatabase(imageUrl);
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddProduct.this, "Upload failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        System.out.println(e.getMessage());
                        Log.e("Upload Error", "Error: " + e.getMessage());
                    }
                });
    }
    private void saveProductToDatabase(String imageUrl) {
        String name = productNameInput.getText().toString();
        String category = productCatogaryInput.getText().toString();
        String type=productTypeInput.getText().toString();
        double price = Double.parseDouble(productPriceInput.getText().toString().trim());


        Product product = new Product(name,category,type,price,imageUrl);
        firestore= FirebaseFirestore.getInstance();
        firestore.collection("products").add(product);
        Intent i =new Intent(getApplicationContext(),MainActivity5.class);
        startActivity(i);




    }


}