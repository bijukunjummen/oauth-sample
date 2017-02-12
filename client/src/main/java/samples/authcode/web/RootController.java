package samples.authcode.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import samples.authcode.service.DownstreamServiceHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class RootController {

    @Value("${ssoServiceUrl:placeholder}")
    private String ssoServiceUrl;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${security.oauth2.client.clientId:placeholder}")
    private String clientId;

    @Autowired
    private OAuth2ClientContext clientContext;

    @Autowired
    private DownstreamServiceHandler downstreamServiceHandler;

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        model.addAttribute("ssoServiceUrl", ssoServiceUrl);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }



    @RequestMapping("/secured/show_token")
    public String authCode(Model model, HttpServletRequest request) throws Exception {
        OAuth2AccessToken accessToken = clientContext.getAccessToken();

        if (accessToken != null) {
            model.addAttribute("access_token", toPrettyJsonString(parseToken(accessToken.getValue())));
        }
        return "show_token";
    }

    @RequestMapping("/secured/read")
    public String callDownStreamWithReadScope(Model model) {
        String received = this.downstreamServiceHandler.callRead();
        model.addAttribute("received", received);
        return "showvalue";
    }

    @RequestMapping("/secured/write")
    public String callDownStreamWithWriteScope(Model model) {
        String received = this.downstreamServiceHandler.callWrite();
        model.addAttribute("received", received);
        return "showvalue";
    }

    @RequestMapping("/secured/invalid")
    public String callInvalidScope(Model model) {
        String received = this.downstreamServiceHandler.callInvalidScope();
        model.addAttribute("received", received);
        return "showvalue";
    }

    @RequestMapping(value = "/logout", method = GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        URL url = new URL(request.getRequestURL().toString());
        String urlStr = url.getProtocol() + "://" + url.getAuthority();
        return "redirect:" + ssoServiceUrl + "/logout.do?redirect=" + urlStr + "&clientId=" + clientId;
    }

    private Map<String, ?> parseToken(String base64Token) throws IOException {
        String token = base64Token.split("\\.")[1];
        return objectMapper.readValue(Base64.decodeBase64(token), new TypeReference<Map<String, ?>>() {
        });
    }

    private String toPrettyJsonString(Object object) throws Exception {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}
