package spring.core.logdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import spring.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    // @Scope(value = "request")
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    // @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    private final MyLogger myLogger;

    public void logic(String id) {
       // MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }

}
