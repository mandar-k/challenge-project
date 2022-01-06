package com.robotics.inc.inventory.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getDateInString(final Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return dateFormat.format(date);
    }

}