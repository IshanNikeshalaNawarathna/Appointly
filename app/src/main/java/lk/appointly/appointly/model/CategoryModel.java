package lk.appointly.appointly.model;

public class CategoryModel {

    private int Id;
    private String Name;
    private String Picture;

    public CategoryModel(int id, String name, String picture) {
        Id = id;
        Name = name;
        Picture = picture;
    }

    public CategoryModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }
}
