package ProductsAPIs_Tests;

import POJO.Requests.CreateProductApiPayload;
import POJO.Responses.CreateProductApiResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateProduct_Tests {

    @Test
    public static void updateProduct(){

        String endpoint = "http://localhost:3030/products/9999691";
        Map<String,String> headers  = new HashMap<>();
        headers.put("Content-Type", "application/json");
        CreateProductApiPayload product = new CreateProductApiPayload();
        product.setName("Iphone 15 pro max trade-line");
        product.setType("Smart-Phones");
        product.setManufacturer("Apple");
        product.setPrice(100000.0);
        product.setUrl("http://www.bestbuy.com/site/metra-radio-installation-dash-kit-for-select-ford-mazda-and-mercury-vehicles-pair-black/478398.p?id=1185268614282&skuId=478398&cmp=RMXCC");
        product.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4783/478398_rc.jpg");

        CreateProductApiResponse updatedProduct = given().headers(headers).body(product).when().patch(endpoint)
                .as(CreateProductApiResponse.class);

        Assert.assertEquals(updatedProduct.getName() , product.getName());
        Assert.assertEquals(updatedProduct.getType() , product.getType());
        Assert.assertEquals(updatedProduct.getManufacturer() , product.getManufacturer());
        Assert.assertEquals(updatedProduct.getPrice() , product.getPrice());
        Assert.assertEquals(updatedProduct.getUrl() , product.getUrl());
        Assert.assertEquals(updatedProduct.getImage() , product.getImage());




    }
}
