package org.example.portfoliobackend.controller;

import org.example.portfoliobackend.model.PageClickCount;
import org.example.portfoliobackend.service.PageClickService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/click")
public class PageClickController {

    private final PageClickService pageClickService;

    public PageClickController(PageClickService pageClickService) {
        this.pageClickService = pageClickService;
    }

    @PostMapping("/{pageName}")
    public PageClickCount click(@PathVariable String pageName) {
        return pageClickService.recordClick(pageName);
    }

    @GetMapping("/{pageName}")
    public long getClicks(@PathVariable String pageName) {
        return pageClickService.getClickCount(pageName);
    }
}
