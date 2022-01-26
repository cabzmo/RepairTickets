package model;

public class Tenant extends Person {

    public Tenant(int id, String name, String phone, String email) {
        super(id, name, phone, email, "Tenant");
    }
}
