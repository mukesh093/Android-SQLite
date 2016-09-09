package com.bridgelabz.android_sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    Button sqlite,spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqlite=(Button)findViewById(R.id.sqliteDemo);
        spinner=(Button)findViewById(R.id.sqliteSpinner);

        sqlite.setOnClickListener(this);
        spinner.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sqliteDemo:
                Intent intent=new Intent(MainActivity.this,SQLiteDemo.class);
                startActivity(intent);
                break;

            case R.id.sqliteSpinner:
                intent=new Intent(MainActivity.this,SQLiteSpinner.class);
                startActivity(intent);
                break;
        }
    }
}

