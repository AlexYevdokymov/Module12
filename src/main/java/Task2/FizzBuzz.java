package Task2;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void start(int a) {
        ProcessThread fizzProcessor = new ProcessThread((n) -> {
            if(n % 3 == 0) {
                System.out.println("fizz");
            }
        });
        ProcessThread buzzProcessor = new ProcessThread((n) -> {
            if(n % 5 == 0) {
                System.out.println("buzz");
            }
        });
        ProcessThread fizzBuzzProcessor = new ProcessThread((n) -> {
            if(n % 3 == 0 && n % 5 == 0) {
                System.out.println("fizzbuzz");
            }
        });
        ProcessThread defaultProcessor = new ProcessThread((n) -> {
            if(n % 3 != 0 && n % 5 != 0) {
                System.out.println(n);
            }
        });

        List<ProcessThread> threads = new ArrayList<>();
        threads.add(fizzProcessor);
        threads.add(buzzProcessor);
        threads.add(fizzBuzzProcessor);
        threads.add(defaultProcessor);

        for (ProcessThread thread: threads) {
            thread.start();
        }

        for (int i = 1; i < a + 1; i++) {
            for (ProcessThread thread: threads) {
                thread.process(i);
            }
            while (true) {
                int processedCount = 0;
                for (ProcessThread thread: threads) {
                    if(thread.getIsProcessed().get()) {
                        processedCount++;
                    }
                }
                if(processedCount == threads.size()) {
                    break;
                }
            }
        }
    }
}
