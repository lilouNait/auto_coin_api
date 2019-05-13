package io.swagger.Exception;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:50:43.350+02:00")

public class NotFoundException extends ApiException {
    private int code;

    public NotFoundException(String msg) {
        super(404, msg);
        this.code = 404;
    }

    public int getCode() {
        return code;
    }
}
