package mallang.oauth.domain.client;

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
public class OauthMemberClientMapping {

    private final Map<OauthServer, OauthMemberClient> mapping;

    public OauthMemberClientMapping(Set<OauthMemberClient> clients) {
        mapping = clients.stream()
                .collect(toMap(
                        OauthMemberClient::supportServer,
                        identity()
                ));
    }

    public OauthMemberClient getClient(OauthServer oauthServer) {
        return Optional.ofNullable(mapping.get(oauthServer))
                .orElseThrow(() -> new AuthException(UNSUPPORTED_OAUTH_TYPE));
    }
}
