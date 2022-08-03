package patterns.iterator.task3701;
/**
 * https://javarush.ru/quests/lectures/questcollections.level07.lecture04
 */

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator implements Iterator<T> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        public RoundIterator() {
        }

        public boolean hasNext() {
//            return cursor != size;
            return Solution.this.size() > 0;
        }

        @Override
//        @SuppressWarnings("unchecked")
        public T next() {
            checkForComodification();
            int i = cursor;
//            if (i >= size) throw new NoSuchElementException();
            if (i >= Solution.this.size()) i = 0;
//            Object[] elementData = ArrayList.this.elementData;
            Object[] elementData = Solution.this.toArray();
//            if (i >= elementData.length) throw new ConcurrentModificationException();
            if (i >= elementData.length) i = 0;
            cursor = i + 1;
            return (T) elementData[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0) throw new IllegalStateException();
            checkForComodification();
            try {
//                ArrayList.this.remove(lastRet);
                Solution.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
//        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super T> consumer) {
            Objects.requireNonNull(consumer);
//            final int size = ArrayList.this.size;
            final int size = Solution.this.size();
            int i = cursor;
            if (i >= size) return;
            final Object[] elementData = Solution.this.toArray();
            if (i >= elementData.length) throw new ConcurrentModificationException();
            while (i != size && modCount == expectedModCount) {
                consumer.accept((T) elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) throw new ConcurrentModificationException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }
}
