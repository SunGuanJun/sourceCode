package Tasks;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {
	public static void main(String[] args){
		TimerTaskTest app = new TimerTaskTest();
		app.testTimer();
	}
	
	public void testTimer(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask1(), 5000, 1000);
	}
	
	private class TimerTask1 extends TimerTask{
		public void run(){
			System.out.println("hello");
		}
	}
}
