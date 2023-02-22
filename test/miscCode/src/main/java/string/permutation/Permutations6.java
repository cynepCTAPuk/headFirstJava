package string.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations6 {

	public static void collect(Set<List<Advertisement>> set, List<Advertisement> list) {
		if (list.size() == 0) return;
		set.add(list);
		for (Advertisement s : list) {
			List<Advertisement> copy = new ArrayList<>(list);
			copy.remove(s);
			collect(set, copy);
		}
	}

	public static void main(String[] args) {
		AdvertisementStorage storage = AdvertisementStorage.getInstance();
		Set<List<Advertisement>> set = new HashSet();
		List<Advertisement> list = storage.list();
		System.out.println(list);
		collect(set, list);
		System.out.println(set);
		System.out.println("------");
		set.stream().forEach(System.out::println);
//        for (List<String> l : set) System.out.println(l);
	}
}

class Advertisement {
	private Object content;
	private String name;
	private long initialAmount;
	private int hits;
	int duration;

	private long amountPerOneDisplaying;

	public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
		this.content = content;
		this.name = name;
		this.initialAmount = initialAmount;
		this.hits = hits;
		this.duration = duration;

		amountPerOneDisplaying = initialAmount / hits;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public long getAmountPerOneDisplaying() {
		return amountPerOneDisplaying;
	}

	public void revalidate() {
		if (!(hits > 0)) throw new UnsupportedOperationException();
		else hits--;
	}
}

class AdvertisementStorage {
	private static final AdvertisementStorage INSTANCE = new AdvertisementStorage();
	private final List<Advertisement> videos = new ArrayList<>();

	private AdvertisementStorage() {
		java.lang.Object someContent = new java.lang.Object();
		videos.add(new Advertisement(someContent, "First Video",
				5000, 100, 3 * 60)); // 3 min
		videos.add(new Advertisement(someContent, "Second Video",
				100, 10, 15 * 60)); //15 min
		videos.add(new Advertisement(someContent, "Third Video",
				400, 2, 10 * 60)); //10 min
	}

	public List<Advertisement> list() {
		return videos;
	}

	public void add(Advertisement advertisement) {
		videos.add(advertisement);
	}

	public static AdvertisementStorage getInstance() {
		return INSTANCE;
	}
}