package com.example.databindingsample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.databindingsample.databinding.ActivityMainBinding;
import com.example.databindingsample.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
        ActivitySecondBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_second);
        String first = getIntent().getStringExtra("firstName");
        String last = getIntent().getStringExtra("lastName");
        person = new Person();
        person.setFirstName(first);
        person.setLastName(last);
        activityMainBinding.setPerson(person);
    }
}
