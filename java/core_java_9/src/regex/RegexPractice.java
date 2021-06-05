package regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* 정규표현식을 사용하는 방식
* 1. 문자열이 정규 표현식을 준수하는지 찾는 방식 -> 정적 메서드 matches를 사용
* 2. 문자열에서 정규 표현식의 일치 항목을 모두 찾는 방식
*
* */
public class RegexPractice {

    public static void main(String[] args){
        // # 정규 표현식을 준수하는지 찾는 방식
        // 1 정적 메서드 matches를 사용한다
        String regex = "[+-]?\\d+";
        CharSequence input = "dasd";
        if(Pattern.matches(regex, input)){
            //...행위
        }
        // 2 정규 표현식을 여러 번 사용해야 할 때는 정규 표현식을 컴파일하는 것이 더 효율적이다
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            //...행위
        }
        // 3 컬렉션이나 스트림에 들어 있는 요소와 일치하게 하려면 패턴을 프레디케이트로 변환해야 한다
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("Apple","Banana","Melon","Grape","Strawberry"));
        Stream<String> strings = list.stream();
        strings.filter(pattern.asPredicate());

        // # 모든 일치 항목 찾기
        Matcher matcher2 = pattern.matcher(input);
        while(matcher2.find()) {
            String match = matcher.group();
            int matchStart = matcher.start();
            int matchEnd = matcher.end();
        }

        // # 일치 항목의 구성 요소 추출할 때는 그룹을 이용
        String item="";
        String currency="";
        Matcher matcher3 = pattern.matcher(input);
        if(matcher3.matches()){
            item = matcher.group(1);
            currency = matcher.group(3);
        }
    }
}
