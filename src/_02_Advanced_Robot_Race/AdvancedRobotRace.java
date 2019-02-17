package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	
	private boolean win;
	private static Robot[] robots;
	
	public AdvancedRobotRace() {
		Thread thread1 = new Thread(() -> {
			move(0);
		});
		
		Thread thread2 = new Thread(() -> {
			move(1);
		});
		
		Thread thread3 = new Thread(() -> {
			move(2);
		});
		
		Thread thread4 = new Thread(() -> {
			move(3);
		});
		
		Thread thread5 = new Thread(() -> {
			move(4);
		});
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
	
	public static void main(String[] args) {
		robots = new Robot[5];
		for (int i = 1; i < 6; i++) {
			robots[i-1] = new Robot(i*100, 700);
			robots[i-1].changeRobot("src/easports.robi");
		}
		new AdvancedRobotRace();
	}
	
	private  void move(int i) {
		while(!win) {
			if(!win) {
				int distance = new Random().nextInt(50);
				robots[i].move(distance);
				}
				if(robots[i].getY()<=50) {
					win = true;
				}
		}
	}
	
}
