package br.com.fiap.globalsolution.infra.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

    public static Date convertToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean isValidDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static Date getMinDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Zerando as horas, minutos, segundos e milissegundos
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
	
}
