package mallang.oauth.domain.client;

import mallang.oauth.domain.OauthMember;
import mallang.oauth.domain.OauthServer;

public interface OauthMemberClient {

    OauthServer supportServer();

    OauthMember fetch(String code);
}
