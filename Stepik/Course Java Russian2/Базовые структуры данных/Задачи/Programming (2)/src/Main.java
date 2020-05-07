import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int n = scanner.nextInt();
        Deque<Packet> in = new ArrayDeque<>();
        Deque<Packet> buffer = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) in.addLast(new Packet(scanner.nextInt(), scanner.nextInt()));

        int timeCurrent = 0;
        while (!in.isEmpty() || !buffer.isEmpty()) {
            if (in.isEmpty()) break;
            Packet packet = in.removeFirst();
            if (buffer.size() < size) {
                buffer.addLast(packet);

                timeCurrent = Math.max(timeCurrent, packet.timeIn);
                packet.finish = timeCurrent + packet.duration;
                list.add(timeCurrent);
                timeCurrent += packet.duration;

            } else {
                Packet first = buffer.peekFirst();
                if (packet.timeIn < first.finish) {
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
        for (int i : list) System.out.println(i);
    }

    private static class Packet {
        int timeIn;
        int duration;
        int finish;

        public Packet(int timeIn, int duration) {
            this.timeIn = timeIn;
            this.duration = duration;
        }
    }
}
