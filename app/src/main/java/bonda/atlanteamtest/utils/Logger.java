package bonda.atlanteamtest.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import bonda.atlanteamtest.MainActivity;
import bonda.atlanteamtest.R;

/**
 * Класс для создания логов
 */
public class Logger {
    /**
     * Лог ответа сервера
     */
    private final String REQUEST_LOG = "api_logs";

    /**
     * Лог ответа сервера
     */
    public final boolean FAILURE = false;
    public final boolean RESPONSE = true;

    /**
     * Контекст
     */
    private final Context mContext = MainActivity.getContext();

    /**
     * Метод, создающий стандартный лог
     *
     * @param logMessage - сообщение в логе
     */
    public void logApplication(String logMessage) {
        // Отправка сообщения в логи
        Log.i("AtlanTeamDEBUG", "log: " + logMessage);
    }

    /**
     * Создает логи ответа сервера
     *
     * @param result     - код ответа
     * @param throwable  - ошибка
     * @param stringBody - строка тела ответа
     */
    public void logRequestServer(boolean result, @Nullable Throwable throwable, @Nullable String stringBody) {

        if (!result) {
            // Отправка сообщения в логи
            Log.i(REQUEST_LOG, mContext.getString(R.string.api_request_not_success));
            assert throwable != null;
            Log.i(REQUEST_LOG, throwable.toString());
        } else {
            Log.i(REQUEST_LOG, mContext.getString(R.string.api_request_success));
            if (stringBody == null) {
                stringBody = mContext.getString(R.string.api_request_empty_string_response_body);
            }
            Log.i(REQUEST_LOG, stringBody);
        }
    }
}
