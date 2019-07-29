package ru.otus.l161.app;

import ru.otus.l161.channel.Blocks;

import java.io.IOException;

public interface MsgWorker {
    void send(Msg msg);

    Msg pool();

    @Blocks
    Msg take() throws InterruptedException;

    void close() throws IOException;
}
