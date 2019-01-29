package com.example.databindingsample.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.databindingsample.ListActivity;
import com.example.databindingsample.R;
import com.example.databindingsample.databinding.ListChildLayoutBinding;
import com.example.databindingsample.model.PersonList;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

//    private Context context;
//    private List<UserModel> users = new ArrayList<>();
    private List<PersonList> persons = new ArrayList<>();
    ListActivity activity;

    public RecyclerAdapter(ListActivity activity, List<PersonList> personList) {
        persons = personList;
        activity = this.activity;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ListChildLayoutBinding listChildLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.list_child_layout, viewGroup, false
        );
        MyViewHolder myViewHolder = new MyViewHolder(listChildLayoutBinding);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
//        UserModel userModel = users.get(i);
        PersonList userModel = persons.get(i);
        viewHolder.listChildLayoutBinding.setUser(userModel);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ListChildLayoutBinding listChildLayoutBinding;

        public MyViewHolder(@NonNull ListChildLayoutBinding itemView) {
            super(itemView.getRoot());
            listChildLayoutBinding = itemView;
        }
    }
}
