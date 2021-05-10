package java.generic;

import java.util.ArrayList;

public class Main {

    public static boolean hasNulls(ArrayList<?> elements) {
        for (Object e : elements) {
            if(e == null) return true;
        }
        return false;
    }

    public static <T> boolean hasNulls2(ArrayList<T> elements) {
        for (Object e : elements) {
            if(e == null) return true;
        }
        return false;
    }

}
