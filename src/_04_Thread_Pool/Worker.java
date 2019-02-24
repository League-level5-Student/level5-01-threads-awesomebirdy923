package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

	private ConcurrentLinkedQueue<Task> queue;
	
	public Worker(ConcurrentLinkedQueue<Task> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!queue.isEmpty()) {
			Task task = queue.remove();
			task.perform();
		}
	}


}
