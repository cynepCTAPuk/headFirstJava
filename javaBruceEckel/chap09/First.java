package chap09;

interface First {
    void first();
}

interface Second extends First {
    void second();
}

interface Third extends First {
    void third();
}

interface Fourth extends Second, Third {
    void fourth();
}

