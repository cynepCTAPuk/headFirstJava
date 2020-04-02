package cashMachine.task2613.command;

import cashMachine.task2613.exception.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException, InterruptOperationException;
}
