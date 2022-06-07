package io.gravitee.eurekaclient.info;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UncheckedIOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @author GraviteeSource Team
 */
@RestController
public class InfoController {

  record Info(String host) { }

  @GetMapping("/info")
  public Info getInfo() {
    try {
      var localhost = Inet4Address.getLocalHost();
      return new Info(localhost.toString());
    } catch (UnknownHostException e) {
      throw new UncheckedIOException(e);
    }
  }
}
