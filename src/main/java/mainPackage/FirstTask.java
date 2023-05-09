package mainPackage;

public class FirstTask {
    public static void start() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    long timeFromStart = (System.currentTimeMillis() - startTime)/1000;
                    if(timeFromStart % 5 != 0) {
                        System.out.println(Math.round(timeFromStart));
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Минуло 5 секунд");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
