package com.hg.reading.springstart.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {

    public static String getSqlDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }

    public static Date getCurrentTime(){
        return new Date();
    }


}
