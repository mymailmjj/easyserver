/**
 * 
 */
package multicast;


/**
 * 组播节点2
 * @author cango
 * 
 */
public class MultiCastTestN2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MultiCastServer multCastServer = new MultiCastServer(8085,"node2");
		
		multCastServer.start();

	}

}
