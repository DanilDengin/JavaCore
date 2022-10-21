package academy.tochkavhoda.colors.v3;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("Color is not exist"), NULL_COLOR("Color is required");

    private String errorString;

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
