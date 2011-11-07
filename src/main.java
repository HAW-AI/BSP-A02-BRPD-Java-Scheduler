
public class main {
	public static void main(String[] args) {
		Scheduler scheduler = new Scheduler();
		
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					System.out.print(".");
				}
			}
			public String toString() {
				return "Thread 1";
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					System.out.print("!");
				}
			}
			public String toString() {
				return "Thread 2";
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				while (true) {
					System.out.print("?");
				}
			}
			public String toString() {
				return "Thread 3";
			}
		};
		
		scheduler.addThread(t1);
		scheduler.addThread(t2);
		scheduler.addThread(t3);
		
		scheduler.start();
	}
}
