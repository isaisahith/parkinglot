package models;

public class Operator{
    private int id;
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
}