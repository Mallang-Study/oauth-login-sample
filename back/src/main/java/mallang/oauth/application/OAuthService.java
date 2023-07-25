package mallang.oauth.application;

import mallang.oauth.domain.OauthMember;
import mallang.oauth.domain.OauthMemberRepository;
import mallang.oauth.domain.OauthServer;
import mallang.oauth.domain.authcode.OauthAuthCodeIssueUrlProvider;
import mallang.oauth.domain.authcode.OauthAuthCodeIssueUrlProviderMapping;
import mallang.oauth.domain.client.OauthMemberClient;
import mallang.oauth.domain.client.OauthMemberClientMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final OauthAuthCodeIssueUrlProviderMapping oauthAuthCodeIssueUrlProviderMapping;
    private final OauthMemberClientMapping oauthMemberClientMapping;
    private final OauthMemberRepository oauthMemberRepository;

    public String getAuthorizationCodeIssueUrl(OauthServer oauthServer) {
        OauthAuthCodeIssueUrlProvider provider =
                oauthAuthCodeIssueUrlProviderMapping.getProvider(oauthServer);
        return provider.provide();
    }

    public Long login(OauthServer oauthServer, String code) {
        OauthMemberClient oauthMemberClient = oauthMemberClientMapping.getClient(oauthServer);
        OauthMember oauthMember = oauthMemberClient.fetch(code);
        oauthMemberRepository.findByOauthId(oauthMember.oauthId())
                .orElseGet(() -> oauthMemberRepository.save(oauthMember));
        return oauthMember.id();
    }
}
