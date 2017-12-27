/**
 * 
 */
package multicast;


/**
 * @author cango
 * 
 */
public class MultiCastTestN1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MutiCastServer multCastServer = new MutiCastServer(8085,"node1");
		
		multCastServer.start();
		
	}

}
