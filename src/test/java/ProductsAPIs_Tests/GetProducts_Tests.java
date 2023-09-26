package ProductsAPIs_Tests;

import POJO.Responses.GetProductsApiResponse;
import io.restassured.parsing.Parser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetProducts_Tests {

    @Test
    public void getProducts(){
        String endPoint = "http://localhost:3030/products";
        HashMap<String,Integer> productsAPIQueryParams = new HashMap<>();
        productsAPIQueryParams.put("$limit",12);
        productsAPIQueryParams.put("$skip",15);
        GetProductsApiResponse P = given().queryParams(productsAPIQueryParams).expect().defaultParser(Parser.JSON).when()
                .get(endPoint).as(GetProductsApiResponse.class);

        int expectedLimit = 12;
        int expectedSkip = 15;
        int expectedDataSize = 12;

        Assert.assertEquals(P.getLimit(),expectedLimit, "The expected value for products limit is "
                + expectedLimit + "but found " + P.getLimit());
        Assert.assertEquals(P.getSkip(),expectedSkip , "The expected skipped products limit is "
                + expectedSkip + "but found " + P.getSkip());
        Assert.assertEquals(P.getData().size(),expectedDataSize,"The expected size of data array is "
                + expectedDataSize + "but found " + P.getData().size());
    }
}
