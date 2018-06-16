package response;

import com.google.gson.JsonElement;

public class StandardResponse {

    private String status;
    private JsonElement data;

    public StandardResponse(String status, JsonElement data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }
}
