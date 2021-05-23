package corejava9.generic;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    //
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

    // 와일드 카드
    public static void printCollection(Collection collection) {
        for (Object e : collection ){
            System.out.println(e);
        }
    }
    public static void printCollectionGen(Collection<Object> collection) {
        for (Object e : collection ){
            System.out.println(e);
        }
    }


    // 와일드 카드 캡처
    public static void swap(ArrayList<?> elements, int i, int j) {
        swapHelper(elements, i, j);
    }

    public static <T> void swapHelper(ArrayList<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

}
