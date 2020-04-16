package mingling.remote;

import mingling.Command;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName LightOffCommand.java
 * @Description TODO
 * @Date 2020/2/24 17:38
 */
public class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
