package mingling.remote;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Light.java
 * @Description TODO
 * @Date 2020/2/24 16:08
 */
public class Light {
    String location = "";
    public Light(String location){
        this.location = location;
    }
    public void on(){
        System.out.println(location+" light is on");
    }

    public void off(){
        System.out.println(location+" light is on");
    }
}
