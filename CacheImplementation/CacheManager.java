package Cache;

import java.util.HashMap;
import java.util.Iterator;

public class CacheManager {
	static HashMap cacheHashMap = new HashMap();
	static Thread t;

	public CacheManager() {
		Thread clean = new Cleaner();
		clean.setPriority(Thread.MIN_PRIORITY);
		clean.start();
	}

	public void putCache(Cacheable object)
	  {
	   
	    // will be replaced.  This is valid functioning.
	    cacheHashMap.put(object.getIdentifier(), object);
	  }
	 public Cacheable getCache(Object identifier)
 {
		// synchronized (lock) // UNCOMMENT LINE XXX
		// { // UNCOMMENT LINE XXX
		Cacheable object = (Cacheable) cacheHashMap.get(identifier);
		// The code to create the object would be placed here.
		// } // UNCOMMENT LINE XXX
		if (object == null)
			return null;
		if (object.isExpired()) {
			cacheHashMap.remove(identifier);
			return null;
		} else {
			return object;
		}

	}
	 class Cleaner extends Thread {
		 public void run() {
			 try {
			 while (true) {
				 Iterator iter = cacheHashMap.entrySet().iterator();
				 while(iter.hasNext()) {
					 Object key = iter.next();
					 Cacheable value = (Cacheable)cacheHashMap.get(key);
					 if (value.isExpired()){
						 iter.remove();
					 }
				 }
				 Thread.sleep(5000);
			 }
			 
		 } catch (Exception e){
			 
		 }
	 }

}
}
