package com.mnmlyn.empmanager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.junit.Test;

/**
 * 用Jetty的第一个测试
 *
 * @author mnmlyn
 */
public class JettyFirstTest {

    @Test
    public void testJettyServer() throws Exception {
        // 创建Server
        Server server = new Server(8080);

        // 创建context，一个context是一些Handler的集合
        ContextHandler context = new ContextHandler();
        context.setContextPath("/hello");
        context.setHandler(new HelloHandler());

        // 设置Server的Handler
        // server.setHandler(new HelloHandler());
        server.setHandler(context);

        server.start();
        server.join();
    }

    class HelloHandler extends AbstractHandler {

        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            baseRequest.setHandled(true);
            response.getWriter().println("<h1>Hello Jetty</h1>");
            response.getWriter().println("target=" + target);
        }
    }
}
