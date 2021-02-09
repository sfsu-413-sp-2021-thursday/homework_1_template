package processor;

import org.testng.Assert;
import org.testng.annotations.Test;
import parser.ParsedUrl;

public class ProcessorTest {

  @Test
  public void doTest(){
    ParsedUrl parsedUrl;
    parsedUrl = new ParsedUrl("http://localhost:1234/api/viewItems");

    Processor processor = ProcessorFactory.getProcessor(parsedUrl);
    Assert.assertNotNull(processor);
    Assert.assertEquals(processor.getClass().getName(), "processor.ViewItemsProcessor");

    parsedUrl = new ParsedUrl("http://localhost:1234/api/createItem");
    processor = ProcessorFactory.getProcessor(parsedUrl);
    Assert.assertNotNull(processor);
    Assert.assertEquals(processor.getClass().getName(), "processor.AddItemProcessor");
  }
}
