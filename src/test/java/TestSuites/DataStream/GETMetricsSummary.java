package TestSuites.DataStream;

import TestConfigurations.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETMetricsSummary extends BaseTest {

    public static String project_id = "1";
    public static String module_id = "1";
    public static String from = "" ;
    public static String to = "";

    @Test(priority = 0)
    public void get_metricsSummary_statusCode()
    {
        Response response = RestAssured.get("/data/project/1/module/3/metrics?from=1639699200000&to=1647475199999");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
