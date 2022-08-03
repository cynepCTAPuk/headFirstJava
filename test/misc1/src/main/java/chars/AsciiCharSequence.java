package chars;

public class AsciiCharSequence implements CharSequence {
    private byte[] sequence;

    public AsciiCharSequence(byte[] sequence) {
        this.sequence = sequence;
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] sequence = new byte[end - start];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = this.sequence[start + i];
        }
        return new AsciiCharSequence(sequence);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length(); i++) {
            sb.append(charAt(i));
        }
        return sb.toString();
    }
}
