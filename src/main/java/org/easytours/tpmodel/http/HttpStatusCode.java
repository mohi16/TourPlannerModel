package org.easytours.tpmodel.http;

import lombok.Getter;

@Getter
public enum HttpStatusCode {
    OK(200, "OK"),
    CREATED(201, "CREATED"),
    BAD_REQUEST(400, "BAD REQUEST"),
    NOT_FOUND(404, "NOT FOUND ERROR ERROR HELP"),
    NOT_ALLOWED(405, "METHOD NOT ALLOWED"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR");


    public final int code;

    public final String message;

    HttpStatusCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public static HttpStatusCode valueOf(int code) {
        return switch (code) {
            case 200 -> OK;
            case 201 -> CREATED;
            case 400 -> BAD_REQUEST;
            case 404 -> NOT_FOUND;
            case 405 -> NOT_ALLOWED;
            case 500 -> INTERNAL_SERVER_ERROR;
            default -> throw new IllegalArgumentException("Not an enum value");
        };
    }

    public static boolean isSame(HttpStatusCode statusCode, int code) {
        return statusCode.equals(valueOf(code));
    }
}
