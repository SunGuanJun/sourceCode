package Tasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
	public static void main(String[] args){
		ScheduledExecutorServiceTest app = new ScheduledExecutorServiceTest();
		app.test1();
	}
	
	public void test1(){
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		service.scheduleAtFixedRate(new Runnable1("job1"), 1, 1, TimeUnit.SECONDS);
		service.scheduleWithFixedDelay(new Runnable1("job2"), 1, 2, TimeUnit.SECONDS);
	}
	
	class Runnable1 implements Runnable{
		private String name;
		
		public Runnable1(String name){
			super();
			this.name = name;
		}
		
		public void run(){
			System.out.println("executing " + name);
		}
	}
}
