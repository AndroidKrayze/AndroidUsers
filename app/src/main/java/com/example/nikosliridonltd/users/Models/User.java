package com.example.nikosliridonltd.users.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import org.json.JSONObject;

import java.util.List;


public class User {

    @Expose
    private Name name;

    @Expose
    private Picture picture;

    public Picture getPicture() {
        return picture;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public class Name {

        @Expose
        private String first;

        @Expose
        private String last;

        public String getFirstName() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLastName() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }
    }

    public class Picture {

        @Expose
        private String thumbnail;

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }

    public static List<User> createUsers(String json){
        Gson gson = new Gson();
        UserPojo userPojo = gson.fromJson(json, UserPojo.class);

        return userPojo.getResults();

    }
}
