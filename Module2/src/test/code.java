package test;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Date date1 = new Date(90,4,1);
        Date date2 = new Date(90,4,29);
        System.out.println(date1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr1 = simpleDateFormat.format(date1);
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println(dateStr1);

        LocalDate dateL1 = convertToLocalDateViaInstant(date1);
        LocalDate dateL2 = convertToLocalDateViaInstant(date2);



        long diff = date1.getTime() -date2.getTime();
        System.out.println(diff);
        long days = (diff / (1000*60*60*24));
        System.out.println(days);
        long month = days/30;
        System.out.println(month);


    }

    static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }




    static String dateToString (Date date){
        String dateStr = (date.getYear() + 1900)+"-"+(date.getMonth()+1)+"-"+date.getDay();
        return dateStr;
    }
}
