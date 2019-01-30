package chap17_containers;
class SList<T> {
    Link<T> firstLink = new Link<T>(null);
    public SListIterator<T> iterator() { return new SListIterator<T>(firstLink); }
    public String toString() {
        if(firstLink == null) return "[]";
        SListIterator<T> slit = this.iterator();
        StringBuilder sb = new StringBuilder("[");
        while(slit.hasNext()) { sb.append(slit.next() + (slit.hasNext() ? ", " : "")); }
        return sb + "]";
    }
}
class Link<T> {
    T t;
    Link<T> next;
    Link(T t) { this(t, null); }
    Link(T t, Link<T> next) {
        this.t = t;
        this.next = next;
    }
    public String toString() {
        if (t == null) return "null";
        return t.toString();
    }
}
class SListIterator<T> {
    Link<T> current;
    SListIterator(Link<T> link) { current = link; }
    public Link<T> next() {
        current = current.next;
        return current;
    }
    public boolean hasNext() { return (current.next != null); }
    public void add(T t) { current.next = new Link<T>(t, current.next); }
    public void remove() { if(current.next != null) current.next = current.next.next; }
}

public class Exercise8 {

}