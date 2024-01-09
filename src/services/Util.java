package services;

public class Util {
    public static <E extends Enum<E>> E safeValueOf(Class<E> enumClass, String value) {
        try {
            return Enum.valueOf(enumClass, value);
        } catch (IllegalArgumentException | NullPointerException e) {
            return null;
        }
    }
}
