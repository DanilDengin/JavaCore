package academy.tochkavhoda.colors.v3;

public enum Color {
    RED, GREEN, BLUE;

    public static Color colorFromString(String colorString) throws ColorException {
        try {
            return Color.valueOf(colorString);
        } catch (NullPointerException ex) {
            throw new ColorException( ColorErrorCode.NULL_COLOR);
        }
        catch (IllegalArgumentException ex) {
            throw new ColorException( ColorErrorCode.WRONG_COLOR_STRING);
        }
        // REVU не ошибка, но проще было в начале проверить на null
    }

}
