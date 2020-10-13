package com.es.elasticsearch.es;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.UnknownHostException;

@SpringBootTest
public class SampleTest2 extends EmbeddedElasticsearchTest {

    @Test
    @DisplayName("sample test2")
    public void test() throws UnknownHostException {
        Assertions.assertEquals(embeddedElastic.fetchAllDocuments("cars").size(), 0);
    }

    @Test
    @DisplayName("sample test_12")
    public void test_12() throws UnknownHostException {
        Assertions.assertEquals(embeddedElastic.fetchAllDocuments("cars").size(), 0);
    }

    @Test
    @DisplayName("sample test_22")
    public void test_22() throws UnknownHostException {
        Assertions.assertEquals(embeddedElastic.fetchAllDocuments("cars").size(), 0);
    }

    @Test
    public void test_23(){
        embeddedElastic.createIndex("test_mpriyank");

    }




}
