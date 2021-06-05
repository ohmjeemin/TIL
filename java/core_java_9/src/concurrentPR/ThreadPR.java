package concurrentPR;

public class ThreadPR {

    public static void main(String[] args) {
        ThreadPR2 pr2 = new ThreadPR2();
        ThreadPR3 pr3 = new ThreadPR3();

        pr2.start();
        pr3.start();

    }
}

class ThreadPR2 extends Thread {
    public void run(){
        for(int i=0; i<300; i++){
            System.out.print("=");
            System.out.println("ㅎㅇ111");
        }
    }
}

class ThreadPR3 extends Thread {
    public void run(){
        for(int i=0; i<300; i++){
            System.out.print("|");
            System.out.println("ㅎㅇ222");
        }
    }
}
