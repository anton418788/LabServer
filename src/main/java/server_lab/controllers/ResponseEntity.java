package server_lab.controllers;

public class ResponseEntity<T> {
    private final T answer;
    private final int status;

    public ResponseEntity(T answer, int status) {
        this.answer = answer;
        this.status = status;
    }

    public T getAnswer() {
        return answer;
    }

    public int getStatus() {
        return status;
    }
}
