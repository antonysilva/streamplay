package br.com.streamplaydata.Category.categoryarticlehome;

import com.google.gson.annotations.SerializedName;

public class CategoryArticleHome {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("code")
    public String code;

    public CategoryArticleHome() {
    }

    public CategoryArticleHome(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

}
