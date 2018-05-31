package lsm.study.design.model.singleton;

/**
 * Created by shengmingli on 2018/5/31.
 * 静态内部类单例模式
 */
public class StaticInnerClassSingelton1 {

    private StaticInnerClassSingelton1(){};

    static class Inner{
        //知识点：内部类是在实际使用的时候才出初始化的。
        public static final StaticInnerClassSingelton1 singleton=new StaticInnerClassSingelton1();
    }

    public static StaticInnerClassSingelton1 getSingleton(){
        return Inner.singleton;
    }

}
