/**
 * Licensed under the GPL License. You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE.
 */
package psiprobe.tools;

import java.io.IOException;
import java.net.InetAddress;
import org.junit.Assert;
import org.junit.Test;
import psiprobe.tools.Whois.Response;

/**
 * The Class WhoisTests.
 */
public class WhoisTests {

  /**
   * Test localhost.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testLocalhost() throws IOException {
    int a = 127;
    int b = 0;
    int c = 0;
    int d = 1;
    String dotted = a + "." + b + "." + c + "." + d;
    byte[] bytes = new byte[] {(byte) a, (byte) b, (byte) c, (byte) d};

    Response response = Whois.lookup("whois.arin.net", 43, "n " + dotted, 5);
    Assert.assertEquals("SPECIAL-IPV4-LOOPBACK-IANA-RESERVED", response.getData().get("NetName"));
    Assert.assertEquals("127.0.0.1", InetAddress.getByName(dotted).getHostName());
    Assert.assertEquals("127.0.0.1", InetAddress.getByAddress(bytes).getHostName());
  }

  /**
   * Test google.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testGoogle() throws IOException {
    int a = 74;
    int b = 125;
    int c = 45;
    int d = 100;
    String dotted = a + "." + b + "." + c + "." + d;
    byte[] bytes = new byte[] {(byte) a, (byte) b, (byte) c, (byte) d};

    Response response = Whois.lookup("whois.arin.net", 43, "n " + dotted, 5);
    Assert.assertEquals("GOOGLE", response.getData().get("NetName"));
    Assert.assertEquals("74.125.45.100", InetAddress.getByName(dotted).getHostName());
    Assert.assertEquals("74.125.45.100", InetAddress.getByAddress(bytes).getHostName());
  }

}
