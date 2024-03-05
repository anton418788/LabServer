package server_lab.validator.primitive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class ValidateDate {
    public boolean validateStringDate(String date, List<String> errors, String fieldName, String errorMessage) {
        if (!checkDateFormat(date) || !checkYearValue(date) || !checkMonthValue(date) || !checkDayValue(date)) {
            errors.add(fieldName + ": " + errorMessage);
            return false;
        }
        return true;
    }
    public boolean validateDateNotExceed(String date1, String date2, List<String> errors, String fieldName, String errorMessage) throws ParseException {


           Date Date1 = new SimpleDateFormat("d/MM/yyyy").parse(date1);
           Date Date2 = new SimpleDateFormat("d/MM/yyyy").parse(date2);

           if (Date1.before(Date2)) {
               errors.add(fieldName + ": " + errorMessage);
               return false;
           }
        return true;
    }

    public static void validateDate(String date) {
        checkDateFormat(date);
        checkYearValue(date);
        checkMonthValue(date);
        checkDayValue(date);
    }

    private static boolean checkDateFormat(String date) {
        if (!(date.length() == 10 && date.charAt(2) == '/' && date.charAt(5) == '/')) {
            return false;
        }
        return true;
    }

    private static boolean checkYearValue(String date) {
        int year = Integer.parseInt(date.substring(6, 10));
        if (!(year >= 1900 && year <= 2100)) {
            return false;
        }
        return true;
    }

    private static boolean checkMonthValue(String date) {
        int month = Integer.parseInt(date.substring(3, 5));
        if (!(month >= 1 && month <= 12)) {
            return false;
        }
        return true;
    }

    private static boolean checkDayValue(String date) {
        HashMap<Integer, Integer> months = new HashMap<Integer, Integer>() {{
            put(1, 31);
            put(2, 29);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
        }};
        int month = Integer.parseInt(date.substring(3, 5));
        int day = Integer.parseInt(date.substring(0, 2));
        if (!(day >= 1 && day <= months.get(month))) {
            return false;
        }
        return true;
    }
}
