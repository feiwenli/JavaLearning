package com.hand;

public class User extends IdEntity{
    private String name;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usr [name="+name+",password="+password+",email="+email+",id="+id+"]";
    }
}
