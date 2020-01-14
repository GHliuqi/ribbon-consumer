package com.alan.ribbonconsumer.Service;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author : <a href="mailto:liuqi@ebnew.com">liuqi</a>
 * @version : v1.0
 * @date :  2019-12-25 17:10
 * @description :
 */
public class UserCommand extends HystrixCommand {

    private RestTemplate restTemplate;

    protected UserCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected Object run() throws Exception {
        return restTemplate.getForEntity("http://hearth-stone/1",String.class).getBody();
    }
}
