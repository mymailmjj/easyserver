/**
 * 
 */
package easyserver.core;

/**
 * @author cango
 * 
 */
public interface Component {

	public final static String START_STATS = "START_STATS";

	public final static String PROCESS_STATS = "PROCESS_STATS";

	public final static String STOP_STATS = "STOP_STATS";

	public void start();

	public void stop();

}
