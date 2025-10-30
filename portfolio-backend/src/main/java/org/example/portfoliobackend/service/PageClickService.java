package org.example.portfoliobackend.service;

import org.example.portfoliobackend.model.PageClickCount;
import org.example.portfoliobackend.repository.PageClickRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PageClickService {

    private final PageClickRepo repo;

    public PageClickService(PageClickRepo repo) {
        this.repo = repo;
    }

    public PageClickCount recordClick(String pageName) {
        PageClickCount page = repo.findByPageName(pageName)
                .orElse(new PageClickCount(pageName, 0L, LocalDateTime.now()));

        page.setClickCount(page.getClickCount() + 1);
        page.setLastClickedAt(LocalDateTime.now());

        return repo.save(page);
    }

    public long getClickCount(String pageName) {
        return repo.findByPageName(pageName)
                .map(PageClickCount::getClickCount)
                .orElse(0L);
    }
}
