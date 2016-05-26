package com.himanshu.frameworkdemo.helpers;

import android.graphics.PorterDuff;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Himanshu Patel
 * @since 19-May-2015, 5:54:12 pm
 */
public class Validations {

    private Pattern pattern;

    private Matcher matcher;


    public boolean isNotBlank(EditText editText, int colorSuccess, int colorError) {
//        return !editText.getText().toString().trim().equals("");
        return result(!editText.getText().toString().trim().equals(""), editText, colorSuccess, colorError);
    }

    public boolean isMatching(EditText editTextFirst, EditText editTextSecond, int colorSuccess, int colorError) {
//        return editTextFirst.getText().toString().trim().equals(editTextSecond.getText().toString().trim());
        result(editTextFirst.getText().toString().trim().equals(editTextSecond.getText().toString().trim()), editTextFirst, colorSuccess, colorError);
        return result(editTextFirst.getText().toString().trim().equals(editTextSecond.getText().toString().trim()), editTextSecond, colorSuccess, colorError);
    }

    public boolean isValidMail(EditText editText, int colorSuccess, int colorError) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(editText.getText().toString().trim());
//        return matcher.matches();
        return result(matcher.matches(), editText, colorSuccess, colorError);
    }

    public boolean isValidFullName(EditText editText, int colorSuccess, int colorError) {
        if (editText.getText().toString().trim().length() > 30) {
            String FULL_NAME = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
            pattern = Pattern.compile(FULL_NAME);
            matcher = pattern.matcher(editText.getText().toString().trim());
//            return matcher.matches();
            return result(matcher.matches(), editText, colorSuccess, colorError);
        } else {
//            return false;
            return result(false, editText, colorSuccess, colorError);
        }
    }

    public boolean isValidFirstName(EditText editText, int colorSuccess, int colorError) {
        if (editText.getText().toString().trim().length() > 15) {
            String FIRST_NAME = "[A-Z][a-zA-Z]*";
            pattern = Pattern.compile(FIRST_NAME);
            matcher = pattern.matcher(editText.getText().toString().trim());
//            return matcher.matches();
            return result(matcher.matches(), editText, colorSuccess, colorError);
        } else {
//            return false;
            return result(false, editText, colorSuccess, colorError);
        }
    }

    public boolean isValidLastName(EditText editText, int colorSuccess, int colorError) {
        if (editText.getText().toString().trim().length() > 15) {
            String LAST_NAME = "[a-zA-z]+([ '-][a-zA-Z]+)*";
            pattern = Pattern.compile(LAST_NAME);
            matcher = pattern.matcher(editText.getText().toString().trim());
//            return matcher.matches();
            return result(matcher.matches(), editText, colorSuccess, colorError);
        } else {
//            return false;
            return result(false, editText, colorSuccess, colorError);
        }
    }

    public boolean isValidAddress(EditText editText, int colorSuccess, int colorError) {
        if (editText.getText().toString().trim().length() > 200) {
//        String ADDRESS = "\\\\d+\\\\s+([a-zA-Z]+|[a-zA-Z]+\\\\s[a-zA-Z]+)";
            String ADDRESS = "^[a-zA-Z0-9_\\\\s\\\\.,]{1,}$";
            pattern = Pattern.compile(ADDRESS);
            matcher = pattern.matcher(editText.getText().toString().trim());
//            return matcher.matches();
            return result(matcher.matches(), editText, colorSuccess, colorError);
        } else {
//            return false;
            return result(false, editText, colorSuccess, colorError);
        }
    }

    public boolean isValidCity(EditText editText, int colorSuccess, int colorError) {
        if (editText.getText().toString().trim().length() > 30) {
            String CITY = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
            pattern = Pattern.compile(CITY);
            matcher = pattern.matcher(editText.getText().toString().trim());
//            return matcher.matches();
            return result(matcher.matches(), editText, colorSuccess, colorError);
        } else {
//            return false;
            return result(false, editText, colorSuccess, colorError);
        }
    }

    public boolean isValidState(EditText editText, int colorSuccess, int colorError) {
        if (editText.getText().toString().trim().length() > 30) {
            String STATE = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
            pattern = Pattern.compile(STATE);
            matcher = pattern.matcher(editText.getText().toString().trim());
//            return matcher.matches();
            return result(matcher.matches(), editText, colorSuccess, colorError);
        } else {
//            return false;
            return result(false, editText, colorSuccess, colorError);
        }
    }

    public boolean isValidDate(EditText editText, int colorSuccess, int colorError) {
        if (editText.getText().toString().trim().length() > 30) {
            String DATE = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
            pattern = Pattern.compile(DATE);
            matcher = pattern.matcher(editText.getText().toString().trim());
//            return matcher.matches();
            return result(matcher.matches(), editText, colorSuccess, colorError);
        } else {
//            return false;
            return result(false, editText, colorSuccess, colorError);
        }
    }

    public boolean isValidPinCode(EditText editText, int colorSuccess, int colorError) {
        String PINCODE = "\\d{6}";
        pattern = Pattern.compile(PINCODE);
        matcher = pattern.matcher(editText.getText().toString().trim());
//        return matcher.matches();
        return result(matcher.matches(), editText, colorSuccess, colorError);
    }

    public boolean isValidAge(EditText editText, int colorSuccess, int colorError) {
        if (editText.getText().toString().trim().length() > 3) {
            String NUMBER_ONLY = "\\d+";
            pattern = Pattern.compile(NUMBER_ONLY);
            if (!editText.getText().toString().trim().equalsIgnoreCase("") && pattern.matcher(editText.getText().toString().trim()).matches()) {
//                return Integer.parseInt(editText.getText().toString().trim()) <= 300;
                return result(Integer.parseInt(editText.getText().toString().trim()) <= 300, editText, colorSuccess, colorError);
            } else {
//                return false;
                return result(false, editText, colorSuccess, colorError);
            }
        } else {
//            return false;
            return result(false, editText, colorSuccess, colorError);
        }
    }

    public boolean isValidPhone(EditText editText, int colorSuccess, int colorError) {
        String PHONE = "\\d{10}";
        pattern = Pattern.compile(PHONE);
        matcher = pattern.matcher(editText.getText().toString().trim());
//        return matcher.matches();
        return result(matcher.matches(), editText, colorSuccess, colorError);
    }

    public boolean isValidPrice(EditText editText, int colorSuccess, int colorError) {
        String PRICE = "((\\d{1,9})(((\\.)(\\d{0,2})){0,1}))";
        pattern = Pattern.compile(PRICE);
        matcher = pattern.matcher(editText.getText().toString().trim());
//        return matcher.matches();
        return result(matcher.matches(), editText, colorSuccess, colorError);
    }

    private boolean result(boolean state, EditText editText, int colorSuccess, int colorError) {
        if (state) {
            editText.getBackground().setColorFilter(colorSuccess, PorterDuff.Mode.SRC_IN);
        } else {
            editText.getBackground().setColorFilter(colorError, PorterDuff.Mode.SRC_IN);
        }
        return state;
    }
}
