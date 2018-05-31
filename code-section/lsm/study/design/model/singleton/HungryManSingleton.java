package lsm.study.design.model.singleton;

/**
 * Created by shengmingli on 2018/5/31.
 * @Description 饿汉模式1
 */
public class HungryManSingleton {
    private static HungryManSingleton singleton=new HungryManSingleton();

    private HungryManSingleton(){}

    public static HungryManSingleton getSingleton(){
        return singleton;
    }
}
