package chap09.music;

interface Playable {
    // Compile-time constant:
    int VALUE = 5; // static & final
    void play(Note n);
    void adjust(); // Automatically public
}