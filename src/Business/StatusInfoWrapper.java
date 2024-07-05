package Business;

public class StatusInfoWrapper {
    private boolean status;
    private Object value;
    private String message;

    public String getMessage() {
        return message;
    }

    public StatusInfoWrapper(boolean status, Object value, String message) {
        this.status = status;
        this.value = value;
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public Object getValue() {
        return value;
    }
}
