package org.bk.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

@Configuration
@EnableAuthorizationServer
@Order(2)
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthorizationServerConfiguration() {
        super();
    }


    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("authserver.jks"), "authserver".toCharArray())
                .getKeyPair("authserver", "authserver".toCharArray());
        jwtAccessTokenConverter.setKeyPair(keyPair);
        return jwtAccessTokenConverter;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .authorizationCodeServices(authCodeServices())
                .authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter());
    }

    @Bean
    public AuthorizationCodeServices authCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess(
                "isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //@formatter:off
        clients.inMemory()
                    .withClient("live-test")
                        .secret("live-test-pwd")
                        .authorizedGrantTypes("client_credentials", "refresh_token")
                        .scopes("read", "write")
                        .autoApprove("read", "write")
                        .accessTokenValiditySeconds(3600)
                .and()
                    .withClient("live-test-pass")
                        .secret("live-test-pass")
                        .authorizedGrantTypes("password", "refresh_token")
                        .scopes("resource.read").autoApprove("resource.read")
                .accessTokenValiditySeconds(3600)
                .and()
                    .withClient("live-test-auth")
                        .secret("live-test-auth")
                        .authorizedGrantTypes("authorization_code", "refresh_token")
                        .scopes("resource.read", "openid").autoApprove("resource.read", "openid")
                .accessTokenValiditySeconds(3600);
        //@formatter:on
    }
}
