import java.lang.Thread.UncaughtExceptionHandler;

public class Demo {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("we are now in thread " + Thread.currentThread().getName());
        System.out.println("current thread priority is " + Thread.currentThread().getPriority());
        throw new RuntimeException("Intentional exception");
      }
    });

    thread.setName("new worker thread");
    thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(Thread t, Throwable e) {
        System.out.println("A critical error happened in thread " + t.getName() + " the error is " +
            e.getMessage());
      }
    });
    thread.setPriority(Thread.MAX_PRIORITY);
    System.out.println("we are in thread:" + Thread.currentThread().getName() + " before staring a new thread");
    thread.start();
    System.out.println("we are in thread:" + Thread.currentThread().getName() + " after staring a new thread");
    Thread.sleep(10000);

  }

}
