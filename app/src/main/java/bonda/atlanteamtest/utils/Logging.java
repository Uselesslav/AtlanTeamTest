package bonda.atlanteamtest.utils;

import android.util.Log;

/**
 * Класс для создания логов
 */
public class Logging {

    /**
     * Метод, создающий стандартный лог
     *
     * @param logMessage - сообщение в логе
     */
    public static void log(String logMessage) {
        // Отправка сообщения в логи
        Log.i("AtlanTeamDEBUG", "log: " + logMessage);
    }
}
