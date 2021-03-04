package com.digibank.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppHelper {
	
	private AppHelper() {
    }

    public static Date stringToDate(String inputdate) {
        try {
            DateFormat format = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
            return format.parse(inputdate);
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateFormat(Date inputdate, String format) {
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat(format);
            return dateformat.format(inputdate);
        } catch (Exception e) {
            return "";
        }
    }
    
    public static boolean IsNameValid(String name) {
        return name.matches("^[a-zA-Z-.\' ]*$");
    }
    
    public static boolean IsEmailValid(String email) {
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
}
