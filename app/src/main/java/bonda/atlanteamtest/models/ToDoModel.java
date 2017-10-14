package bonda.atlanteamtest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Сущность задачи
 * Created by bonda on 13.10.2017.
 */

public class ToDoModel {
    /**
     * id пользователя, которому принадлежит задача
     */
    @SerializedName("userId")
    private int userId;

    /**
     * id задачи
     */
    @SerializedName("id")
    private int id;

    /**
     * Заголовок поста
     */
    @SerializedName("title")
    private String title;

    /**
     * Индикатор выполнения задачи
     */
    @SerializedName("completed")
    private Boolean completed;

    public ToDoModel(int userId, int id, String title, Boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
