/**
 * 
 */
package Concurrency;

/**
 * @author blessonm
 *
 */
public class HelloRunnable implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new Thread(new HelloRunnable())).start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("HelloRunnable");		
	}

}
