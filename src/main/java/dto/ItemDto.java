package dto;

public class ItemDto extends BaseDto {

  public String description;
  public String type;
  public Integer price;
  public String title;

  public ItemDto(String id, String description, String type, Integer price, String title) {
    super(id);
    this.description = description;
    this.type = type;
    this.price = price;
    this.title = title;
  }

  public ItemDto(String description, String type, Integer price, String title) {
    super(null);
    this.description = description;
    this.type = type;
    this.price = price;
    this.title = title;
  }
}
