package com.example.paymentservice.ui.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.ContextThemeWrapper;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class CommonUtils {
    @SuppressWarnings("deprecation")


    public final static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static String validMobile(String mobile) {

        String errormsg = "";
        String FIRST_DIGIT_EXAMPLE = "^[6-9][0-9]{9}$";
        String MOBILE_REGEX_SAME_EXAMPLE = "^(?=\\d{10}$)" +
                "(?:(.)\\1*|0?1?2?3?4?5?6?7?8?9?|9?8?7?6?5?4?3?2?1?0?)$";
        //first digit Indian digit

        if (!mobile.matches(FIRST_DIGIT_EXAMPLE)) {

            errormsg = "Mobile Number first digit should be 6,7,8,9";

            return errormsg;
        } else if (mobile.matches(MOBILE_REGEX_SAME_EXAMPLE)) {

            errormsg = "Mobile Number all digits should not be same";
            return errormsg;
        } else {

            return errormsg;

        }
    }

    public static String getServerFormatDate(String datetime,String fromFormat) {
        if(datetime==null || datetime.isEmpty()){
            return "";
        }
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        SimpleDateFormat sdf = new SimpleDateFormat(fromFormat);//
        String formattedTime =datetime;
        Date d = null;
        try {
            d = sdf.parse(datetime);
            formattedTime= output.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }


        return formattedTime;
    }

    public static String getOnlyDateFormat(String time) {
        if(time==null || time.isEmpty()){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy");
        String formattedTime =time;
        Date d = null;
        try {
            d = sdf.parse(time);
            formattedTime= output.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }


        return formattedTime;
    }


    public static String getDateFormat(String date) {
        SimpleDateFormat spf = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        spf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date newDate;
        try {
            newDate = spf.parse(date);
            spf = new SimpleDateFormat("yyyy-MM-dd");
            date = spf.format(newDate);

            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;
        String phrase = "";
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase += Character.toUpperCase(c);
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase += c;
        }
        return phrase;
    }


    public static void openCalender(Activity activity, final EditText etDateToSet, boolean isOTB) {

        Context context = activity;
        if (isBrokenSamsungDevice()) {
            context = new ContextThemeWrapper(activity, android.R.style.Theme_Holo_Light_Dialog);
        }

        final Calendar calendar = Calendar.getInstance();
        //calendar.add(Calendar.YEAR,-18); //If age limit is 18 year
        final DatePickerDialog datePickerDialog = new DatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT,
                (view, year, monthOfYear, dayOfMonth) -> {



                },
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", (dialog, which) -> {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                DatePicker datePicker = datePickerDialog.getDatePicker();
                calendar.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());

                int year = calendar.get(Calendar.YEAR);
                SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
                String month = month_date.format(calendar.getTime());
                int day = calendar.get(Calendar.DAY_OF_MONTH);


                etDateToSet.setText(makeDateDoubleFigure(day) + "-" + month + "-" + year);
            }
        });
        /*datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        if (isOTB) {
            try {
                Date today = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add(Calendar.MONTH, -1);// Subtract 1 months
                long minDate = c.getTime().getTime(); // Twice!
                datePickerDialog.getDatePicker().setMinDate(minDate);

            } catch (Exception ex) {

            }
        }*/

        datePickerDialog.show();

    }

    public static void openWaetherCalender(Activity activity, final EditText etDateToSet, boolean isOTB) {

        Context context = activity;
        if (isBrokenSamsungDevice()) {
            context = new ContextThemeWrapper(activity, android.R.style.Theme_Holo_Light_Dialog);
        }

        final Calendar calendar = Calendar.getInstance();
        //calendar.add(Calendar.YEAR,-18); //If age limit is 18 year
        final DatePickerDialog datePickerDialog = new DatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT,
                (view, year, monthOfYear, dayOfMonth) -> {



                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", (dialog, which) -> {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                DatePicker datePicker = datePickerDialog.getDatePicker();
                int dayOfMonth = datePicker.getDayOfMonth(), year = datePicker.getYear(), monthOfYear = datePicker.getMonth() + 1;
                etDateToSet.setText(makeDateDoubleFigure(dayOfMonth) + "-" + makeDateDoubleFigure(monthOfYear) + "-" + year);            }
        });
//        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
/*
        if (isOTB) {
            try {
                Date today = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add(Calendar.MONTH, -1);// Subtract 1 months
                long minDate = c.getTime().getTime(); // Twice!
                datePickerDialog.getDatePicker().setMinDate(minDate);

            } catch (Exception ex) {

                ex.getMessage();
            }
        }
*/

        datePickerDialog.show();

    }
    public static void openWaetherCalenderto(Activity activity, final EditText etDateToSet, boolean isOTB) {

        Context context = activity;
        if (isBrokenSamsungDevice()) {
            context = new ContextThemeWrapper(activity, android.R.style.Theme_Holo_Light_Dialog);
        }

        final Calendar calendar = Calendar.getInstance();
        //calendar.add(Calendar.YEAR,-18); //If age limit is 18 year
        final DatePickerDialog datePickerDialog = new DatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT,
                (view, year, monthOfYear, dayOfMonth) -> {



                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", (dialog, which) -> {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                DatePicker datePicker = datePickerDialog.getDatePicker();
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

                int dayOfMonth = datePicker.getDayOfMonth(), year = datePicker.getYear(), monthOfYear = datePicker.getMonth() + 1;
                etDateToSet.setText(makeDateDoubleFigure(dayOfMonth) + "-" + makeDateDoubleFigure(monthOfYear) + "-" + year);            }
        });
//        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());

        if (isOTB) {
            try {
                Date today = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add(Calendar.MONTH, -1);// Subtract 1 months
                long minDate = c.getTime().getTime(); // Twice!
//                datePickerDialog.getDatePicker().setMinDate(minDate);

            } catch (Exception ex) {

                ex.getMessage();
            }
        }


        datePickerDialog.show();

    }
    private static boolean isBrokenSamsungDevice() {
        return (Build.MANUFACTURER.equalsIgnoreCase("samsung")
                && isBetweenAndroidVersions(
                Build.VERSION_CODES.LOLLIPOP,
                Build.VERSION_CODES.LOLLIPOP_MR1));
    }

    private static boolean isBetweenAndroidVersions(int min, int max) {
        return Build.VERSION.SDK_INT >= min && Build.VERSION.SDK_INT <= max;
    }

    private static String makeDateDoubleFigure(int data) {
        String temp = "";
        if (data < 10) {
            temp = "0" + data;
        } else {
            temp = "" + data;
        }
        return temp;
    }


    public static String getCurrentDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getCurrentResolutionDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public static boolean between(String weatherdate, String fromdate, String todate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

            Date date = sdf1.parse(weatherdate);
            Date dateStart=sdf.parse(fromdate);
            Date dateEnd=sdf.parse(todate);
            if (date != null && dateStart != null && dateEnd != null) {
                if ((date.after(dateStart) && date.before(dateEnd)) || date.equals(dateStart) || date.equals(todate)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return false;
    }






}
