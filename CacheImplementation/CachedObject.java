package Cache;

import java.util.Date;

public class CachedObject implements Cacheable {
	private Object identifier = null;
    /*  This contains the real "value".  This is the object which needs to
be
        shared.
    */
    public Object object = null;
    long timetoLive = -1;
    Date dateofExpiration = null;
    public CachedObject(Object obj, Object id, int minutesToLive)
    {
    	
      this.object = obj;
      this.identifier = id;
      this.timetoLive = minutesToLive;
      if (minutesToLive != 0)
      {
        dateofExpiration = new java.util.Date();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(dateofExpiration);
        cal.add(cal.MINUTE, minutesToLive);
        dateofExpiration = cal.getTime();
      }
    }
    public boolean isExpired()
    {
    	if (dateofExpiration != null)
        {
          // date of expiration is compared.
          if (dateofExpiration.before(new Date()))
          {
            System.out.println("CachedResultSet.isExpired:  Expired from Cache! EXPIRE TIME: " + dateofExpiration.toString() + " CURRENT TIME: " +
(new java.util.Date()).toString());
            return true;
          }
          else
          {
            System.out.println("CachedResultSet.isExpired:  Expired not from Cache!");
            return false;
          }
        }
        else // This means it lives forever!
          return false;
    	
       
      
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Object getIdentifier()
    {
      return identifier;
    }

}
