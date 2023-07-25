package mallang.oauth.presentation;

import mallang.oauth.domain.OauthServer;
import org.springframework.core.convert.converter.Converter;

public class OauthServerConverter implements Converter<String, OauthServer> {

    @Override
    public OauthServer convert(String source) {
        return OauthServer.fromName(source);
    }
}
