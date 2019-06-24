package com.prprclub.controller

import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class DiscoverController {

    //@GetMapping(path = ["/discover"])
    //fun loadDiscoverPage(page: Pageable): Page<DiscoverEntry> {

    //}
}

data class DiscoverEntry(
        val name: String,
        val description: String,
        val date: Instant,
        val type: String
)