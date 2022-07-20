package africa.semicolon.cms.exceptions;

public class UserExistException extends RuntimeException{
    public UserExistException() {
        super();
    }

    public UserExistException(String message) {
        super(message);
    }

   public UserExistException(Throwable err) {
        super(err);
    }

    public UserExistException(String message, Throwable err) {
        super(message, err);
    }

}
