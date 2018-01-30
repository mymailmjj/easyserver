/**
 * 
 */
package easyserver.session;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cango
 *
 */
public class SessionManager implements SessionIdGenerator{
    
    private Map<String,Session> sessions = new HashMap<String,Session>();
    
    private SessionIdGenerator sessionIdGenerator;

    
    public SessionIdGenerator getSessionIdGenerator() {
        return sessionIdGenerator;
    }


    public void setSessionIdGenerator(SessionIdGenerator sessionIdGenerator) {
        this.sessionIdGenerator = sessionIdGenerator;
    }


    public Session getSession(String sessionId){
        
        Session session = sessions.get(sessionId);
        
        if(session!=null) return session;
        
        Session createSession = createSession();
        
        return createSession;
    }
    

    public String generateId() {
        return sessionIdGenerator.generateId();
    }
    
    
    private Session createEmptySession(){
        Session session = new DefaultSession();
        return session;
    }
    
    public Session createSession(){
        
        Session session = createEmptySession();
        
        session.setId(generateId());
        
        session.setAccessTime(System.currentTimeMillis());

        session.setCreateTime(System.currentTimeMillis());
        
        return session;
    }

}
