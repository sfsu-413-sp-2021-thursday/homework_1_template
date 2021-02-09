package dao;

import dto.ItemDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DaoTests {

  @Test
  public void testDaos(){
    ItemDao itemDao = ItemDao.getInstance();
    Assert.assertTrue(DataAccessObject.class.isAssignableFrom(itemDao.getClass()));
    ItemDto itemDto = new ItemDto(null, null, null, null);
    itemDao.put(itemDto);
    Assert.assertEquals(itemDao.getItems().size(), 1);
    Assert.assertNotNull(itemDao.getItems().get(0).entity_id);
    String id = itemDao.getItems().get(0).entity_id;
    itemDao.delete(id);
    Assert.assertEquals(itemDao.getItems().size(), 0);
  }

}
