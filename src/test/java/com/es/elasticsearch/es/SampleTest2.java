package com.es.elasticsearch.es;

import com.es.elasticsearch.model.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.allegro.tech.embeddedelasticsearch.IndexRequest;

import java.net.UnknownHostException;
import java.util.Arrays;

@SpringBootTest
public class SampleTest2 extends EmbeddedElasticsearchTest {

    @Test
    @DisplayName("sample test2")
    public void test() throws UnknownHostException {
        Assertions.assertEquals(embeddedElastic.fetchAllDocuments("cars").size(), 1);
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
    @DisplayName("creating document and validating it")
    public void test_23() throws JsonProcessingException, UnknownHostException {
        //embeddedElastic.createIndex("test");
        Car car = new Car("type", "qwe", "qwert", 2020);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(car);

        IndexRequest.IndexRequestBuilder indexRequestBuilder = new IndexRequest.IndexRequestBuilder("cars", "car", s);

        IndexRequest indexRequest = indexRequestBuilder.build();
        embeddedElastic.index(Arrays.asList(indexRequest));

        Assertions.assertEquals(embeddedElastic.fetchAllDocuments("cars").size(), 1);
    }
}


