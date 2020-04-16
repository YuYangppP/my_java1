package mingling.simpleremote;

import mingling.Command;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName SimpleRemoteControl.java
 * @Description TODO
 * @Date 2020/2/24 17:40
 */
public class SimpleRemoteControl {
    Command slot;
    public SimpleRemoteControl(){}
    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
