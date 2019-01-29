package com.example.databindingsample;



import com.example.databindingsample.response.PersonListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Service {
    String BASE_URL = "https://api.myjson.com";

    @GET
    Call<PersonListResponse> getPersonList(@Url String url);
}
