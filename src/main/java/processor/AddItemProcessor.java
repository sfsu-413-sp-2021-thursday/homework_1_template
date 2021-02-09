package processor;

import com.google.gson.Gson;
import dao.ItemDao;
import dto.ItemDto;
import dto.ResponseDto;
import java.util.Date;
import java.util.List;
import parser.ParsedUrl;

public class AddItemProcessor implements Processor{

  private static Gson gson = new Gson();

  @Override
  public ResponseDto process(ParsedUrl parsedUrl, String body) {
    return null;
  }
}
