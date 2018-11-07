package club.hicode.service;

import club.hicode.api.IHelloService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * 服务提供方的实现
 *
 * @author LiuChunfu
 * @date 2018/11/8
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        String template = "今天是:{},{}你好！";
        return StrUtil.format(template, DateUtil.now(), name);
    }
}
