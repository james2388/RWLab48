package com.example.admin.rwlab48;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mBtnGallery = (Button)findViewById(R.id.btnGallery);
        mBtnGallery.setOnClickListener(this);

        Button mBtnWebBrowser = (Button)findViewById(R.id.btnWebBrowser);
        mBtnWebBrowser.setOnClickListener(this);

        Button mBtnMap = (Button)findViewById(R.id.btnMap);
        mBtnMap.setOnClickListener(this);

        Button mBtnGalleryImage = (Button)findViewById(R.id.btnGalleryImage);
        mBtnGalleryImage.setOnClickListener(this);

        Button mBtnPhoto = (Button)findViewById(R.id.btnCameraPhoto);
        mBtnPhoto.setOnClickListener(this);

        Button mBtnVideo = (Button)findViewById(R.id.btnCameraVideo);
        mBtnVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGallery:
                break;
            case R.id.btnWebBrowser:
                break;
            case R.id.btnMap:
                break;
            case R.id.btnGalleryImage:
                break;
            case R.id.btnCameraPhoto:
                break;
            case R.id.btnCameraVideo:
                break;
            case R.id.btnDictophone:
                break;
            default:
                break;
        }
    }
}
