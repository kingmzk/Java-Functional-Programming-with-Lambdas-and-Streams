package Programming2;

import java.util.stream.IntStream;

public class Thread_06 {
    public static void main(String[] args) {
        /*
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i < 1000; i++){
                    System.out.println(Thread.currentThread().getId()+ " : "+ i);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();
*/

        Runnable runnable1 = () -> {
                for(int i = 0 ;i < 1000; i++){
                    System.out.println(Thread.currentThread().getId()+ " : "+ i);
                }
        };

        Runnable runnable2 = () -> {
            IntStream.rangeClosed(1,1000).forEach( i -> System.out.println(Thread.currentThread().getId() + " : " + i));
        };

        Thread thread = new Thread(runnable2);
        thread.start();

        Thread thread1 = new Thread(runnable2);
        thread1.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        Thread thread3 = new Thread(runnable2);
        thread3.start();
    }
}
