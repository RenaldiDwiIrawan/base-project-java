package id.base_project.common.exception;

@SuppressWarnings("serial")
public class FailedException extends RuntimeException{
    public FailedException(String message){
        super(message);
    }

}
