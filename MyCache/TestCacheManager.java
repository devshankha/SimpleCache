package MyCache;

public class TestCacheManager {
	public static void main(String[] args) {
		Cache cache = new ConcreteCache();
		CacheManager manager = new CacheManager(cache) ;
		Cacheable c = new MyClass();
		manager.put(c.getId(),c);
		manager.remove(c.getId());
		
	}

}
