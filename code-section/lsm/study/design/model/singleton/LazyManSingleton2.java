package lsm.study.design.model.singleton;

/**
 * Created by shengmingli on 2018/5/31.
 * @Description 懒汉模式2
 */
public class LazyManSingleton2 {
    private static LazyManSingleton2 singleton=null;

    private LazyManSingleton2(){}

    public static LazyManSingleton2 getSingleton(){
        if(singleton==null){
            synchronized (LazyManSingleton2.class){
                if(singleton==null){
                    singleton=new LazyManSingleton2();
                }
            }
        }
        return singleton;
    }
}
