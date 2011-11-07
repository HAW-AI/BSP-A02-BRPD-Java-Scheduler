public class Scheduler extends Thread {
	private CircularThreadList queue; // Warteschlange
	private final int timeSlice; // Zeitscheibe
	private static final int DEFAULT_TIME_SLICE = 50; // 50ms
	private Thread current;

	// Konstruktor
	public Scheduler() {
		this(DEFAULT_TIME_SLICE);
	}

	public Scheduler(int timeSlice) {
		this.setPriority(MAX_PRIORITY);
		this.timeSlice = timeSlice;
		this.queue = new CircularThreadList();
	}

	// Hinzufügen eines neuen Threads
	// zur Warteschlange der rechenbereiten Threads
	public void addThread(Thread thread) {
		this.queue.addItem(thread);
	}

	// Blockieren des Schedulers für eine Zeitscheibe
	public void schedulerSleep() {
		try {
			Thread.sleep(timeSlice);
		} catch (InterruptedException e) {
			System.out.println("Sorry, not able to sleep right now. gracefully your scheduler");
		}
	}

	// regelmäßiges Ausführen der Scheduling-Aufgabe
	public void run() {
		while (true) {
			System.out.println("Scheduler");
			if (current != null) {
				current.setPriority(MIN_PRIORITY);
			}
			current = queue.getNext();
			System.out.println(current);
			if (current != null) {
				if (!current.isAlive()) {
					current.start();
				}
				current.setPriority(MAX_PRIORITY - 2);
			}
			schedulerSleep();
		}
	}
}