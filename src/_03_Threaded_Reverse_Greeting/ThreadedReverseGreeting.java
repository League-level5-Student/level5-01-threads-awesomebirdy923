package _03_Threaded_Reverse_Greeting;

public class ThreadedReverseGreeting {
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	
	/* HINT: You will most likely need to do this with recursion */
	
	private Thread[] threads;
	
	public ThreadedReverseGreeting() {
		threads = new Thread[50];
		recursiveThread(0);
	}
	
	public static void main(String[] args) {
		new ThreadedReverseGreeting();
	}
	
	public void recursiveThread(int index) {
		final int pointer = index+1;
		threads[index] = new Thread(() -> {
			System.out.println("Hello from Thread: " + index);
		});
		threads[index].start();
		if(pointer <= 49) {
			recursiveThread(pointer);
		}
		
	}
	
}