/**
 * 
 */
package Concurrency;

/**
 * @author blessonm
 *
 */
public class Interrupts implements Runnable {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Interrupts());
		t.start();
		Thread.sleep(1000);
		t.interrupt();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run(){
		System.out.println("Call work");
		try {
			work();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void work() throws InterruptedException{
		while(true){
			if(Thread.interrupted()){
				Thread.sleep(2000);
				System.out.println("Interrupted");
				return;
			}
			else
				System.out.println("Not Interrupted");
		}
	}

}
