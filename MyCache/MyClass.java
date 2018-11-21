package MyCache;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

 interface Cacheable {
	boolean isExpired();
	void setInserTionTime();
	String getId();
}
public class MyClass implements Cacheable{
	long inserTionTime;
	int timeOutinterval = 2;
	

	@Override
	public boolean isExpired() {
		if ((System.currentTimeMillis()-inserTionTime)> timeOutinterval*60*60)
			return true;
		return false;
	}

	@Override
	public void setInserTionTime() {
		inserTionTime = System.currentTimeMillis();
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}
	

}
