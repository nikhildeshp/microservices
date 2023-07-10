package com.microservices.example.UserMicroservicedemo.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.actuate.autoconfigure.info.ConditionalOnEnabledInfoContributor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FeignClientInterceptor implements RequestInterceptor {


    private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;



    @Override
    public void apply(RequestTemplate requestTemplate) {
        //with the help requestTepmplate we can access the header


        //inside withCLientRegistrationId we give the internal-cleint
       String token= oAuth2AuthorizedClientManager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build()).getAccessToken().getTokenValue();
        requestTemplate.header("authorization","bearer"+token);
        //we need to get the token ,we can get the token from Oath2AuthorizedCLientManager
    }
}
