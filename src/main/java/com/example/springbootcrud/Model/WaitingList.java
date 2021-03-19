package com.example.springbootcrud.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WaitingList {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String child_name;
    private String parent_name;
    private String contact_number;
    private String email;

    public WaitingList() {
    }

    public WaitingList(int id, String child_name, String parent_name, String contact_number, String email) {
        this.id = id;
        this.child_name = child_name;
        this.parent_name = parent_name;
        this.contact_number = contact_number;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
