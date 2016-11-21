package commonPool;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.pool2.ObjectPool;

public class ReadUtil2 {
	private ObjectPool<StringBuffer> pool;
	
	public ReadUtil2(ObjectPool<StringBuffer> pool){
		this.pool = pool;
	}
	
	public String readToString(Reader in) throws IOException{
		StringBuffer buff = null;
		
		try{
			buff = pool.borrowObject();
			for (int c=in.read(); c!=-1; c=in.read()){
				buff.append((char)c);
			}
			return buff.toString();
		}catch(IOException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("dsakjf");
		}finally{
			in.close();
			
			try{
				if (null != buff){
					pool.returnObject(buff);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
