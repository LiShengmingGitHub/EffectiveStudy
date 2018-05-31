package lsm.study.design.model.singleton;

/**
 * Created by shengmingli on 2018/5/31.
 * @Description 懒汉模式1
 */
public class LazyManSingleton1 {
    public static LazyManSingleton1 singleton=null;

    private LazyManSingleton1(){}

    public synchronized static LazyManSingleton1 getSingleton(){
        if(singleton==null){
            singleton=new LazyManSingleton1();
        }
        return singleton;
    }
}
