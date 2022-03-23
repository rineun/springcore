package spring.core.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeProviderTest {

    @Scope("prototype")
    static class PrototypeBean{
        private int count =0;
        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init"+ this);
        }

        @PreDestroy
        public void destory(){
            System.out.println("PrototypeBean.destory");
        }
    }

    static class ClientBean{
        @Autowired
        private ApplicationContext ac;

        public int logic(){
            PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }
}
