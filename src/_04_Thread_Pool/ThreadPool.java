package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {

	private Thread[] threads;
	private ConcurrentLinkedQueue<Task> queue;
	
	public ThreadPool(int threadLength) {
		threads = new Thread[threadLength];
		queue = new ConcurrentLinkedQueue<Task>();
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Worker(queue));
		}
	}
	
	public void addTask(Task task) {
		queue.add(task);
	}
	
	public void start() {
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
