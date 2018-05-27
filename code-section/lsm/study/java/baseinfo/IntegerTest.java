package lsm.study.java.baseinfo;

/**
 * Created by shengmingli on 2018/5/27.
 * 知识点总结：== 基本数据比较的是值，对象类型，比较的是内存地址
 * 1.jdk对Integer做了适当优化，-128到127存储到方法区
 * 2.值比较用equals
 */
public class IntegerTest {
    public static void main(String[] args){
        //1.Integer测试
        Integer i1=1;
        Integer i2=1;
        Integer i3=new Integer(1);
        Integer i4=new Integer(1);
        Integer i5=150;
        Integer i6=150;
        System.out.println(i1==i2);//true
        System.out.println(i1==i3);//false
        System.out.println(i3==i4);//false
        System.out.println(i5==i6);//false
        System.out.println(i1.equals(i3));//true
        System.out.println(i3.equals(i4));//true
        System.out.println(i5.equals(i6));//true
        System.out.println("--------------------");
        //2.String测试
        String s1="1";
        String s2="1";
        String s3=new String("1");
        String s4=new String("1");
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(i3==i4);//false
        System.out.println(s1==s3.intern());//true
        System.out.println(s1.intern()==s3.intern());//true
        System.out.println(s3.intern()==s4.intern());//true
        System.out.println(s1.equals(s2));//true
        System.out.println(s3.equals(s4));//true
        System.out.println("--------------------");
        //2.Boolean测试
        Boolean b1=true;
        Boolean b2=true;
        Boolean b3=new Boolean(true);
        Boolean b4=new Boolean(true);
        System.out.println(b1==b2);//true
        System.out.println(b1==b3);//false
        System.out.println(b3==b4);//false
        System.out.println(b1.equals(b2));//true
        System.out.println(b3.equals(b4));//true
    }
}
