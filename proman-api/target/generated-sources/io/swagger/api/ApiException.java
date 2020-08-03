package io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-03T14:35:42.587+05:30")

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
