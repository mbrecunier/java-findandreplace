import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }
  //
  // @ClassRule
  // public static ServerRule server = new ServerRule();
  //
  // @Test
  // public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("");
  // }

  @Test
  public void findAndReplace_willReplaceWorldWithUniverse_ChangedString() {
    App testApp = new App();
    assertEquals("Hello Universe", testApp.findAndReplace("Hello World", "World", "Universe"));
  }

  @Test
  public void findAndReplace_willReplaceWorldWithDog_ChangedString() {
    App testApp = new App();
    assertEquals("Hello Dog", testApp.findAndReplace("Hello World", "World", "Dog"));
  }

  @Test
  public void findAndReplace_willReplacePartialMatches_ChangedString() {
    App testApp = new App();
    assertEquals("My dog likes doghedrals", testApp.findAndReplace("My cat likes cathedrals", "cat", "dog"));
  }

  @Test
  public void findAndReplace_willBeCaseInsensitive_ChangedString() {
    App testApp = new App();
    assertEquals("dOg dOg dOg dOg", testApp.findAndReplace("CAT cat cAt CaT", "cat", "dOg"));
  }
}
