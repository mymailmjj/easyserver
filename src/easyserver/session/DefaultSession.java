package easyserver.session;

import java.util.HashMap;
import java.util.Map;

public class DefaultSession implements Session {
    
    
    private String id;
    
    private long accessTime;   //访问时间
    
    private long createTime;   //创建时间
    
    private long intervalTime;     //间隔时间
    
    private Map<String,String> attriValues = new HashMap<String,String>();

    public void setAttr(String key, String value) {
        attriValues.put(key, value);
        
    }

    public String getAttr(String key) {
       return attriValues.get(key);
    }

    public String getSessionId() {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getAccessTime() {
        return this.accessTime;
    }

    public void setAccessTime(long timeStampe) {
        this.accessTime = timeStampe;
    }

    public void setValidInteval(long time) {
        this.intervalTime = time;
    }

    public long getValidInteval() {
        return intervalTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(long intervalTime) {
        this.intervalTime = intervalTime;
    }

    public Map<String, String> getAttriValues() {
        return attriValues;
    }

    public void setAttriValues(Map<String, String> attriValues) {
        this.attriValues = attriValues;
    }
    
    

}
