package com.cookandroid.cameratest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCamera;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera=(Button) findViewById(R.id.takePicture);
        imageView=(ImageView) findViewById(R.id.pictureView);
        btnCamera.setOnClickListener(this);
    }

    Uri photoUri;

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.takePicture:
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                File photoFile=null;
                try{
                    photoFile=createImageFile();
                }catch (IOException ex){ }

                if (photoFile != null) {
                    photoUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", photoFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                    startActivityForResult(intent, 0);
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==0&&resultCode==RESULT_OK){
            imageView.setImageURI(photoUri);
        }
    }

    private File createImageFile() throws IOException{
        String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName="JPEG_"+timeStamp+"_";
        File storageDir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File StorageDir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image=File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        return image;
    }
}