package chap09.music;

interface Instrument {
    // Compile-time constant:
    int VALUE = 5; // static & final
    void play(Note n);
    default String what() { return "Instrument"; }
    void adjust(); // Automatically public
}