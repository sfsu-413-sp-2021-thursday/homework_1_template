package dao;

import dto.ItemDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemDao implements DataAccessObject<ItemDto> {

  public static ItemDao getInstance(){
    return null;
  }

  private ItemDao(){
  }

  @Override
  public ItemDto put(ItemDto item) {
    return null;
  }

  @Override
  public List<ItemDto> getItems() {
    return null;
  }

  @Override
  public void delete(String id) {
  }

}
