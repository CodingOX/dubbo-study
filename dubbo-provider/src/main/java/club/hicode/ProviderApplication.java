package club.hicode;

import club.hicode.embed.EmbeddedZooKeeper;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * XXXX
 *
 * @author LiuChunfu
 * @date 2018/11/8
 */
@SpringBootApplication
@DubboComponentScan("club.hicode")
public class ProviderApplication {

    /**
     * 启动类
     *
     * @param args
     */
    public static void main(String[] args) {
        // start embedded zookeeper server
        new EmbeddedZooKeeper(2181, false).start();
        SpringApplication.run(ProviderApplication.class, args);
    }
}
