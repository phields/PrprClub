package com.prprclub.PrprClub.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DiscoverController {

    @GetMapping(path = ["/discover"])
    fun loadDiscoverPage(page: Pageable): Page<> {

    }
}

data class DiscoverEntry {

}