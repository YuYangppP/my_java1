package mingling.remote;

import mingling.Command;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName LightOnCommand.java
 * @Description TODO
 * @Date 2020/2/24 16:26
 */
public class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
