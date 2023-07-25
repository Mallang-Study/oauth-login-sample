package mallang.oauth.domain;

import static mallang.oauth.exception.AuthExceptionType.UNSUPPORTED_OAUTH_TYPE;
import static java.util.Arrays.stream;
import static java.util.Locale.ENGLISH;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import mallang.oauth.exception.AuthException;
import java.util.Map;
import java.util.Optional;

public enum OauthServer {

    KAKAO,
    ;

    private static final Map<String, OauthServer> typeMap;

    static {
        typeMap = stream(values())
                .collect(toMap(
                        it -> it.name().toLowerCase(ENGLISH),
                        identity()
                ));
    }

    public static OauthServer fromName(String type) {
        return Optional.ofNullable(typeMap.get(type.toLowerCase(ENGLISH)))
                .orElseThrow(() -> new AuthException(UNSUPPORTED_OAUTH_TYPE));
    }
}
