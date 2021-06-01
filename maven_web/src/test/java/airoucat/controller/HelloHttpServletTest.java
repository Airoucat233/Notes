package airoucat.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloHttpServletTest extends HelloHttpServlet {

    @Test
    public void testDoGet() {
        assertEquals("测试失败",2,2);
    }

    @Test
    public void testDoPost() {

    }
}