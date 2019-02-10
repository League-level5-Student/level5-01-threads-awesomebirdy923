package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		Robot useless = new Robot(100, 350);
		Robot useless1 = new Robot(230, 500);
		Robot useless2 = new Robot(360, 350);
		Robot useless3 = new Robot(490, 500);
		Robot useless4 = new Robot(620, 350);
		useless.setPenColor(Color.BLUE);
		useless1.setPenColor(Color.YELLOW);
		useless2.setPenColor(Color.BLACK);
		useless3.setPenColor(Color.green);
		useless4.setPenColor(Color.RED);
		useless.setPenWidth(10);
		useless1.setPenWidth(10);
		useless2.setPenWidth(10);
		useless3.setPenWidth(10);
		useless4.setPenWidth(10);
		useless.penDown();
		useless1.penDown();
		useless2.penDown();
		useless3.penDown();
		useless4.penDown();
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				useless.turn(1);
				useless.move(2);
			}
		});
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				useless1.turn(1);
				useless1.move(2);
			}
		});
		Thread thread3 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				useless2.turn(1);
				useless2.move(2);
			}
		});
		Thread thread4 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				useless3.turn(1);
				useless3.move(2);
			}
		});
		Thread thread5 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				useless4.turn(1);
				useless4.move(2);
			}
		});
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}

}
