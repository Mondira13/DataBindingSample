package com.example.databindingsample;

import android.content.Context;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databindingsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    String firstName;
    String lastName;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setActivity(MainActivity.this);

    }
    public void buttonClickShowToast(View view){
        Toast.makeText(view.getContext(),"Mondira pal",Toast.LENGTH_SHORT).show();
    }

    public void buttonClickGotoNext(View view){
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }

    public void submitButtonClickGotoNext(View view){
        firstName = activityMainBinding.editText.getText().toString();
        lastName = activityMainBinding.editText2.getText().toString();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("firstName",firstName);
        intent.putExtra("lastName",lastName);
        startActivity(intent);
    }

    public void buttonClickGotoList(View view){
        startActivity(new Intent(MainActivity.this,ListActivity.class));
    }


}
