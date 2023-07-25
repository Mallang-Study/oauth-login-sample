package mallang.oauth.presentation;

import mallang.oauth.application.OAuthService;
import mallang.oauth.domain.OauthServer;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OAuthLoginController {

    private final OAuthService oauthService;

    @SneakyThrows
    @GetMapping("/{oauthServer}")
    ResponseEntity<Void> redirectAuthorizationCodeIssueUrl(
            @PathVariable OauthServer oauthServer,
            HttpServletResponse response
    ) {
        String redirectUrl = oauthService.getAuthorizationCodeIssueUrl(oauthServer);
        response.sendRedirect(redirectUrl);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @GetMapping("/redirected/{oauthServer}")
    ResponseEntity<Long> login(
            @PathVariable OauthServer oauthServer,
            @RequestParam("code") String code,
            HttpServletResponse response
    ) {
        Long login = oauthService.login(oauthServer, code);
        response.sendRedirect("http://localhost:3000/mallang");
        return ResponseEntity.ok(login);
    }
}
