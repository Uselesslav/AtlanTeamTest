package bonda.atlanteamtest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Сущность фото
 * Created by bonda on 13.10.2017.
 */
public class PhotoModel {
    /**
     * id альбома, которому принадлежит фото
     */
    @SerializedName("albumId")
    private int albumId;

    /**
     * id фото
     */
    @SerializedName("id")
    private int id;

    /**
     * Ссылка на изображение
     */
    @SerializedName("url")
    private String url;

    /**
     * Ссылка на уменьшенное изображение
     */
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public PhotoModel(int albumId, int id, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
