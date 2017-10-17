package bonda.atlanteamtest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bonda.atlanteamtest.InterfaceAPI;
import bonda.atlanteamtest.R;
import bonda.atlanteamtest.fragments.cards.CommentsFragment;
import bonda.atlanteamtest.fragments.cards.PhotosFragment;
import bonda.atlanteamtest.fragments.cards.PostsFragment;
import bonda.atlanteamtest.fragments.cards.ToDosFragment;
import bonda.atlanteamtest.fragments.cards.UsersFragment;
import bonda.atlanteamtest.models.AlbumModel;
import bonda.atlanteamtest.models.PhotoModel;
import bonda.atlanteamtest.models.ToDoModel;
import bonda.atlanteamtest.models.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Фрагмент списка карточек
 * Created by bonda on 13.10.2017.
 */
public class ListCardFragment extends Fragment {
    /**
     * Передаёт параметры в фрагмент из предка
     *
     * @return фрагмент
     */
    public static ListCardFragment newInstance() {

        return new ListCardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        View rootView = inflater.inflate(R.layout.fragment_list_card, container, false);

        // Заполнение контейнеров карточек соответствующими фрагментами
        getChildFragmentManager().beginTransaction().add(R.id.fl_comments, CommentsFragment.newInstance()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.fl_photos, PhotosFragment.newInstance()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.fl_users, UsersFragment.newInstance()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.fl_posts, PostsFragment.newInstance()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.fl_todos, ToDosFragment.newInstance()).commit();


        // Инициализация работы с сервером
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InterfaceAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Формирование тела запроса с параметрами для получения фото
        Call<PhotoModel> callPhoto = retrofit.create(InterfaceAPI.class).getPhoto();

        // Выполннение асинхронного запроса к API для получения поста
        callPhoto.enqueue(new Callback<PhotoModel>() {
            @Override
            public void onResponse(Call<PhotoModel> userCall, Response<PhotoModel> response) {
                // Проверка успешности запроса
                if (response != null && response.body() != null) {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_success));
                    Log.i(InterfaceAPI.REQUEST_LOG, response.body().toString());

                    // Заполнение сущности из тела запроса
                    PhotoModel callPhoto = response.body();

                } else {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                }
            }

            @Override
            public void onFailure(Call<PhotoModel> call, Throwable t) {
                Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                Log.i(InterfaceAPI.REQUEST_LOG, t.toString());
            }
        });


        // Формирование тела запроса с параметрами для получения фото
        Call<ToDoModel> callToDo = retrofit.create(InterfaceAPI.class).getToDo();

        // Выполннение асинхронного запроса к API для получения поста
        callToDo.enqueue(new Callback<ToDoModel>() {
            @Override
            public void onResponse(Call<ToDoModel> userCall, Response<ToDoModel> response) {
                // Проверка успешности запроса
                if (response != null && response.body() != null) {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_success));
                    Log.i(InterfaceAPI.REQUEST_LOG, response.body().toString());

                    // Заполнение сущности из тела запроса
                    ToDoModel callToDo = response.body();

                } else {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                }
            }

            @Override
            public void onFailure(Call<ToDoModel> call, Throwable t) {
                Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                Log.i(InterfaceAPI.REQUEST_LOG, t.toString());
            }
        });


        // Формирование тела запроса с параметрами для получения фото
        Call<UserModel> callUser = retrofit.create(InterfaceAPI.class).getUser();

        // Выполннение асинхронного запроса к API для получения поста
        callUser.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> userCall, Response<UserModel> response) {
                // Проверка успешности запроса
                if (response != null && response.body() != null) {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_success));
                    Log.i(InterfaceAPI.REQUEST_LOG, response.body().toString());

                    // Заполнение сущности из тела запроса
                    UserModel callUser = response.body();

                } else {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                Log.i(InterfaceAPI.REQUEST_LOG, t.toString());
            }
        });


        // Формирование тела запроса с параметрами для получения фото
        Call<AlbumModel> callAlbum = retrofit.create(InterfaceAPI.class).getAlbum();

        // Выполннение асинхронного запроса к API для получения поста
        callAlbum.enqueue(new Callback<AlbumModel>() {
            @Override
            public void onResponse(Call<AlbumModel> userCall, Response<AlbumModel> response) {
                // Проверка успешности запроса
                if (response != null && response.body() != null) {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_success));
                    Log.i(InterfaceAPI.REQUEST_LOG, response.body().toString());

                    // Заполнение сущности из тела запроса
                    AlbumModel callAlbum = response.body();

                } else {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                }
            }

            @Override
            public void onFailure(Call<AlbumModel> call, Throwable t) {
                Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                Log.i(InterfaceAPI.REQUEST_LOG, t.toString());
            }
        });
        return rootView;
    }
}
