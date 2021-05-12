package java.stream;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //원본 스트림에 있는 요소의 중복을 제외하고, 같은 순서로 돌려주는 스트림을 반환함
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
    }
}
