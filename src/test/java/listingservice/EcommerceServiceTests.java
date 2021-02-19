package listingservice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.ItemDto;
import dto.ResponseDto;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.Test;
import pointofsale.EcommerceService;

public class EcommerceServiceTests {

  @Test
  public void testAddListing(){
    String randomType = String.valueOf(Math.random());
    Integer price = (int) Math.random() * 100;
    Gson gson = new Gson();
    ItemDto itemDto = new ItemDto("Item 1",
        randomType, price, "Gym equipment.");
    String responseString = EcommerceService
        .restApi("http://localhost:1234/api/createItem", gson.toJson(itemDto));
    ResponseDto<ItemDto> responseDto = gson.fromJson(responseString, new TypeToken<ResponseDto<ItemDto>>(){}.getType());
    Assert.assertTrue(responseDto.success);
    Assert.assertNotNull(responseDto.date);
    Assert.assertEquals(responseDto.items.size(), 1);

    responseString = EcommerceService
        .restApi("http://localhost:1234/api/viewItems", gson.toJson(itemDto));
    responseDto = gson.fromJson(responseString, new TypeToken<ResponseDto<ItemDto>>(){}.getType());
    Assert.assertTrue(responseDto.success);
    Assert.assertNotNull(responseDto.date);
    Assert.assertEquals(responseDto.items.size(), 1);
    Assert.assertEquals(responseDto.items.get(0).type, randomType);
    Assert.assertEquals(responseDto.items.get(0).price, Integer.valueOf(price));
    Assert.assertNotNull(responseDto.items.get(0).entity_id);
    String idToDelete = responseDto.items.get(0).entity_id;

    responseString = EcommerceService
        .restApi("http://localhost:1234/api/viewItems?type=" + randomType + "a", gson.toJson(itemDto));
    responseDto = gson.fromJson(responseString, new TypeToken<ResponseDto<ItemDto>>(){}.getType());Assert.assertTrue(responseDto.success);
    Assert.assertNotNull(responseDto.date);
    Assert.assertEquals(responseDto.items.size(), 0);

    responseString = EcommerceService
        .restApi("http://localhost:1234/api/viewItems?type=" + randomType + "", gson.toJson(itemDto));
    responseDto = gson.fromJson(responseString, new TypeToken<ResponseDto<ItemDto>>(){}.getType());Assert.assertTrue(responseDto.success);
    Assert.assertNotNull(responseDto.date);
    Assert.assertEquals(responseDto.items.size(), 1);

    responseString = EcommerceService
        .restApi("http://localhost:1234/api/deleteItem?entity_id=" + idToDelete, gson.toJson(itemDto));
    responseDto = gson.fromJson(responseString, new TypeToken<ResponseDto<ItemDto>>(){}.getType());Assert.assertTrue(responseDto.success);

    responseString = EcommerceService
        .restApi("http://localhost:1234/api/viewItems", gson.toJson(itemDto));
    responseDto = gson.fromJson(responseString, new TypeToken<ResponseDto<ItemDto>>(){}.getType());
    Assert.assertEquals(responseDto.items.size(), 0);
  }
}
