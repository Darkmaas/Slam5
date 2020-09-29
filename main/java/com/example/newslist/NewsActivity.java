package com.example.newslist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG="NewsList";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        setTitle(getLocalClassName());
        Log.i(TAG,"Ouverture activité"+getLocalClassName());

        Button btn_logout =(Button)findViewById(R.id.logout);
        btn_logout.setOnClickListener(this);

        Button btn_back =(Button)findViewById(R.id.back);
        btn_back.setOnClickListener(this);

        Button btn_details =(Button)findViewById(R.id.details);
        btn_details.setOnClickListener(this);

        Button btn_about =(Button)findViewById(R.id.about);
        btn_about.setOnClickListener(this);

        Intent intent= getIntent();
        EditText editText = findViewById(R.id.log_recup);

    }
    @Override
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.logout:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                finishAffinity();
                break;
            case R.id.details:
                intent = new Intent(this, DetailsActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                String url ="https://perso.univ-rennes1.fr/pierre.nerzic/Android";
                intent =new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"terminaison de l'activité "+getLocalClassName());
    }
}
