package com.example.newslist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="NewsList";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        setTitle(getLocalClassName());

        Button btn_back =(Button)findViewById(R.id.back);
        btn_back.setOnClickListener(this);

        Log.i(TAG,"Ouverture activité"+getLocalClassName());
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.back:
                finishAffinity();
                break;
        }

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"terminaison de l'activité "+getLocalClassName());
    }
}
