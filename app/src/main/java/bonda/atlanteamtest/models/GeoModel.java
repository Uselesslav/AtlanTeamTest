package bonda.atlanteamtest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Сущность геолокации
 * Created by bonda on 15.10.2017.
 */
public class GeoModel {
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
        // TODO: добавить проверку полученной строки
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
