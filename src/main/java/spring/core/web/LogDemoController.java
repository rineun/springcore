package spring.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.core.common.MyLogger;
import spring.core.logdemo.LogDemoService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
   // private final ObjectProvider<MyLogger> myLoggerProvider;
   private final MyLogger myLogger;


    //http://localhost:9090/log-demo
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){

        System.out.println("myLogger = " + myLogger.getClass());
        //myLogger = class spring.core.common.MyLogger$$EnhancerBySpringCGLIB$$f07cda82
        String requestURL = request.getRequestURL().toString();
       // MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";

    }
}
