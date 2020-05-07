package algorithms.stepik2;

import java.util.*;

/**
 * Stepik Algorithm2: Симуляция обработки сетевых пакетов<p>
 * Вход: Размер буфера size и число пакетов n, а так-же две последовательности
 * arrival<sub>2</sub>, ..., arrival<sub>n</sub> и duration<sub>1</sub>, ..., duration<sub>n</sub>,
 * обозначающих время поступления и длительность обработки n пакетов.<p>
 * Выход: Для каждого из данных n пакетов необходимо вывести время начала его обработки или -1, если
 * пакет не был обработан (это происходит в случае, когда пакет поступает в момент, когда в буфере
 * компьютера уже находится size пакетов).
 * Sample Input 1:<p>
 * 1 0<p>
 * Sample Output 1:<p>
 * <p>
 * Sample Input 2:<p>
 * 1 1<p>
 * 0 0<p>
 * Sample Output 2:<p>
 * 0<p>
 * Sample Input 3:<p>
 * 1 1<p>
 * 0 1<p>
 * Sample Output 3:<p>
 * 0
 */
public class Test123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int n = scanner.nextInt();
        Deque<Packet> in = new ArrayDeque<>();
        Deque<Packet> buffer = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            in.addLast(new Packet(scanner.nextInt(), scanner.nextInt()));

        int timeCurrent = 0;
        while (!in.isEmpty()) {
            Packet packet = in.removeFirst();
            if (buffer.size() < size) {

                buffer.addLast(packet);
                timeCurrent = Math.max(timeCurrent, packet.timeIn);
                packet.finish = timeCurrent + packet.duration;
                list.add(timeCurrent);
                timeCurrent += packet.duration;

            } else {
                if (packet.timeIn < buffer.peekFirst().finish) {
                    list.add(-1);
                } else {
                    buffer.removeFirst();

                    buffer.addLast(packet);
                    timeCurrent = Math.max(timeCurrent, packet.timeIn);
                    packet.finish = timeCurrent + packet.duration;
                    list.add(timeCurrent);
                    timeCurrent += packet.duration;
                }
            }
        }
        System.out.println(list);
    }

    private static class Packet {
        int timeIn;
        int duration;
        int finish;

        public Packet(int timeIn, int duration) {
            this.timeIn = timeIn;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "Packet{" + "timeIn=" + timeIn + ", duration=" + duration + '}';
        }
    }

}
