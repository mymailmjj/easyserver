/**
 * 
 */
package easyserver.session;

/**
 * @author cango
 *
 */
public interface Session {
    
    public String getId();
    
    public void setId(String id);
    
    public long getAccessTime();
    
    public void setAccessTime(long timeStampe);
    
    public void setValidInteval(long time);
    
    public long getValidInteval();
    
    public void setAttr(String key, String value);
    
    public String getAttr(String key);
    
    public void setCreateTime(long createTime);
    
    public long getCreateTime();
    

}
