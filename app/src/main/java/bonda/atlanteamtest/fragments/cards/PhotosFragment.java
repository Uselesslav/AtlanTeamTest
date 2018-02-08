package bonda.atlanteamtest.fragments.cards;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import bonda.atlanteamtest.API.InterfaceAPI;
import bonda.atlanteamtest.R;
import bonda.atlanteamtest.models.PhotoModel;
import bonda.atlanteamtest.utils.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Фрагмент карточки фотографий
 * Created by bonda on 17.10.2017.
 */
public class PhotosFragment extends Fragment {
    /**
     * Объект для логирования
     */
    private Logger mLogger = new Logger();

    /**
     * Передаёт параметры в фрагмент из предка
     *
     * @return фрагмент
     */
    public static PhotosFragment newInstance() {

        return new PhotosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);

        // Фото
        final ImageView imageViewPhoto = rootView.findViewById(R.id.iv_photo);

        // Инициализация работы с сервером
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InterfaceAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Инициализация массива постов
        final ArrayList<PhotoModel> arrayListPhoto = new ArrayList<>();

        // Формирование тела запроса с параметрами для получения массива фото
        Call<ArrayList<PhotoModel>> callPost = retrofit.create(InterfaceAPI.class).getPhoto();

        // Выполннение асинхронного запроса к API для получения массива фото
        callPost.enqueue(new Callback<ArrayList<PhotoModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PhotoModel>> userCall, Response<ArrayList<PhotoModel>> response) {
                // Проверка успешности запроса
                if (response != null && response.body() != null) {
                    // Отправка сообщений в логи
                    mLogger.logRequestServer(true, null, response.body().toString());

                    // Заполнение массива полученными данными
                    arrayListPhoto.addAll(response.body());

                    // Загрузка картинки майки и отображение
                    Glide.with(getContext()).load(arrayListPhoto.get(3).getUrl()).into(imageViewPhoto);
                } else {
                    // Отправка сообщений в логи
                    mLogger.logRequestServer(true, null, null);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<PhotoModel>> call, Throwable t) {
                // Отправка сообщений в логи
                mLogger.logRequestServer(false, t, null);
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
                if ((id > -1) && (id < arrayListPhoto.size())) {
                    // Загрузка картинки майки и отображение
                    Glide.with(getContext()).load(arrayListPhoto.get(id).getUrl()).into(imageViewPhoto);

                    // Изменение видимости текстового поля, если оно отображалось
                    textViewInfo.setVisibility(View.GONE);
                } else {
                    // Изменение видимости текстового поля
                    textViewInfo.setVisibility(View.VISIBLE);
                    textViewInfo.setText(getString(R.string.info_text) + " " + arrayListPhoto.size());
                }
            }
        });

        return rootView;
    }
}
