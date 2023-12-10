package com.example.coursework.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "issuecategories")
public class IssueCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid")
    private Long categoryId;
    @Column(name = "categoryname")
    private String categoryName;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Issue issue;

    public IssueCategories() {
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Issue getIssue() {
        return this.issue;
    }

    public void setCategoryId(Long attachmentId) {
        this.categoryId = attachmentId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof IssueCategories)) return false;
        final IssueCategories other = (IssueCategories) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$attachmentId = this.getCategoryId();
        final Object other$attachmentId = other.getCategoryId();
        if (this$attachmentId == null ? other$attachmentId != null : !this$attachmentId.equals(other$attachmentId))
            return false;
        final Object this$categoryName = this.getCategoryName();
        final Object other$categoryName = other.getCategoryName();
        if (this$categoryName == null ? other$categoryName != null : !this$categoryName.equals(other$categoryName))
            return false;
        final Object this$issue = this.getIssue();
        final Object other$issue = other.getIssue();
        if (this$issue == null ? other$issue != null : !this$issue.equals(other$issue)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof IssueCategories;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $attachmentId = this.getCategoryId();
        result = result * PRIME + ($attachmentId == null ? 43 : $attachmentId.hashCode());
        final Object $categoryName = this.getCategoryName();
        result = result * PRIME + ($categoryName == null ? 43 : $categoryName.hashCode());
        final Object $issue = this.getIssue();
        result = result * PRIME + ($issue == null ? 43 : $issue.hashCode());
        return result;
    }

    public String toString() {
        return "IssueCategories(attachmentId=" + this.getCategoryId() + ", categoryName=" + this.getCategoryName() + ", issue=" + this.getIssue() + ")";
    }
}