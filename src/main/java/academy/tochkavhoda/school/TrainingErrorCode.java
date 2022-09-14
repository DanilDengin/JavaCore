package academy.tochkavhoda.school;

public enum TrainingErrorCode {
    TRAINEE_WRONG_LASTNAME("Lastname is incorrect."),
    TRAINEE_WRONG_FIRSTNAME("Firstname is incorrect."),
    TRAINEE_WRONG_RATING("Mark must be between 1 and 5."),
    GROUP_WRONG_NAME("Name is incorrect."),
    TRAINEE_NOT_FOUND("Trainee not found."),
    GROUP_WRONG_ROOM("Group name is incorrect."),
    EMPTY_TRAINEE_QUEUE("Queue is empty"),
    SCHOOL_WRONG_NAME("School is incorrect."),
    DUPLICATE_GROUP_NAME("It's duplicate group"),
    GROUP_NOT_FOUND("Group didn't find"),
    DUPLICATE_TRAINEE("Trainee is already installed");

    private String errorCode;

    TrainingErrorCode(String errorCode){
        this.errorCode=errorCode;
    }

    public String getErrorMessage(){
        return errorCode;
    }
}
