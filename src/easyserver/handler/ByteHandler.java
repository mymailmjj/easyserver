/**
 * 
 */
package easyserver.handler;

/**
 * 把NIO转换成byte[]
 * @author cango
 *
 */
public class ByteHandler extends AbstractHandler {

    /* (non-Javadoc)
     * @see easyserver.handler.Handler#canHandle(java.lang.Object)
     */
    public boolean canHandle(Object obj) {
        return obj instanceof byte[];
    }

    @Override
    public Object innerhandle(Object o) {
        
        return null;
        
    }

}
