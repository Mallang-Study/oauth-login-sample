package mallang.oauth.exception;

import lombok.RequiredArgsConstructor;
import mallang.oauth.common.exception.BaseException;
import mallang.oauth.common.exception.BaseExceptionType;

@RequiredArgsConstructor
public class AuthException extends BaseException {

    private final AuthExceptionType exceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}
