package MyCache;
import java.util.HashMap;
import java.util.Map;

interface Cache {
	void put(String id,Cacheable c);
	Cacheable remove(String id);
	Map getMap();
	
}
public class ConcreteCache implements Cache {
	Map<String,Cacheable> m = new HashMap<>();
	
	public Map getMap(){
		return m;
	}
	
	

	@Override
	public void put(String id, Cacheable c) {
		m.put(id, c);
		
	}

	@Override
	public Cacheable remove(String id) {
		// TODO Auto-generated method stub
		return m.remove(id);
	}

}
