package ProductsAPIs_Tests;

import POJO.Responses.GetProductsApiResponse;
import io.restassured.parsing.Parser;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSpecificProduct_Tests {


    @Test
    public void GetProductWithID(){
        String endPoint = "http://localhost:3030/products/478398";
       GetProductsApiResponse p = given().expect().defaultParser(Parser.JSON).when().get(endPoint).as(GetProductsApiResponse.class);
       Assert.assertEquals(p.getId(),478398);
       Assert.assertFalse(p.getName().isEmpty(),"Name is empty");
       Assert.assertFalse(p.getDescription().isEmpty(),"Description is empty");
       Assert.assertTrue(p.getCategories().size() > 0);

    }
}
