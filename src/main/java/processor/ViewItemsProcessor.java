package processor;

import com.google.gson.Gson;
import dao.ItemDao;
import dto.ResponseDto;
import java.util.Date;
import parser.ParsedUrl;

public class ViewItemsProcessor implements Processor{

  private static Gson gson = new Gson();

  @Override
  public ResponseDto process(ParsedUrl parsedUrl, String body) {
    return null;
  }
}
