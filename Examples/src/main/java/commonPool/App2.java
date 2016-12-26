package commonPool;

public class App2 {
	public static void main(String[] args){
		String[] aa = {"sss"};
		String str = "ddd;ccc;eee";
		
		aa = str.split(";");
		
		for (String s:aa){
			System.out.println(s);
		}
	}
}
