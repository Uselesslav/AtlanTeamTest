package bonda.atlanteamtest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Сущность адреса
 * Created by bonda on 15.10.2017.
 */
public class AddressModel {
    /**
     * Улица
     */
    @SerializedName("street")
    private String street;

    /**
     * Апартаменты
     */
    @SerializedName("suite")
    private String suite;

    /**
     * Город
     */
    @SerializedName("city")
    private String city;

    /**
     * Почтовый индекс
     */
    @SerializedName("zipcode")
    private double zipcode;

    /**
     * Геолокация
     */
    @SerializedName("geo")
    private GeoModel geo;

    public AddressModel(String street, String suite, String city, String zipcode, GeoModel geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = Double.parseDouble(zipcode);
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getZipcode() {
        return zipcode;
    }

    public void setZipcode(double zipcode) {
        this.zipcode = zipcode;
    }

    public GeoModel getGeo() {
        return geo;
    }

    public void setGeo(GeoModel geo) {
        this.geo = geo;
    }
}
