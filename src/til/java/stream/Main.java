package til.java.stream;

import java.util.stream.Stream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //distinct:원본 스트림에 있는 요소의 중복을 제외하고, 같은 순서로 돌려주는 스트림을 반환함
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        uniqueWords.forEach(System.out::println);

        //peek:요소를 추출할 때 마다 전달받은 함수를 호출함
        Object[] powers = Stream.iterate(1.0,  p -> p * 2)
                .peek(e -> System.out.println("Fetching "+e))
                .limit(20).toArray();

        //단순 리덕션:스트림의 종료 연산

        //optional
        Optional<String> empty = Optional.empty();
        assert(empty.isPresent());
    }
}
