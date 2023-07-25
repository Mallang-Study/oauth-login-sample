package mallang.oauth.domain.authcode;

import mallang.oauth.domain.OauthServer;

public interface OauthAuthCodeIssueUrlProvider {

    OauthServer supportServer();

    String provide();
}
