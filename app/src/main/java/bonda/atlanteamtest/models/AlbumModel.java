package bonda.atlanteamtest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Сущность альбома фотографий
 * Created by bonda on 15.10.2017.
 */

public class AlbumModel {
    /**
     * id пользователя, которому принадлежит этот альбом
     */
    @SerializedName("userId")
    private int userId;

    /**
     * id
     */
    @SerializedName("id")
    private int id;

    /**
     * Заголовок
     */
    @SerializedName("title")
    private String title;

    public AlbumModel(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
