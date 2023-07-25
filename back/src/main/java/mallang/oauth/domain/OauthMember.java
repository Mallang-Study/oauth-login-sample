package mallang.oauth.domain;

import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import mallang.oauth.common.domain.BaseEntity;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Table(name = "oauth_member",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "oauth_id_unique",
                        columnNames = {
                                "oauth_server_id",
                                "oauth_server"
                        }
                ),
        }
)
public class OauthMember extends BaseEntity {

    @Embedded
    private OauthId oauthId;
    private String nickname;
    private String profileImagePath;

    public OauthId oauthId() {
        return oauthId;
    }

    public String nickname() {
        return nickname;
    }

    public String profileImagePath() {
        return profileImagePath;
    }

    @Override
    public String toString() {
        return "OauthMember{" +
               "oauthId=" + oauthId +
               ", nickname='" + nickname + '\'' +
               ", profileImagePath='" + profileImagePath + '\'' +
               '}';
    }
}