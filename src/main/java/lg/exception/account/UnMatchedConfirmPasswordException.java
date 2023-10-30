package lg.exception.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class UnMatchedConfirmPasswordException extends RuntimeException{
    private String errorCode;
    private String message;

    public UnMatchedConfirmPasswordException() {
        this.errorCode = "unMatched.confirmPassword";
        this.message = "비밀번호 확인이 일치하지 않습니다";
    }
}
