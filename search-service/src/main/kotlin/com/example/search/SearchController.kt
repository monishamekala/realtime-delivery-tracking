package com.example.search

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/search")
class SearchController(
    private val searchService: ElasticsearchService
) {

    @GetMapping
    fun search(@RequestParam query: String): List<Map<String, Any>> {
        return searchService.search(query)
    }

    @GetMapping("/health")
    fun healthCheck(): String = "Search service is running"
}
