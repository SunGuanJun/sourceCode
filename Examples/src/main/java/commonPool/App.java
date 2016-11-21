package commonPool;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class App {
	public static void main(String[] args){
		ReadUtil2 util = new ReadUtil2(new GenericObjectPool<StringBuffer>(new StringBufferFactory()));
	}
}
