/**
 * 
 */
package requestchain;

/**
 * 一个典型的执行链条模型
 * 主要用了责任链和适配器模型
 * 
 * @author cango
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		FirstInteceptor firstInteceptor = new FirstInteceptor();
		
		SecondInteceptor secondInteceptor = new SecondInteceptor();
		
		BaseHandlerInteceptor baseHandlerInteceptor = new BaseHandlerInteceptor();
		
		LastInteceptor lastInteceptor = new LastInteceptor();
		
		firstInteceptor.setNext(secondInteceptor);
		
		secondInteceptor.setNext(baseHandlerInteceptor);
		
		baseHandlerInteceptor.setNext(lastInteceptor);
		
		CommonHandler commonHandler = new CommonHandler();
		
		AMessageHanlder aMessageHanlder = new AMessageHanlder();
		
		BMessageHandler bMessageHandler = new BMessageHandler();
		
		baseHandlerInteceptor.addMessageHandler(aMessageHanlder);
		
		baseHandlerInteceptor.addMessageHandler(bMessageHandler);
		
		baseHandlerInteceptor.addMessageHandler(commonHandler);
		
		AMessage message = new AMessage("message");
		
		firstInteceptor.intecept(message);
		
	}

}
