package storage;

public class LinkedBox implements IBox {
    private LinkNode head, tail;
    private int size;

    public LinkedBox() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(String item) {
        LinkNode node = new LinkNode(item);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > size()) throw new ArrayIndexOutOfBoundsException();
        LinkNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getItem();
    }

    @Override
    public boolean has(String item) {
        LinkNode node = head;
        while (node !=null){
            if(item.equals(node.getItem())) return true;
            node = node.getNext();
        }
        return false;
    }
}

class LinkNode {
    private String item;
    private LinkNode next;

    public LinkNode(String item) {
        this.item = item;
    }

    public LinkNode(String item, LinkNode next) {
        this.item = item;
        this.next = next;
    }

    public String getItem() {
        return item;
    }

    LinkNode getNext() {
        return next;
    }

    void setNext(LinkNode next) {
        this.next = next;
    }
}
