package org.bk.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@SessionAttributes("authorizationRequest")
public class OAuthController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/oauth/confirm_access")
    public String oauthConfirmAccess() {
        return "authorize";
    }

    @RequestMapping({ "/user", "/me" })
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }
}
