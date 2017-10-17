package bonda.atlanteamtest.fragments.cards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import bonda.atlanteamtest.InterfaceAPI;
import bonda.atlanteamtest.R;
import bonda.atlanteamtest.adapters.ArrayListUserAdapter;
import bonda.atlanteamtest.models.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Фрагмент карточки пользователей
 * Created by bonda on 17.10.2017.
 */
public class UsersFragment extends Fragment {
    /**
     * Передаёт параметры в фрагмент из предка
     *
     * @return фрагмент
     */
    public static UsersFragment newInstance() {

        return new UsersFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        View rootView = inflater.inflate(R.layout.fragment_users, container, false);

        // Получение информации о дисплее устройства
        final float scale = getResources().getDisplayMetrics().density;

        // Инициализация работы с сервером
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InterfaceAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Инициализация массива пользователей, полученных с сервера
        final ArrayList<UserModel> arrayListUsers = new ArrayList<>();

        // Инициализация массива пользователей, которых нужно отобразить
        final ArrayList<UserModel> arrayListUsersFromView = new ArrayList<>();

        // Инициализация адаптера
        final ArrayListUserAdapter arrayListUserAdapter = new ArrayListUserAdapter(getContext(), arrayListUsersFromView);

        // Инициализация списка пользователей
        final ListView listViewUsers = rootView.findViewById(R.id.lv_users);
        listViewUsers.setAdapter(arrayListUserAdapter);

        // Формирование тела запроса с параметрами для получения массива пользователей
        Call<ArrayList<UserModel>> callUser = retrofit.create(InterfaceAPI.class).getUser();

        // Выполннение асинхронного запроса к API для получения массива пользователей
        callUser.enqueue(new Callback<ArrayList<UserModel>>() {
            @Override
            public void onResponse(Call<ArrayList<UserModel>> userCall, Response<ArrayList<UserModel>> response) {
                // Проверка успешности запроса
                if (response != null && response.body() != null) {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_success));
                    Log.i(InterfaceAPI.REQUEST_LOG, response.body().toString());

                    // Заполнение массива полученными данными
                    arrayListUsers.addAll(response.body());

                    // Отчистка от старых значений
                    arrayListUsersFromView.clear();

                    // Параметры списка
                    ViewGroup.LayoutParams layoutParams = listViewUsers.getLayoutParams();
                    layoutParams.height = 0;

                    // Добавление дефолтных пользователей
                    for (int i = 0; i < 5; i++) {
                        arrayListUsersFromView.add(arrayListUsers.get(i));
                        layoutParams.height = (int) (listViewUsers.getLayoutParams().height + 256 * scale);
                    }

                    // Обновление параметров
                    listViewUsers.setLayoutParams(layoutParams);

                    // Обновление списка
                    arrayListUserAdapter.notifyDataSetChanged();
                } else {
                    Log.i(InterfaceAPI.REQUEST_LOG, getString(R.string.api_request_not_success));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserModel>> call, Throwable t) {
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
                if ((id > -1) && (id < arrayListUsers.size())) {
                    // Отчистка от старых значений
                    arrayListUsersFromView.clear();

                    // Добавление дефолтных пользователей
                    arrayListUsersFromView.add(arrayListUsers.get(id));

                    // Обновление араметров списка
                    ViewGroup.LayoutParams layoutParams = listViewUsers.getLayoutParams();
                    layoutParams.height = (int) (256 * scale);
                    listViewUsers.setLayoutParams(layoutParams);

                    // Обновление списка
                    arrayListUserAdapter.notifyDataSetChanged();

                    // Изменение видимости текстового поля, если оно отображалось
                    textViewInfo.setVisibility(View.GONE);
                } else {
                    // Изменение видимости текстового поля
                    textViewInfo.setVisibility(View.VISIBLE);
                    textViewInfo.setText(getString(R.string.info_text) + " " + arrayListUsers.size());
                }
            }
        });

        return rootView;
    }
}
