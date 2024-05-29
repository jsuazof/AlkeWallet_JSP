package model;

public class Customer {
    private int id;
    private String name;
    private String last_name;
    private String rut;
    private String email;
    private String password;

    public Customer() {
    }

    public Customer(int id, String name, String last_name, String rut, String email, String password) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.rut = rut;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", last_name=" + last_name + ", rut=" + rut + ", email="
                + email + ", password=" + password + "]";
    }
    
    
}
