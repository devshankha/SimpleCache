package MyCache;
import java.util.Iterator;
import java.util.Map;




public class CacheManager implements Runnable{
	int sleepTime = 5000;
	public CacheManager(Cache cache) {		
		this.cache = cache;
		map = cache.getMap();
	}

	private Cache cache;
	private Map<String,Cacheable> map;
	
	void put(String id,Cacheable o){
		o.setInserTionTime();
		cache.put(id, o);
		
	}
	Cacheable remove(String id){
		return cache.remove(id);
		
	}
	@Override
	public void run() {
		while (true){
			Iterator<String> iter = map.keySet().iterator();
			while (iter.hasNext()){
				String id = iter.next();
				Cacheable c = map.get(id);
				if (c.isExpired())
					map.remove(id);
				
			}
			try {
			Thread.sleep(sleepTime);
			} catch (Exception e){
				
			}
		}
		
	}

	
	

}
