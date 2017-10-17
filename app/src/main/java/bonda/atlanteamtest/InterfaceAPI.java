package bonda.atlanteamtest;

import java.util.ArrayList;

import bonda.atlanteamtest.models.AlbumModel;
import bonda.atlanteamtest.models.CommentModel;
import bonda.atlanteamtest.models.PhotoModel;
import bonda.atlanteamtest.models.PostModel;
import bonda.atlanteamtest.models.ToDoModel;
import bonda.atlanteamtest.models.UserModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Интерфейс для работы с REST API
 * Created by bonda on 13.10.2017.
 */
public interface InterfaceAPI {
    /**
     * Основной URL
     */
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    /**
     * Лог ответа
     */
    String REQUEST_LOG = "api_logs";

    /**
     * Получение поста
     * TODO: Вставлять вместо 1 - n
     *
     * @return в случае удачного получения код 200 и пост
     */
    @GET("posts")
    Call<ArrayList<PostModel>> getPost();

    /**
     * Получение комментария
     * TODO: Вставлять вместо 1 - n
     *
     * @return в случае удачного получения код 200 и комментария
     */
    @GET("comments/1")
    Call<CommentModel> getComment();

    /**
     * Получение фото
     * TODO: Вставлять вместо 1 - n
     *
     * @return в случае удачного получения код 200 и фото
     */
    @GET("photos/1")
    Call<PhotoModel> getPhoto();

    /**
     * Получение задачи
     * TODO: Вставлять вместо 1 - n
     *
     * @return в случае удачного получения код 200 и задачи
     */
    @GET("todos/1")
    Call<ToDoModel> getToDo();

    /**
     * Получение пользователя
     * TODO: Вставлять вместо 1 - n
     *
     * @return в случае удачного получения код 200 и пользователя
     */
    @GET("users/1")
    Call<UserModel> getUser();

    /**
     * Получение альбома
     * TODO: Вставлять вместо 1 - n
     *
     * @return в случае удачного получения код 200 и альбом
     */
    @GET("albums/1")
    Call<AlbumModel> getAlbum();
}
