package server_lab.controllers;

import java.util.List;

public class ComonResponse<T> {
    private final T data;
    private final boolean ok;
    private final Integer codeError;
    private final String messageError;
    private final List<String> details;

    public ComonResponse(T data) {
        this.data = data;
        ok = true;
        codeError = null;
        messageError = null;
        details = null;
    }

    public ComonResponse(Integer codeError, String messageError, List<String> details) {
        data = null;
        ok = false;
        this.codeError = codeError;
        this.messageError = messageError;
        this.details = details;
    }

    public T getData() {
        return data;
    }

    public boolean isOk() {
        return ok;
    }

    public Integer getCodeError() {
        return codeError;
    }

    public String getMessageError() {
        return messageError;
    }

    public List<String> getDetails() {
        return details;
    }
}
