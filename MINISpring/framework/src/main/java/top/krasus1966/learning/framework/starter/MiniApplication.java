package top.krasus1966.learning.framework.starter;

import top.krasus1966.learning.framework.beans.BeanFactory;
import top.krasus1966.learning.framework.core.ClassScanner;
import top.krasus1966.learning.framework.web.handler.HandlerManager;
import top.krasus1966.learning.framework.web.server.TomcatServer;

import java.util.List;

/**
 * @author Krasus1966
 * @date 2019/12/30 20:07
 **/
public class MiniApplication {
    public static void run(Class<?> cls,String[] args){
        System.out.println("Hello mini-spring");
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
            List<Class<?>> classList = ClassScanner.scanClasses(cls.getPackage().getName());
            HandlerManager.resolveMappingHandler(classList);
            classList.forEach(it-> System.out.println(it.getName()));
            BeanFactory.initBean(classList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
