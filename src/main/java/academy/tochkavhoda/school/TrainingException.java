package academy.tochkavhoda.school;

import academy.tochkavhoda.colors.v3.ColorErrorCode;

public class TrainingException extends Exception{

    private TrainingErrorCode errorCode;

    TrainingException(TrainingErrorCode errorCode) {
        this.errorCode=errorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }
}
