package lg.exception.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FormValidationException extends RuntimeException {
    private String errorCode;
    private String message;

    public FormValidationException() {
        this.errorCode = "form.validate";
        this.message = "입력값이 잘못 되었습니다.";
    }
}
