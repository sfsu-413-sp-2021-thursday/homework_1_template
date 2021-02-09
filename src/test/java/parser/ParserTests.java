package parser;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParserTests {

  @Test
  public void doTest(){
    String random = String.valueOf(Math.random());
    String random2 = String.valueOf(Math.random());

    String randomKey = String.valueOf(Math.random());
    String randomKey2 = String.valueOf(Math.random());

    ParsedUrl parsedUrl;
    Assert.assertEquals(true, true);

    parsedUrl = new ParsedUrl("http://localhost:1234/");
    Assert.assertEquals(parsedUrl.path, "/");
    Assert.assertFalse(parsedUrl.hasQueryArgs());

    parsedUrl = new ParsedUrl("http://localhost:1234/endpoint1");
    Assert.assertEquals(parsedUrl.path, "/endpoint1");
    Assert.assertFalse(parsedUrl.hasQueryArgs());

    parsedUrl = new ParsedUrl("http://www.mysite.com:1234/endpoint1?" + randomKey
        + "=" + random);
    Assert.assertEquals(parsedUrl.path, "/endpoint1");
    Assert.assertEquals(parsedUrl.getValue(randomKey), random);
    Assert.assertNull(parsedUrl.getValue(random2));

    parsedUrl = new ParsedUrl("https://localhost:5555/endpoint1/anotherpath?"
        + randomKey2 + "=" + random);
    Assert.assertEquals(parsedUrl.path, "/endpoint1/anotherpath");
    Assert.assertEquals(parsedUrl.getValue(randomKey2), random);
    Assert.assertNull(parsedUrl.getValue(random2));
  }

}
