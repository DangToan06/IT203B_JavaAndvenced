package b5;

import b3.Command;

public class Light implements Command {
    @Override
    public void execute() {
        System.out.println("Light off");
    }

    @Override
    public void undo() {
        System.out.println("Light on");
    }
}
