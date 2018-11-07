package club.hicode;

import club.hicode.api.IHelloService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * 服务消费类
 *
 * @author LiuChunfu
 * @date 2018/11/8
 */
@SpringBootApplication
@DubboComponentScan("club.hicode")
public class ConsumerApplication {

    /**
     * Reference表示的服务的引用
     * 如果指明了dubbo协议的url地址，那么就不会从 ZK中进行获取 url = "dubbo://localhost:20990"
     *
     * @Reference(version = "1.0.0", url = "dubbo://192.168.137.1:20990/com.example.HelloService?anyhost=true&application=dubbo-demo-server&bind.ip=192.168.137.1&bind.port=20990&dubbo=2.0.1&generic=false&interface=com.example.HelloService&methods=sayHello&pid=1056&qos.enable=false&revision=1.0.0&side=provider&timestamp=1541600169836&version=1.0.0")
     */
    @Reference(version = "1.0.0")
    private IHelloService demoService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @PostConstruct
    public void init() {
        String sayHello = demoService.sayHello("world");
        System.err.println(sayHello);
    }
}
