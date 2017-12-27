package requestchain;

public abstract class AbstractMessage implements Message{
	
	protected enum MessageType{
		BYTES,STRING
	}
	
	
	protected MessageType type;
	
	protected byte[] bytes;
	
	
	

}
