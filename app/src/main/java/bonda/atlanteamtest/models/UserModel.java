package bonda.atlanteamtest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Сущность пользователя
 * Created by bonda on 13.10.2017.
 */

public class UserModel {
    /**
     * id пользователя
     */
    @SerializedName("id")
    private int id;

    /**
     * Имя пользователя
     */
    @SerializedName("name")
    private String name;

    /**
     * Логин
     */
    @SerializedName("username")
    private String userName;

    /**
     * email
     */
    @SerializedName("email")
    private String email;

    /**
     * Адрес
     */
    @SerializedName("address")
    private AddressModel address;

    public UserModel(int id, String name, String userName, String email, AddressModel address) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.address = address;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
