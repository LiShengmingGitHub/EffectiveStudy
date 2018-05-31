package lsm.study.design.model.singleton;

import java.lang.reflect.Constructor;

/**
 * Created by shengmingli on 2018/5/31.
 * @Description 懒汉模式2
 */
public class StaticInnerClassSingelton1Test {
    public static void main(String[] args) {
        StaticInnerClassSingelton1 instance1=StaticInnerClassSingelton1.getSingleton();
        //通过反射初始化
        StaticInnerClassSingelton1 instance2=null;
        try{
            Class<StaticInnerClassSingelton1> clazz=StaticInnerClassSingelton1.class;
            Constructor<StaticInnerClassSingelton1> cons=clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance2=cons.newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }
        //检查两个实例的hash值
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        System.out.println("Instance 2 hash:" + instance2.hashCode());
    }
}
