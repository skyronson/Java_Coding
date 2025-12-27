package org.kniit.lab9.task17;

import java.lang.reflect.Field;

public class Validator {

    public static void validate(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder errors = new StringBuilder();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);

                // @NotNull
                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    errors.append("Поле ").append(field.getName()).append(" не должно быть null.\n");
                }

                // @MaxLength (только для String)
                if (field.isAnnotationPresent(MaxLength.class)) {
                    if (value instanceof String str) {
                        int maxLength = field.getAnnotation(MaxLength.class).value();
                        if (str.length() > maxLength) {
                            errors.append("Поле ").append(field.getName())
                                  .append(" превышает максимальную длину ").append(maxLength).append(".\n");
                        }
                    }
                }

                // @Min (только для числовых типов, поддерживаем int)
                if (field.isAnnotationPresent(Min.class)) {
                    if (value instanceof Integer intValue) {
                        int minValue = field.getAnnotation(Min.class).value();
                        if (intValue < minValue) {
                            errors.append("Поле ").append(field.getName())
                                  .append(" должно быть не меньше ").append(minValue).append(".\n");
                        }
                    }
                }

                // @Range (только для int)
                if (field.isAnnotationPresent(Range.class)) {
                    if (value instanceof Integer intValue) {
                        Range range = field.getAnnotation(Range.class);
                        if (intValue < range.min() || intValue > range.max()) {
                            errors.append("Поле ").append(field.getName())
                                  .append(" должно быть в диапазоне от ").append(range.min())
                                  .append(" до ").append(range.max()).append(".\n");
                        }
                    }
                }

            } catch (IllegalAccessException e) {
                throw new ValidationException("Ошибка доступа к полю: " + field.getName());
            }
        }

        if (errors.length() > 0) {
            throw new ValidationException(errors.toString().trim());
        }
    }
}
