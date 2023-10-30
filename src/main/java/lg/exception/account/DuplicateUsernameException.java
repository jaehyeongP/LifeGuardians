package lg.exception.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DuplicateUsernameException extends RuntimeException{
    private String errorCode;
    private String message;

    public DuplicateUsernameException() {
        errorCode = "duplicate.username";
        message = "아이디가 중복되었습니다";
    }

}
