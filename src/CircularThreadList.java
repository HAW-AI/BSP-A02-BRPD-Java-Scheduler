import java.util.ArrayList;
import java.util.List;

public class CircularThreadList {
	private List<Thread> threads;
	private int index = 0;
	
	// Konstruktor
	public CircularThreadList() {
		this.threads = new ArrayList<Thread>();
	}

	// liefert das nŠchste Thread-Objekt in der Warteschlange
	// oder null, falls die Warteschlange leer ist
	// (Nachfolger des letzten Thread-Objekts ist das erste
	// Objekt)
	public Thread getNext() {
		index++;
		System.out.println(String.format("%s/%s", index, threads.size()));
		if (index >= threads.size()) {
			index = 0;
		}
		
		return this.threads.get(index);
	}

	// FŸgt das Ÿbergebene Thread-Objekt an das Ende der
	// Warteschlange an
	public void addItem(Thread thread) {
		this.threads.add(thread);
	}
}
