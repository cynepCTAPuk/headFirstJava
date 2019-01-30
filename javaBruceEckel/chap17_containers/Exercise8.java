package chap17_containers;
class SList<T> {
    Link<T> firstLink = new Link<>(null);
    public SListIterator<T> iterator() { return new SListIterator<T>(firstLink); }
    public String toString() {
        if(firstLink == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        SListIterator<T> slit = this.iterator();
        while(slit.hasNext()) { sb.append(slit.next() + (slit.hasNext() ? ", " : "")); }
        return sb + "]";
    }
}
class Link<T> {
    T t;
    Link<T> next;
    Link(T t) { this(t, null); }
    Link(T t, Link<T> next) { this.t = t; this.next = next; }
    public String toString() { if (t == null) return "null"; return t.toString(); }
}
class SListIterator<T> {
    Link<T> current;
    SListIterator(Link<T> link) { current = link; }
    public void add(T t) { current.next = new Link<T>(t, current.next); }
    public Link<T> next() { current = current.next; return current; }
    public boolean hasNext() { return (current.next != null); }
    public void remove() { if(current.next != null) current.next = current.next.next; }
}

public class Exercise8 {
    public static void main(String[] args) {
        SList<Integer> sList = new SList<>();
        SListIterator<Integer> sListIterator = sList.iterator();
        for (int i = 0; i < 10 ; i++) sListIterator.add(i);
        System.out.println(sList);

        while (sListIterator.hasNext()) System.out.print(sListIterator.next() + " ");

        System.out.println();
        SList<Exercise8> exSList = new SList<>();
        SListIterator<Exercise8> sListIterator1 = exSList.iterator();
        sListIterator1.add(new Exercise8());
        sListIterator1.add(new Exercise8());
        sListIterator1.add(new Exercise8());
        System.out.println(exSList);
    }
}