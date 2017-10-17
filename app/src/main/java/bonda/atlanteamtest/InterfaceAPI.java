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
     *
     * @return в случае удачного получения код 200 и пост
     */
    @GET("posts")
    Call<ArrayList<PostModel>> getPost();

    /**
     * Получение комментария
     *
     * @return в случае удачного получения код 200 и комментария
     */
    @GET("comments")
    Call<ArrayList<CommentModel>> getComment();

    /**
     * Получение фото
     *
     * @return в случае удачного получения код 200 и фото
     */
    @GET("photos")
    Call<ArrayList<PhotoModel>> getPhoto();

    /**
     * Получение задачи
     *
     * @return в случае удачного получения код 200 и задачи
     */
    @GET("todos")
    Call<ArrayList<ToDoModel>> getToDo();

    /**
     * Получение пользователя
     *
     * @return в случае удачного получения код 200 и пользователя
     */
    @GET("users")
    Call<ArrayList<UserModel>> getUser();

    /**
     * Получение альбома
     *
     * @return в случае удачного получения код 200 и альбом
     */
    @GET("albums")
    Call<ArrayList<AlbumModel>> getAlbum();
}
