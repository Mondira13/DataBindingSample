package com.example.databindingsample;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserModel {
    public String name,phone;
    public int image;

    public UserModel(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        this.image = image;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(View view,int image){
        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(),image));
    }
}
