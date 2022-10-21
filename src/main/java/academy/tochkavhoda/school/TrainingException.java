package academy.tochkavhoda.school;

public class TrainingException extends Exception {

    private TrainingErrorCode errorCode;

    TrainingException(TrainingErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }
}
