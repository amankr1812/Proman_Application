package io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-03T14:35:42.587+05:30")

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
