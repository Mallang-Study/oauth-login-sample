package mallang.oauth.domain.client;

import mallang.oauth.domain.OauthMember;
import mallang.oauth.domain.OauthServerType;

public interface OauthMemberClient {

    OauthServerType supportServer();

    OauthMember fetch(String code);
}
