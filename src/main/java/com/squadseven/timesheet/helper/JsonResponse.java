package com.squadseven.timesheet.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> JsonResponse<T> success(String message, T data) {
        return new JsonResponse<>(true, message, data);
    }

    public static <T> JsonResponse<T> error(String message) {
        return new JsonResponse<>(false, message, null);
    }
}
