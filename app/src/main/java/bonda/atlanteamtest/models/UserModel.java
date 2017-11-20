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

    /**
     * Сущность геолокации
     * Created by bonda on 15.10.2017.
     */
    public static class GeoModel {
        /**
         * Широта
         */
        @SerializedName("lat")
        private double lat;

        /**
         * Долгота
         */
        @SerializedName("lng")
        private double lng;

        public GeoModel(String lat, String lng) {
            // Строка, полученная из JSON'а парстися в double
            this.lat = Double.parseDouble(lat);
            this.lng = Double.parseDouble(lng);
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }

    /**
     * Сущность адреса
     * Created by bonda on 15.10.2017.
     */
    public static class AddressModel {
        /**
         * Улица
         */
        @SerializedName("street")
        private String street;

        /**
         * Дом
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
        private String zipcode;

        /**
         * Геолокация
         */
        @SerializedName("geo")
        private GeoModel geo;

        public AddressModel(String street, String suite, String city, String zipcode, GeoModel geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
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

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public GeoModel getGeo() {
            return geo;
        }

        public void setGeo(GeoModel geo) {
            this.geo = geo;
        }
    }
}
