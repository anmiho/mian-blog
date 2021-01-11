package com.mian.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @Description: ElasticSearch配置类
 * @Author mian
 * @Date 2021/1/7 20:21
 */
@Configuration
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        // 定义客户端配置对象 9200端口
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("127.0.0.1:9200")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

//    /**
//     * 官网写法，不用继承AbstractElasticsearchConfiguration
//     * url: https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-getting-started-initialization.html
//     *
//     */
//    @Bean
//    public RestHighLevelClient restHighLevelClient() {
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost("localhost", 9200, "http")));
//                        // new HttpHost("localhost", 9201, "http")));
//        return client;
//    }

}
