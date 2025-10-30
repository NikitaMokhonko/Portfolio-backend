package org.example.portfoliobackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "page_click_count")
public class PageClickCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String pageName;

    @Column(nullable = false)
    private long clickCount;

    @Column
    private LocalDateTime lastClickedAt = LocalDateTime.now();

    public PageClickCount() {}

    public PageClickCount(String pageName, long clickCount, LocalDateTime lastClickedAt) {
        this.pageName = pageName;
        this.clickCount = clickCount;
        this.lastClickedAt = lastClickedAt;
    }

    public Long getId() { return id; }
    public String getPageName() { return pageName; }
    public long getClickCount() { return clickCount; }
    public LocalDateTime getLastClickedAt() { return lastClickedAt; }

    public void setId(Long id) { this.id = id; }
    public void setPageName(String pageName) { this.pageName = pageName; }
    public void setClickCount(long clickCount) { this.clickCount = clickCount; }
    public void setLastClickedAt(LocalDateTime lastClickedAt) { this.lastClickedAt = lastClickedAt; }
}
