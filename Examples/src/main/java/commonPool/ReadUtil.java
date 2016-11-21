package commonPool;

import java.io.IOException;
import java.io.Reader;

public class ReadUtil {
	public ReadUtil(){}
	
	public String readToString(Reader in) throws IOException{
		StringBuffer buff = new StringBuffer();
		
		try{
			for (int c=in.read(); c != -1; c=in.read()){
				buff.append((char)c);
			}
			return buff.toString();
		}catch (IOException e){
			e.printStackTrace();
			throw e;
		}finally{
			in.close();
		}
	}
}
