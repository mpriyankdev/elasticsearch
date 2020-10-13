package com.es.elasticsearch.es;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.UnknownHostException;

@SpringBootTest
public class SampleTest1 extends EmbeddedElasticsearchTest {

    @Test
    @DisplayName("sample test")
    public void test() throws UnknownHostException {
        Assertions.assertEquals(embeddedElastic.fetchAllDocuments("cars").size(), 0);
    }

    @Test
    @DisplayName("sample test_1")
    public void test_1() throws UnknownHostException {
        Assertions.assertEquals(embeddedElastic.fetchAllDocuments("cars").size(), 0);
        
    }

    @Test
    @DisplayName("sample test_2")
    public void test_2() throws UnknownHostException {
        Assertions.assertEquals(embeddedElastic.fetchAllDocuments("cars").size(), 0);
    }




}
