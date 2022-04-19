package BlockingQueue;

public class BlockingQueue<T> {
    int capacity;
    int end;
    int start;
    int size;
    T[] arr;
    Object lock = new Object();
    public BlockingQueue(int capacity){
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.size = 0;
        this.start = 0;
        this.end =0;
    }

    public void enqueue(T value) throws InterruptedException {
        synchronized (lock) {
            while (size == capacity) {
                System.out.println(Thread.currentThread().getName() + " waiting");
                lock.wait();
            }
            if (end == capacity) end= 0;
            arr[end] = value;
            end++;
            size++;
            lock.notifyAll();
        }
    }
    public T deque() throws InterruptedException {
        T item = null;
        synchronized (lock) {
            while (size == 0) {
                System.out.println(Thread.currentThread().getName() + " waiting");
                lock.wait();
            }

            if (start == capacity) start = 0;

            item = arr[start];
            start++;
            size--;
            lock.notifyAll();
        }
        return item;
    }
}
