package mallang.oauth.domain.authcode;

import static mallang.oauth.exception.AuthExceptionType.UNSUPPORTED_OAUTH_TYPE;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import mallang.oauth.domain.OauthServer;
import mallang.oauth.exception.AuthException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class OauthAuthCodeIssueUrlProviderMapping {

    private final Map<OauthServer, OauthAuthCodeIssueUrlProvider> mapping;

    public OauthAuthCodeIssueUrlProviderMapping(Set<OauthAuthCodeIssueUrlProvider> providers) {
        mapping = providers.stream()
                .collect(toMap(
                        OauthAuthCodeIssueUrlProvider::supportServer,
                        identity()
                ));
    }

    public OauthAuthCodeIssueUrlProvider getProvider(OauthServer oauthServer) {
        return Optional.ofNullable(mapping.get(oauthServer))
                .orElseThrow(() -> new AuthException(UNSUPPORTED_OAUTH_TYPE));
    }
}
