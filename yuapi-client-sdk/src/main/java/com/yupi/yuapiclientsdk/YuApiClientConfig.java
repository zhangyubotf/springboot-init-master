package com.yupi.yuapiclientsdk;


import com.yupi.yuapiclientsdk.client.YUApi;
import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("yupi.client")
@Data
@ComponentScan
public class YuApiClientConfig {
    String assessKey;
    String secreteKey;


    @Bean
    public YUApi yuApi(){
        return new YUApi(assessKey,secreteKey);
    }

}
