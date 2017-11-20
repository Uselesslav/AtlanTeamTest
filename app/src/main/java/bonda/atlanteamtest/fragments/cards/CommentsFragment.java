package bonda.atlanteamtest.fragments.cards;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import bonda.atlanteamtest.API.InterfaceAPI;
import bonda.atlanteamtest.R;
import bonda.atlanteamtest.models.CommentModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Фрагмент карточки комментариев
 * Created by bonda on 17.10.2017.
 */
public class CommentsFragment extends Fragment {
    /**
     * Передаёт параметры в фрагмент из предка
     *
     * @return фрагмент
     */
    public static CommentsFragment newInstance() {

        return new CommentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        View rootView = inflater.inflate(R.layout.fragment_comments, container, false);

        // Текстовые поля с именем, почтой и комментарием
        final TextView textViewCommentator = rootView.findViewById(R.id.tv_commentator);
        final TextView textViewMailCommentator = rootView.findViewById(R.id.tv_mail_commentator);
        final TextView textViewComment = rootView.findViewById(R.id.tv_comment);

        // Инициализация работы с сервером
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InterfaceAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Инициализация массива комментариев
        final ArrayList<CommentModel> arrayListComment = new ArrayList<>();

        // Формирование тела запроса с параметрами для получения массива комментариев
        Call<ArrayList<CommentModel>> callComment = retrofit.create(InterfaceAPI.class).getComment();

        // Выполннение асинхронного запроса к API для получения массива комментариев
        callComment.enqueue(new Callback<ArrayList<CommentModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CommentModel>> userCall, Response<ArrayList<CommentModel>> response) {
                // Проверка успешности запроса
                if (response != null && response.body() != null) {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_success));
                    Log.i(InterfaceAPI.REQUEST_LOG, response.body().toString());

                    // Заполнение массива полученными данными
                    arrayListComment.addAll(response.body());

                    // Заполнение текстовых полей дефолтным комментарием
                    textViewCommentator.setText(arrayListComment.get(0).getName());
                    textViewMailCommentator.setText(arrayListComment.get(0).getEmail());
                    textViewComment.setText(arrayListComment.get(0).getBody());
                } else {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CommentModel>> call, Throwable t) {
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
            @SuppressLint("SetTextI18n")
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
                if ((id > -1) && (id < arrayListComment.size())) {
                    // Заполнение текстовых полей
                    textViewCommentator.setText(arrayListComment.get(id).getName());
                    textViewMailCommentator.setText(arrayListComment.get(id).getEmail());
                    textViewComment.setText(arrayListComment.get(id).getBody());
                    // Изменение видимости текстового поля, если оно отображалось
                    textViewInfo.setVisibility(View.GONE);
                } else {
                    // Изменение видимости текстового поля
                    textViewInfo.setVisibility(View.VISIBLE);
                    textViewInfo.setText(getString(R.string.info_text) + " " + arrayListComment.size());
                }
            }
        });

        return rootView;
    }
}
