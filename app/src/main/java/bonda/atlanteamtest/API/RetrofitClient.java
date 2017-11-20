package bonda.atlanteamtest.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static bonda.atlanteamtest.API.InterfaceAPI.BASE_URL;

/**
 * Класс, работающий с клиентом Retrofit
 */
public class RetrofitClient {

    /**
     * Создание retrofit
     *
     * @return - клиент retrofit
     */
    public static Retrofit getRetrofitClient() {
        return new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
