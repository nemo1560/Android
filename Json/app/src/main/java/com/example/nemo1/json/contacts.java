package com.example.nemo1.json;

import com.google.gson.annotations.SerializedName;

public class contacts {
    private int id;
    @SerializedName("name") /*
    có thể thêm @SerializedName (entity_name). Sau đó, chúng ta gọi API của thư viện gson để thực sự truy xuất dữ liệu từ tệp json
    */
    private String name;
    private String email;
    private String address;
    private String gender;
    private phone phone;

    public contacts(int id, String name, String email, String address, String gender, com.example.nemo1.json.phone phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public com.example.nemo1.json.phone getPhone() {
        return phone;
    }

    public void setPhone(com.example.nemo1.json.phone phone) {
        this.phone = phone;
    }
}
