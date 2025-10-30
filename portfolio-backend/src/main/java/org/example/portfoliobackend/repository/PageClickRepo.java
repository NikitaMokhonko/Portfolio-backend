package org.example.portfoliobackend.repository;

import org.example.portfoliobackend.model.PageClickCount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PageClickRepo extends JpaRepository<PageClickCount, Long> {
    Optional<PageClickCount> findByPageName(String pageName);
}
