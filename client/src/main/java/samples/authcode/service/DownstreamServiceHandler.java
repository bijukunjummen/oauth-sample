package samples.authcode.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

public class DownstreamServiceHandler {

    private final OAuth2RestTemplate oAuth2RestTemplate;
    private final String resourceUrl;


    public DownstreamServiceHandler(OAuth2RestTemplate oAuth2RestTemplate, String resourceUrl) {
        this.oAuth2RestTemplate = oAuth2RestTemplate;
        this.resourceUrl = resourceUrl;
    }


    public String callRead() {
        ResponseEntity<String> responseEntity =
                this.oAuth2RestTemplate.getForEntity(String.format("%s/secured/read", resourceUrl), String.class);

        return responseEntity.getBody();

    }

    public String callWrite() {
        ResponseEntity<String> responseEntity =
                this.oAuth2RestTemplate.getForEntity(String.format("%s/secured/write", resourceUrl), String.class);

        return responseEntity.getBody();

    }

    public String callInvalidScope() {
        ResponseEntity<String> responseEntity =
                this.oAuth2RestTemplate.getForEntity(String.format("%s/secured/invalid", resourceUrl), String.class);

        return responseEntity.getBody();
    }
}
