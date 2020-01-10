package top.krasus1966.learning.framework.web.servlet;

import top.krasus1966.learning.framework.web.handler.HandlerManager;
import top.krasus1966.learning.framework.web.handler.MappingHandler;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Krasus1966
 * @date 2019/12/30 20:44
 **/
public class DispatcherServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        for(MappingHandler mappingHandler : HandlerManager.mappingHandlerList){
            try {
                if(mappingHandler.handle(req,res)){
                    return ;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
