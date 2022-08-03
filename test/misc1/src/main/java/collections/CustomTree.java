package collections;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    int size;

    public CustomTree() {
        root = new Entry<>("0");
        size = 0;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;
        int offspring = 0;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(String s) {
        Entry entry = new Entry(s);
        Entry current = root;
        Entry parent = null;
        Queue<Entry> queue = new ArrayDeque<>();
        boolean endOf = false;
        while (!endOf) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                current = queue.poll();

                if (current.availableToAddLeftChildren) {
                    current.leftChild = entry;
                    current.availableToAddLeftChildren = false;
                    endOf = true;
                    break;
                } else if (current.leftChild != null) queue.offer(current.leftChild);

                if (current.availableToAddRightChildren) {
                    current.rightChild = entry;
                    current.availableToAddRightChildren = false;
                    endOf = true;
                    break;
                } else if (current.rightChild != null) queue.offer(current.rightChild);
            }
            if (!endOf) release();
        }
        entry.parent = current;
        System.out.print("add " + entry.elementName);
        while (current != root) {
            current.offspring++;
            System.out.print(" " + current.elementName + "=" + current.offspring + " ");
            current = current.parent;
        }
        System.out.println();
        size++;
        return true;
    }

    public boolean remove(Object o) {
        Entry current = root;
        Entry leftChild;
        Entry rightChild;
        Queue<Entry> queue = new ArrayDeque<>();
        queue.offer(current);
        String elementName;
        if (o instanceof String) elementName = (String) o;
        else throw new UnsupportedOperationException();
        int idx = 0;
        boolean result = false;
        int offsprings = 0;
        while (!queue.isEmpty()) {
            current = queue.poll();
            leftChild = current.leftChild;
            rightChild = current.rightChild;
            if ((leftChild != null) && leftChild.elementName.equals(elementName)) {
                offsprings = leftChild.offspring;
                current.leftChild = null;
                result = true;
                break;
            } else if (leftChild != null) {
                queue.offer(leftChild);
                idx++;
            }

            if ((rightChild != null) && rightChild.elementName.equals(elementName)) {
                offsprings = rightChild.offspring;
                current.rightChild = null;
                result = true;
                break;
            } else if (rightChild != null) {
                queue.offer(rightChild);
                idx++;
            }
        }
        size -= offsprings + 1;
        if (result) {
            System.out.print("remove " + elementName);
            while (current != root) {
                current.offspring -= offsprings + 1;
                System.out.print(" " + current.elementName + "=" + current.offspring + " ");
                current = current.parent;
            }
            System.out.println();
        }
        return result;
    }

    public String getParent(String elementName) {
        Entry current = root;
        Entry leftChild;
        Entry rightChild;
        Queue<Entry> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            leftChild = current.leftChild;
            rightChild = current.rightChild;

            if ((leftChild != null) && leftChild.elementName.equals(elementName)) {
                return leftChild.parent.elementName;
            } else if ((leftChild != null) && !current.isAvailableToAddChildren()) queue.offer(leftChild);

            if ((rightChild != null) && rightChild.elementName.equals(elementName)) {
                return rightChild.parent.elementName;
            } else if ((rightChild != null) && !current.isAvailableToAddChildren()) queue.offer(rightChild);
        }
        return null;
    }

    public void release() {
        Entry current = root;
        Entry leftChild;
        Entry rightChild;
        Queue<Entry> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            leftChild = current.leftChild;
            rightChild = current.rightChild;

            if ((leftChild != null)) {
                queue.offer(leftChild);
                if (leftChild.leftChild == null & leftChild.rightChild == null &
                        !leftChild.isAvailableToAddChildren()) {
                    leftChild.availableToAddLeftChildren = true;
                    leftChild.availableToAddRightChildren = true;
                }
            }

            if ((rightChild != null)) {
                queue.offer(rightChild);
                if (rightChild.leftChild == null & rightChild.rightChild == null
                        & !rightChild.isAvailableToAddChildren()) {
                    rightChild.availableToAddLeftChildren = true;
                    rightChild.availableToAddRightChildren = true;
                }
            }
        }
    }

    public void printAll() {
        Entry current = root;
        Entry leftChild;
        Entry rightChild;
        Queue<Entry> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            leftChild = current.leftChild;
            rightChild = current.rightChild;
            System.out.print("(" + current.elementName + "-");

            if ((leftChild != null)) {
                queue.offer(leftChild);
                System.out.print(leftChild.elementName);
            }

            if ((rightChild != null)) {
                queue.offer(rightChild);
                System.out.print(":" + rightChild.elementName);
            }
            System.out.print(") ");
        }
        System.out.println();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}
