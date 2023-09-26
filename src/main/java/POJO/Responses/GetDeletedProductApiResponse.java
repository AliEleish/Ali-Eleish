package POJO.Responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDeletedProductApiResponse {
    public String name;
    public String message;
    public int code;
    public String className;
    public Errors errors;


    public String getName() {
        return name;
    }
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getClassName() {
        return className;
    }

    public Errors getErrors() {
        return errors;
    }

    public static class Errors{

    }
}
