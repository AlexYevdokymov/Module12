package mainPackage;

public class FirstTask {
    public static void start() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                while (true) {
                    long currentTime = System.currentTimeMillis();
                    System.out.println(currentTime - startTime);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
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
