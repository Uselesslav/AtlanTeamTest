package bonda.atlanteamtest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Сущность комментария
 * Created by bonda on 13.10.2017.
 */
public class CommentModel {
    /**
     * id поста, к которому принадлежит этот комментарий
     */
    @SerializedName("postId")
    private int postId;

    /**
     * id
     */
    @SerializedName("id")
    private int id;

    /**
     * Имя комментатора
     */
    @SerializedName("name")
    private String name;

    /**
     * Почта комментатора
     */
    @SerializedName("email")
    private String email;

    /**
     * Тело комментария
     */
    @SerializedName("body")
    private String body;

    public CommentModel(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
