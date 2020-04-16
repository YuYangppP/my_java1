package mingling.remote;

import mingling.Command;

public class NoCommand implements Command {
	public void execute() { }

	@Override
	public void undo() {

	}
}
