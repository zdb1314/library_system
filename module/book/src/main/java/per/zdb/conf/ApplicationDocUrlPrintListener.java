package per.zdb.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ApplicationDocUrlPrintListener implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${server.port}")
    private int port;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println("在线文档地址:  http://"+ip+":"+port+"/swagger-ui.html");
    }

}
