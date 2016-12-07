/**
 * 
 */
package Concurrency;

/**
 * @author blessonm
 *
 */
public class GuardedMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GuardedMethods obj = new GuardedMethods();
		Drop drop = obj.new Drop();
		(new Thread(obj.new Producer(drop))).start();
		(new Thread(obj.new Consumer(drop))).start();
	}
	
	public class Drop {
		
		private String message;
		private Boolean empty = true;
		
		public synchronized void put(String message){
			while(!empty){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			empty = false;
			this.message = message;
			notifyAll();
		}
		
		public synchronized String take(){
			while(empty){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			empty = true;
			notifyAll();
			return message;
		}
		
	}
	
	public class Consumer implements Runnable {
		
		private Drop drop;
		
		public Consumer(Drop drop){
			this.drop = drop;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			for(String message = drop.take(); !message.equals("DONE"); message = drop.take()){
				System.out.println(message);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	public class Producer implements Runnable {

		private Drop drop;
		
		public Producer(Drop drop){
			this.drop = drop;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			String[] s = {
					"Mares eat oats",
		            "Does eat oats",
		            "Little lambs eat ivy",
		            "A kid will eat ivy too"
			};
			
			for( int i = 0; i < s.length; i++){
				try {
					Thread.sleep(1000);
					drop.put(s[i]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			drop.put("DONE");
		}
		
	}
}
