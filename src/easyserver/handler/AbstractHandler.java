/**
 * 
 */
package easyserver.handler;

/**
 * @author cango
 *
 */
public abstract class AbstractHandler implements Handler {
    
    protected Handler next;

    /* (non-Javadoc)
     * @see easyserver.handler.Handler#canHandle(java.lang.Object)
     */
    public boolean canHandle(Object obj) {
        return false;
    }

    /* (non-Javadoc)
     * @see easyserver.handler.Handler#heandle(java.lang.Object)
     */
    public Object heandle(Object o) {
        boolean canhandle = this.canHandle(o);
        if(!canhandle){
            return this.next.heandle(o);
        }else{
            Object no = innerhandle(o);
           return this.next.heandle(no);
        }
    }
    
    public abstract Object innerhandle(Object o);

    public void setNext(Handler next) {
       this.next = next;
    }

}
