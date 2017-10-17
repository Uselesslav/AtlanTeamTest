package bonda.atlanteamtest.fragments.cards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import bonda.atlanteamtest.InterfaceAPI;
import bonda.atlanteamtest.R;
import bonda.atlanteamtest.models.PostModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Фрагмент карточки постов
 * Created by bonda on 17.10.2017.
 */
public class PostsFragment extends Fragment {
    /**
     * Передаёт параметры в фрагмент из предка
     *
     * @return фрагмент
     */
    public static PostsFragment newInstance() {

        return new PostsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        final View rootView = inflater.inflate(R.layout.fragment_posts, container, false);

        // Текстовые поля с заголовком и постом
        final TextView textViewTitle = rootView.findViewById(R.id.tv_title);
        final TextView textViewBody = rootView.findViewById(R.id.tv_body);

        // Инициализация работы с сервером
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InterfaceAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Инициализация массива постов
        final ArrayList<PostModel> arrayListPost = new ArrayList<>();

        // Формирование тела запроса с параметрами для получения поста
        Call<ArrayList<PostModel>> callPost = retrofit.create(InterfaceAPI.class).getPost();

        // Выполннение асинхронного запроса к API для получения поста
        callPost.enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> userCall, Response<ArrayList<PostModel>> response) {
                // Проверка успешности запроса
                if (response != null && response.body() != null) {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_success));
                    Log.i(InterfaceAPI.REQUEST_LOG, response.body().toString());

                    // Заполнение массива полученными данными
                    arrayListPost.addAll(response.body());

                    // Заполнение текстовых полей дефолтным постом
                    textViewTitle.setText(arrayListPost.get(0).getTitle());
                    textViewBody.setText(arrayListPost.get(0).getBody());
                } else {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {
                Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                Log.i(InterfaceAPI.REQUEST_LOG, t.toString());
            }
        });

        // Кнопка "ПОДТВЕРДИТЬ" и поле ввода текста
        Button buttonApply = rootView.findViewById(R.id.button_apply);
        final EditText editTextId = rootView.findViewById(R.id.et_id);

        // Информационное текстовое поле
        final TextView textViewInfo = rootView.findViewById(R.id.tv_info);

        // Обработчик нажатия на кнопку "ПОДТВЕРДИТЬ"
        buttonApply.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Проверка пусто ли поле ввода
                if (editTextId.getText().toString().isEmpty()) {
                    // Изменение видимости текстового поля
                    textViewInfo.setVisibility(View.VISIBLE);
                    textViewInfo.setText(getString(R.string.info_empty_string));
                    return;
                }
                // Получение id из поля ввода
                final int id = Integer.parseInt(editTextId.getText().toString()) - 1;

                // Проверка введенного значения
                if ((id > -1) && (id < arrayListPost.size())) {
                    // Заполнение текстовых полей выбранным постом
                    textViewTitle.setText(arrayListPost.get(id).getTitle());
                    textViewBody.setText(arrayListPost.get(id).getBody());
                    // Изменение видимости текстового поля, если оно отображалось
                    textViewInfo.setVisibility(View.GONE);
                } else {
                    // Изменение видимости текстового поля
                    textViewInfo.setVisibility(View.VISIBLE);
                    textViewInfo.setText(getString(R.string.info_text) + " " + arrayListPost.size());
                }
            }
        });

        return rootView;
    }
}
