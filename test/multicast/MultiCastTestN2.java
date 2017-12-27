/**
 * 
 */
package multicast;


/**
 * @author cango
 * 
 */
public class MultiCastTestN2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MutiCastServer multCastServer = new MutiCastServer(8085,"node2");
		
		multCastServer.start();
		

	}

}
