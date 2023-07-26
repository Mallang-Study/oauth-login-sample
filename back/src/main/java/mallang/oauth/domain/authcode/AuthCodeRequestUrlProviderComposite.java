package mallang.oauth.domain.authcode;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static mallang.oauth.exception.AuthExceptionType.UNSUPPORTED_OAUTH_TYPE;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import mallang.oauth.domain.OauthServerType;
import mallang.oauth.exception.AuthException;
import org.springframework.stereotype.Component;

@Component
public class AuthCodeRequestUrlProviderComposite {

    private final Map<OauthServerType, AuthCodeRequestUrlProvider> mapping;

    public AuthCodeRequestUrlProviderComposite(Set<AuthCodeRequestUrlProvider> providers) {
        mapping = providers.stream()
                .collect(toMap(
                        AuthCodeRequestUrlProvider::supportServer,
                        identity()
                ));
    }

    public String provide(OauthServerType oauthServerType) {
        return getProvider(oauthServerType).provide();
    }

    public AuthCodeRequestUrlProvider getProvider(OauthServerType oauthServerType) {
        return Optional.ofNullable(mapping.get(oauthServerType))
                .orElseThrow(() -> new AuthException(UNSUPPORTED_OAUTH_TYPE));
    }
}
