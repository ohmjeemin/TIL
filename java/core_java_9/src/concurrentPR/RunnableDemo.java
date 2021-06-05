package concurrentPR;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 병행성 데모 프로그램
* */
public class RunnableDemo {
    public static void main(String[] args){
        Runnable hellos = () -> {
          for(int i=1; i <= 1000; i++)
              System.out.println("Hello " + i);
        };
        Runnable goodbyes = () -> {
            for(int i = 1; i<=1000; i++)
                System.out.println("goodbye" + i);
        };

        //executorService는 태스크를 스케줄링하고 해당 테스크를 수행할 스레드를 선택해 실행한다.
        //newCachedThreadPool은 스케줄링 정책이 서로 다른 실행자 서비스를 만드는 팩토리 메서드이다.
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(hellos);
        executor.execute(goodbyes);
    }
}
