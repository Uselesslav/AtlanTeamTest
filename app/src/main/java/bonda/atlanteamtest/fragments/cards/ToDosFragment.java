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
import java.util.Random;

import bonda.atlanteamtest.API.InterfaceAPI;
import bonda.atlanteamtest.R;
import bonda.atlanteamtest.models.ToDoModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Фрагмент карточки задач
 * Created by bonda on 17.10.2017.
 */
public class ToDosFragment extends Fragment {
    /**
     * Передаёт параметры в фрагмент из предка
     *
     * @return фрагмент
     */
    public static ToDosFragment newInstance() {

        return new ToDosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        View rootView = inflater.inflate(R.layout.fragment_todos, container, false);

        // Текстовые поля с заголовком и статусом
        final TextView textViewTitle = rootView.findViewById(R.id.tv_title);
        final TextView textViewState = rootView.findViewById(R.id.tv_state);

        // Инициализация работы с сервером
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InterfaceAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Инициализация массива задач
        final ArrayList<ToDoModel> arrayListToDo = new ArrayList<>();

        // Формирование тела запроса с параметрами для получения массива задач
        Call<ArrayList<ToDoModel>> callToDo = retrofit.create(InterfaceAPI.class).getToDo();

        // Выполннение асинхронного запроса к API для получения массива задач
        callToDo.enqueue(new Callback<ArrayList<ToDoModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ToDoModel>> userCall, Response<ArrayList<ToDoModel>> response) {
                // Проверка успешности запроса
                if (response != null && response.body() != null) {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_success));
                    Log.i(InterfaceAPI.REQUEST_LOG, response.body().toString());

                    // Заполнение массива полученными данными
                    arrayListToDo.addAll(response.body());

                    // Получение случайного идентификатора
                    int id = new Random().nextInt(arrayListToDo.size() - 1) + 1;

                    // Заполнение текстовых полей
                    textViewTitle.setText(arrayListToDo.get(id).getTitle());
                    if (arrayListToDo.get(id).getCompleted()) {
                        textViewState.setText(getString(R.string.completed));
                        textViewState.setTextColor(getResources().getColor(R.color.green));
                    } else {
                        textViewState.setText(getString(R.string.uncompleted));
                        textViewState.setTextColor(getResources().getColor(R.color.red));
                    }
                } else {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ToDoModel>> call, Throwable t) {
                Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                Log.i(InterfaceAPI.REQUEST_LOG, t.toString());
            }
        });

        // Кнопка "ПОДТВЕРДИТЬ" и поле ввода текста
        Button buttonApply = rootView.findViewById(R.id.button_apply);
        final EditText editTextId = rootView.findViewById(R.id.et_id);

        // Информационное текстовое поле
        final TextView textViewInfo = rootView.findViewById(R.id.tv_info);

        // Обработчик нажатия на кнопку "подтвердить"
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
                if ((id > -1) && (id < arrayListToDo.size())) {
                    // Заполнение текстовых полей
                    textViewTitle.setText(arrayListToDo.get(id).getTitle());
                    if (arrayListToDo.get(id).getCompleted()) {
                        textViewState.setText(getString(R.string.completed));
                        textViewState.setTextColor(getResources().getColor(R.color.green));
                    } else {
                        textViewState.setText(getString(R.string.uncompleted));
                        textViewState.setTextColor(getResources().getColor(R.color.red));
                    }
                    // Изменение видимости текстового поля, если оно отображалось
                    textViewInfo.setVisibility(View.GONE);
                } else {
                    // Изменение видимости текстового поля
                    textViewInfo.setVisibility(View.VISIBLE);
                    textViewInfo.setText(getString(R.string.info_text) + " " + arrayListToDo.size());
                }
            }
        });

        return rootView;
    }
}
