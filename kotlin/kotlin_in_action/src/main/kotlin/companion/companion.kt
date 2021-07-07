

//원래 java 코드
/*
    public class Person {
        public static final int MAX_AGE = 500;
    }
    public static void main() {
        System.out.println(Person.MAX_AGE);
    }
*/

class Person {
    companion object {
        const val MAX_AGE: Int = 500
    }
}

fun main() {
    printf(Person.MAX_AGE)
}


