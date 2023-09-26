package ProductsAPIs_Tests;

import POJO.Responses.CreateProductApiResponse;
import POJO.Responses.GetDeletedProductApiResponse;
import POJO.Responses.GetProductsApiResponse;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteProduct_Tests {
/**
 *   Use the following IDs as path parameters in both test cases delete product and get the deleted product 9999689,
 * 9999690, 9999691
 * **/
    @Test(priority = 0)
    public static void DeleteProduct(){

        String endPoint = "http://localhost:3030/products/9999693";
        CreateProductApiResponse product =given().expect().defaultParser(Parser.JSON).when().delete(endPoint)
                .as(CreateProductApiResponse.class);
        Assert.assertEquals(product.getId(), 9999693);
        Assert.assertFalse(product.getName().isEmpty(), "Name is empty");
        Assert.assertFalse(product.getDescription().isEmpty(), "Description is empty");
    }

    @Test (priority = 1)
    public static void GetDeletedProduct(){
        String endPoint = "http://localhost:3030/products/9999693";
       Response R = given().expect().defaultParser(Parser.JSON).when().get(endPoint);
       R.then().assertThat().statusCode(404);
       GetDeletedProductApiResponse deletedProduct = R.as(GetDeletedProductApiResponse.class);
       Assert.assertEquals(deletedProduct.getName(), "NotFound");
       Assert.assertTrue(deletedProduct.getMessage().contains("No record found"));
       Assert.assertEquals(deletedProduct.getCode(),404);

    }
}
