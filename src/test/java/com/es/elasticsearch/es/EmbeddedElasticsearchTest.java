package com.es.elasticsearch.es;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import pl.allegro.tech.embeddedelasticsearch.EmbeddedElastic;
import pl.allegro.tech.embeddedelasticsearch.IndexSettings;
import pl.allegro.tech.embeddedelasticsearch.PopularProperties;

import java.io.IOException;

@SpringBootTest
public abstract class EmbeddedElasticsearchTest {

    protected static EmbeddedElastic embeddedElastic;

    @BeforeAll
    public static void setup() {
        try {

            embeddedElastic = EmbeddedElastic.builder()
                    .withElasticVersion("6.4.2")
                    .withSetting(PopularProperties.TRANSPORT_TCP_PORT, 9200)
                    .withSetting(PopularProperties.CLUSTER_NAME, "test_cluster")
                    //.withPlugin("analysis-stempel")
                    .withIndex("cars", IndexSettings.builder()
                            //.withType("car", getSystemResourceAsStream("car-mapping.json"))
                            .build())
                    /* .withIndex("books", IndexSettings.builder()
                             .withType(PAPER_BOOK_INDEX_TYPE, getSystemResourceAsStream("paper-book-mapping.json"))
                             .withType("audio_book", getSystemResourceAsStream("audio-book-mapping.json"))
                             .withSettings(getSystemResourceAsStream("elastic-settings.json"))
                             .build())*/
                    .build()
                    .start();
        } catch (IOException e) {
            System.out.println("INSIDE CATCH BLOCK");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*@Test
    public void testSomething() throws UnknownHostException {
        Assertions.assertEquals(embeddedElastic.fetchAllDocuments("cars").size(), 0);
    }*/


    @AfterAll
    public static void teardown() {
        System.out.println("tearing down");
        embeddedElastic.deleteIndices();
        embeddedElastic.stop();

    }
}