package TestConfigurations;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest extends FrameworkUtility {

    @BeforeSuite
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
                post("https://dev-96224665.okta.com/app/dev-96224665_polarisqa_1/exk3odv0g0lRnOw9B5d7/sso/saml");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @BeforeClass
    public static void setup()
    {
        RestAssured.baseURI = "http://34.93.23.216:82";
        RestAssured.basePath = "/api";
       // RestAssured.port = 82 ;

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        RestAssured.requestSpecification = requestSpecification;


        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .build();

        RestAssured.responseSpecification = responseSpecification;
    }


}
