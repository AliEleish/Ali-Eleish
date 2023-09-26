package ProductsAPIs_Tests;

import POJO.Requests.CreateProductApiPayload;
import POJO.Responses.CreateProductApiResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateProduct_Tests {

    @Test
    public static void createProduct(){
        String endPoint = "http://localhost:3030/products";
        CreateProductApiPayload product = new CreateProductApiPayload();
        product.setName("PlayStation 5");
        product.setType("Entertainment");
        product.setUpc("P-109");
        product.setPrice(11500.00);
        product.setShipping(3000.00);
        product.setDescription("Luxury car for families and business trips");
        product.setManufacturer("Game Valley");
        product.setModel("High Line");
        product.setUrl("http://www.bestbuy.com/site/jensen-3-6v-nicad-battery-for-900mhz-phones/373642.p?id=1051384793767&skuId=373642&cmp=RMXCC");
        product.setImage("http://img.bbystatic.com/BestBuy_US/images/products/3736/373642_rc.jpg");
        Map<String,String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        CreateProductApiResponse p = given().headers(requestHeaders).body(product).when().post(endPoint).as(CreateProductApiResponse.class);
        System.out.println("The new product has id: " + p.getId());
        Assert.assertEquals(product.getName() , p.getName());
        Assert.assertEquals(product.getType() , p.getType());
        Assert.assertEquals(product.getUpc() , p.getUpc());
        Assert.assertEquals(product.getPrice() , p.getPrice());
        Assert.assertEquals(product.getDescription() , p.getDescription());
        Assert.assertEquals(product.getModel() , p.getModel());
        Assert.assertEquals(product.getShipping() , p.getShipping());
        Assert.assertEquals(product.getManufacturer(), p.getManufacturer());
        Assert.assertEquals(product.getUrl(),p.getUrl());
        Assert.assertEquals(product.getImage(), p.getImage());
    }
}
