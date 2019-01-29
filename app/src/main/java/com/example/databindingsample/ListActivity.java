package com.example.databindingsample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.databindingsample.adapter.RecyclerAdapter;
import com.example.databindingsample.databinding.ActivityListBinding;
import com.example.databindingsample.model.PersonList;
import com.example.databindingsample.response.PersonListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {

    private ActivityListBinding activityListBinding;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityListBinding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        activityListBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
        activityListBinding.recycler.setHasFixedSize(true);
        loadPersonList();

        //        recyclerAdapter = new RecyclerAdapter(this,listData());
//        activityListBinding.recycler.setAdapter(recyclerAdapter);
    }

//    private List<UserModel> listData() {
//        List<String> names = Arrays.asList(getResources().getStringArray(R.array.name_list));
//        List<String> phones = Arrays.asList(getResources().getStringArray(R.array.phone_list));
//        int[] images = {R.drawable.car, R.drawable.car2, R.drawable.car3,
//                R.drawable.car4, R.drawable.car5, R.drawable.car6};
//        List<UserModel> Names = new ArrayList<>();
//        int counter = 0;
//        for (String name : names) {
//            Names.add(new UserModel(name, phones.get(counter), images[counter]));
//            counter++;
//        }
//        return Names;
//    }


    private void loadPersonList() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Service.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Service service = retrofit.create(Service.class);
        Call<PersonListResponse> call = service.getPersonList("https://api.myjson.com/bins/ct4w0");
        call.enqueue(new Callback<PersonListResponse>() {
            @Override
            public void onResponse(Call<PersonListResponse> call, Response<PersonListResponse> response) {
                addAdapter(response.body().getPersonList());
            }

            @Override
            public void onFailure(Call<PersonListResponse> call, Throwable t) {
                Toast.makeText(ListActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addAdapter(List<PersonList> personList) {
        recyclerAdapter = new RecyclerAdapter(this,personList);
        activityListBinding.recycler.setAdapter(recyclerAdapter);
    }


}
//   https://api.myjson.com/bins/ct4w0
