package TestSuites.DataStream;

import TestConfigurations.BaseTest;
import TestConfigurations.FrameworkConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETMetricsSummary extends BaseTest {

    public static String project_id = "1";
    public static String module_id = "1";
    public static String from = "" ;
    public static String to = "";

   /* @Test(priority = 0)
    public void get_metricsSummary_statusCode()
    {
        Response response = RestAssured.get("/data/project/1/module/1/metrics?from=1651602600000&to=1659378599999");
        Assert.assertEquals(response.getStatusCode(), 200);
    }*/

    @Test
    public static void post_CreateAuth()
    {
        JSONObject jsonObject = returDefaultPayLoadObject(FrameworkConstants.POSTRequest_AUTH_DEFAULT_REQUEST);
        String username = readConfigurationFile("username");
        String password = readConfigurationFile("password");
        jsonObject.put("password", password);
        jsonObject.put("username", username);

        Response response = RestAssured.given().
                contentType("application/json").
                body(jsonObject.toJSONString()).
                when().
                // post("http://dev-96224665.okta.com/api/v1/authn");
                        post("https://dev-49364104.okta.com/app/dev-49364104_polarisssoqa_1/exk5r2e5m5z06cNb75d7/sso/saml");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
