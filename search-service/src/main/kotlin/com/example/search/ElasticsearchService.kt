package com.example.search

import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.elasticsearch.search.SearchHit
import org.springframework.stereotype.Service

@Service
class ElasticsearchService(
    private val elasticClient: RestHighLevelClient
) {

    fun search(query: String): List<Map<String, Any>> {
        val searchSourceBuilder = SearchSourceBuilder()
            .query(QueryBuilders.queryStringQuery(query))
            .size(10)

        val searchRequest = SearchRequest("orders")  // Replace with your index name
            .source(searchSourceBuilder)

        val response: SearchResponse = elasticClient.search(searchRequest, RequestOptions.DEFAULT)

        return response.hits.map(SearchHit::getSourceAsMap)
    }
}
