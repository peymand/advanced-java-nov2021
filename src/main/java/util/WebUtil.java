package util;

import javax.servlet.http.Cookie;

public class WebUtil {

    public static String getCookieValue(String name, Cookie[] cookies) {
        String value = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    name = cookie.getValue();
                }
            }
        }else{
            value = "";
        }
        return value;
    }
    //TODO: implement this method
    public static String[] getCookieValues(String[] name, Cookie[] cookies){
        return null;
    }
}
