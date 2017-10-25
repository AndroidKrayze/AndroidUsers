package com.example.nikosliridonltd.users.Models;

import com.google.gson.annotations.Expose;

import java.util.List;


public class UserPojo {

    @Expose
    private List<User> results;

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }
}
