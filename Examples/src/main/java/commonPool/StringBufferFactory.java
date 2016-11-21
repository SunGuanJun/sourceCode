package commonPool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class StringBufferFactory extends BasePooledObjectFactory<StringBuffer>{

	@Override
	public StringBuffer create() throws Exception {
		return new StringBuffer();
	}

	@Override
	public PooledObject<StringBuffer> wrap(StringBuffer buff) {
		return new DefaultPooledObject<StringBuffer>(buff);
	}
	
	@Override
	public void passivateObject(PooledObject<StringBuffer> pooledObject){
		pooledObject.getObject().setLength(0);
	}
}
