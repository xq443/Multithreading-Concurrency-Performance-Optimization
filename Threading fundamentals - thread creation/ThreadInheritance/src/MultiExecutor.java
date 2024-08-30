import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiExecutor {

  private final List<Runnable> tasks;

  /*
   * @param tasks to executed concurrently
   */
  public MultiExecutor(List<Runnable> tasks) {
    this.tasks = tasks;
  }

  /**
   * Executes all the tasks concurrently
   */
  public void executeAll() {
    List<Thread> threads = new ArrayList<>(tasks.size());

    for (Runnable task : tasks) {
      Thread thread = new Thread(task);
      threads.add(thread);
    }

    for(Thread thread : threads) {
      thread.start();
    }
  }

  public static void main(String[] args) {
    Runnable task1 = () -> System.out.println("Task 1 is running");
    Runnable task2 = () -> System.out.println("Task 2 is running");
    Runnable task3 = () -> System.out.println("Task 3 is running");

    MultiExecutor multiExecutor = new MultiExecutor(Arrays.asList(task1, task2, task3));
    multiExecutor.executeAll();
  }
}