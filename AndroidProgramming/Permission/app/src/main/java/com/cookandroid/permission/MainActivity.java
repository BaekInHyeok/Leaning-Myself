package com.cookandroid.permission;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //권한ID 가져오기
        int permission= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permission2= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        //권한이 열려있는지 확인하기
        if(permission== PackageManager.PERMISSION_DENIED || permission2==PackageManager.PERMISSION_DENIED){
            //마쉬멜로우 이상 버전부터는 권한을 얻기 위한 질문이 필요하다
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},1000);
            }
            return;
        }
    }

    //권한 체크 이후
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //READ_PHONE_STATE의 권한 체크 결과를 불러오기
        if(requestCode==1000){
            boolean check_result=true;

            //모든 퍼미션을 허용했는지 체크
            for (int result:grantResults){
                if(result!=PackageManager.PERMISSION_GRANTED){
                    check_result=false;
                    break;
                }
            }

            //권한 체크에 동의하지 않았으면 종료
            if(check_result==true){

            }
            else{
                finish();;
            }
        }
    }
}