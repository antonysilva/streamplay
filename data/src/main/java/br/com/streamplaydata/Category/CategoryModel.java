package br.com.streamplaydata.Category;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CategoryModel implements Serializable {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("code")
    public String code;

    public CategoryModel() {
    }

    public CategoryModel(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

}
