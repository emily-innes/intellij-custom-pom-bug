package mypackage;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;

public class ResourceTest {

    @Test
    public void testResource(){
        URL res = ResourceTest.class.getClassLoader().getResource("resource.txt");
        Assert.assertNotNull(res);
    }
}
