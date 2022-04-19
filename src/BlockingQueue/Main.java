package BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Integer> blockingQueue = new BlockingQueue<Integer>(5);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    try {
                        blockingQueue.enqueue(i);
                        System.out.println("enqueued " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    try {
                        int item = blockingQueue.deque();
                        System.out.println(item);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        Thread.sleep(100l);
        t2.start();
        t1.join();
        t2.join();


    }
}
