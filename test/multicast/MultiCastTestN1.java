/**
 * 
 */
package multicast;


/**
 * 组播节点1
 * @author cango
 * 
 */
public class MultiCastTestN1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MultiCastServer multCastServer = new MultiCastServer(8085,"node1");
		
		multCastServer.start();
		
	}

}
