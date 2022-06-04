package Extentions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class APIActions extends CommonOps {

    @Step("Get data from server")
    public static Response get(String paramValues) {
        response = httpRequest.get(paramValues);
        response.prettyPrint();
        return response;
    }

    @Step("Extract value from JSON format")
    public static String extractFromJSON(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Post data to server")
    public static int post(JSONObject object, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(object.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
        return response.getStatusCode();
    }

    @Step("Update data on server")
    public static int put(JSONObject object, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(object.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
        return response.getStatusCode();
    }

    @Step("Delete data from server")
    public static int delete(String resource) {
        response = httpRequest.delete(resource);
        return response.getStatusCode();
    }

}
