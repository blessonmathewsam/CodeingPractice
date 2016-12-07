/**
 * 
 */
package Concurrency;

/**
 * @author blessonm
 *
 */
public class Join implements Runnable{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Join());
		t1.start();
		Thread t2 = new Thread(new Join());
		t2.start();
		t1.join();
		t2.join();
		System.out.println("t1 & t2 are done");
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("Thread started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
