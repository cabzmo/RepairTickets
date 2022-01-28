package commands;

import model.Central;

public interface Command {

    public void execute(Central central);
}
