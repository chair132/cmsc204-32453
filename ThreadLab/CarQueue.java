import java.util.Queue;
import java.util.LinkedList;

public class CarQueue {

	private Queue<Integer> queue;
	
	public CarQueue() {
		queue = new LinkedList<>();
		
		for(int i = 0; i < 6; i++) {
			//adds an integer from 0-3
			queue.add((int)(Math.random()*4));
		}
		
	}
	public void addToQueue() {
		
		
		
		class myRunnable implements Runnable{
			public void run() {
				try {
					while (true) {
						queue.add((int)(Math.random()*4));
						Thread.sleep(500);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
		}
		
		Runnable newRunnable = new myRunnable();
		Thread a = new Thread(newRunnable);
		a.start();
		
		
	}
	
	public Integer deleteQueue() {
		//gets the head
		return queue.poll();
	}
	
}
