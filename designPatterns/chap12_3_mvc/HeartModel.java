package chap12_3_mvc;

import java.util.ArrayList;
import java.util.Random;

public class HeartModel implements HeartModelInterface, Runnable {
	Thread thread;
	ArrayList<BeatObserver> beatObservers = new ArrayList<>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<>();
	int bpm = 90;
	int time = 1_000;
	Random random = new Random(System.currentTimeMillis());

	public HeartModel() {
		thread = new Thread(this);
		thread.start();
	}
	public void run() {
		int lastrate = -1;

		while (true) {
			int change = random.nextInt(10);
			if (random.nextInt(2) == 0) change = 0 - change;
			int rate = 60_000/(time + change);
			if (rate < 120 && rate > 50) {
				time += change;
				notifyBeatObservers();
				if (rate != lastrate) {
					lastrate = rate;
					notifyBPMObservers();
				}
			}
			try {
				Thread.sleep(time);
			} catch (Exception e) {}
		}
	}
	public int getHeartRate() {
		return 60_000/time;
	}
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) beatObservers.remove(i);
	}
	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = beatObservers.get(i);
			observer.updateBeat();
		}
	}
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) bpmObservers.remove(i);
	}
	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = bpmObservers.get(i);
			observer.updateBPM();
		}
	}
}
