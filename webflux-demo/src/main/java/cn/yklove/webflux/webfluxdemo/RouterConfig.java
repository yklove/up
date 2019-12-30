package cn.yklove.webflux.webfluxdemo;

import cn.yklove.webflux.webfluxdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.*;


/**
 * @author qinggeng
 * @date 2019/12/28
 */
@Configuration
public class RouterConfig {

    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return RouterFunctions.route(RequestPredicates.GET("/time"), timeHandler::getTime)
                .andRoute(RequestPredicates.GET("/date"), timeHandler::getDate)  // 这种方式相对于上一行更加简洁
                .andRoute(RequestPredicates.GET("times"), timeHandler::sendTimePerSec);
    }
}