package lsm.study.design.model.singleton;

/**
 * Created by shengmingli on 2018/5/31.
 * 静态内部类单例模式
 */
public class StaticInnerClassSingelton2 {

    public static Boolean inited=false;

    private StaticInnerClassSingelton2(){
        synchronized (StaticInnerClassSingelton2.class){
            if(!inited){
                inited=true;
            }else{
                throw new RuntimeException("单例已被破坏");
            }
        }
    };

    static class Inner{
        //知识点：内部类是在实际使用的时候才出初始化的。
        public static final StaticInnerClassSingelton2 singleton=new StaticInnerClassSingelton2();
    }

    public static StaticInnerClassSingelton2 getSingleton(){
        return Inner.singleton;
    }

}
