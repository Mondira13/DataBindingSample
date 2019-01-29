package com.example.databindingsample.response;

import com.example.databindingsample.model.PersonList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonListResponse {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("personList")
    @Expose
    private List<PersonList> personList = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<PersonList> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonList> personList) {
        this.personList = personList;
    }

}
