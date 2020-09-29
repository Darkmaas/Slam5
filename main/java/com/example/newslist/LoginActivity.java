package com.example.newslist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle(getLocalClassName());
        Log.i(TAG,"Ouverture activité"+getLocalClassName());

        Button btn_login =(Button)findViewById(R.id.login);
        btn_login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.login:
                intent = new Intent(this, NewsActivity.class);
                EditText editText= findViewById(R.id.log);
                intent.putExtra("login", editText.getText().toString());
                startActivity(intent);
                break;

        }
    }
    private static final String TAG="NewsList";
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"terminaison de l'activité "+getLocalClassName());
    }
}
