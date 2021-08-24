package com.nnk.springboot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUtils {

    private static Pattern pattern;
    private static Matcher matcher;

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public static boolean validatePassword(String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }



}
