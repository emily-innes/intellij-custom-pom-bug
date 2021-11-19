package mypackage;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;

public class AnotherResourceTest {

    @Test
    public void testResource(){
        URL res = AnotherResourceTest.class.getClassLoader().getResource("resource.txt");
        Assert.assertNotNull(res);
    }
}
