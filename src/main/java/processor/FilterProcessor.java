package processor;

import dao.ItemDao;
import dto.ItemDto;
import dto.ResponseDto;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import parser.ParsedUrl;

public class FilterProcessor implements Processor{

  @Override
  public ResponseDto process(ParsedUrl parsedUrl, String body) {
    return null;
  }
}
