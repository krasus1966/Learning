package top.krasus1966.learning.application;

import top.krasus1966.learning.framework.starter.MiniApplication;

/**
 * @author Krasus1966
 * @date 2019/12/30 19:55
 **/
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        MiniApplication.run(Application.class,args);
    }
}
