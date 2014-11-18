package api.domain.response;

/**
 * Created by tomas on 14.11.17.
 */
public class ServiceResponse {

    private Object result;
    private String error;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
