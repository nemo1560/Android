package com.example.nemo1.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class listContact {
    @SerializedName("contactList")
    private List<contacts>contactsList;

    public listContact() {
    }

    public listContact(List<contacts> contactsList) {
        this.contactsList = contactsList;
    }

    public List<contacts> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<contacts> contactsList) {
        this.contactsList = contactsList;
    }
}
