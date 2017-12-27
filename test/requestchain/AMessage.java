/**
 * 
 */
package requestchain;


/**
 * @author cango
 *
 */
public class AMessage extends AbstractMessage {
	
	public AMessage(String str){
		this.type = MessageType.BYTES;
		this.bytes = str.getBytes();
	}

	public void say() {
		byte[] b = this.bytes;
		
		for(int i = 0; i<b.length;i++){
			System.out.print((char)i);
		}
		
	}

}
