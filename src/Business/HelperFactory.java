package Business;

public final class HelperFactory {
    private HelperFactory(){}
    public static StatusInfoWrapper generateStatusInfo(boolean status, Object value, String message)
    {
        return new StatusInfoWrapper(status, value, message);
    }
}
