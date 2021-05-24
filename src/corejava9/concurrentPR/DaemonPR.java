package corejava9.concurrentPR;

class DaemonPR implements Runnable {

    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new DaemonPR()); // run()이란 메소드를 가지고 있는 인터페이스를 생성자에 넣어준다.
        t.setDaemon(true);
        t.start();

        for(int i=0; i<=10; i++){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
            System.out.println(i);

            if(i==5) autoSave = true;
        }
        System.out.println("프로그램을 종료합니다.");
    }


    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3 * 1000);
            }catch(InterruptedException e) {}
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("자동 저장");
    }
}
