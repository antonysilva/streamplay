package br.com.streamplaydomain.Category;

public class CategoryEntity {

    public int id;
    public String name;
    public String code;

    public CategoryEntity() {
    }

    public CategoryEntity(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}