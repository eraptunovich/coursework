package com.example.coursework.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "issues")
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "issueid")
    private Long issueId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description", columnDefinition = "text")
    private String description;

    @Column(name = "CategoryID")
    private Integer categoryId;

    @Column(name="Productversion")
    private String productVersion;

    @Column(name = "Priority")
    private String priority;

    @Column(name = "Status")
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="createddate")
    private LocalDateTime createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="closeddate")
    private Date ClosedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Deadline")
    private Date deadlineDate;
    @Column(name = "Assigneddeveloper")
    private Integer assignedDeveloper;
    @Column(name = "Assignedtester")
    private Integer assignedTester;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
            mappedBy = "issue")
    private List<IssueAttachments> attachments = new ArrayList<>();

    @Column(name = "previewimageid")
    private Long previewImageId;

    @PrePersist
    private void init(){

        createdDate = LocalDateTime.now();
    }

    public void addImageToIssue(IssueAttachments image){
        image.setIssue(this);
        attachments.add(image);
    }

    public Issue() {
    }

    public Issue(Long issueId, String title, String description, int categoryId, String productVersion, String priority, String status, LocalDateTime createdDate, Date ClosedDate, Date deadlineDate, int assignedDeveloper, int assignedTester) {
        this.issueId = issueId;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.productVersion = productVersion;
        this.priority = priority;
        this.status = status;
        this.createdDate = createdDate;
        this.ClosedDate = ClosedDate;
        this.deadlineDate = deadlineDate;
        this.assignedDeveloper = assignedDeveloper;
        this.assignedTester = assignedTester;
    }

    public Date getClosedDate() {
        return this.ClosedDate;
    }

    public void setClosedDate(Date ClosedDate) {
        this.ClosedDate = ClosedDate;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Issue;
    }

    public Long getIssueId() {
        return this.issueId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getProductVersion() {
        return this.productVersion;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public Date getDeadlineDate() {
        return this.deadlineDate;
    }

    public Integer getAssignedDeveloper() {
        return assignedDeveloper != null ? assignedDeveloper : null;
    }

    public Integer getAssignedTester() {
        return assignedTester != null ? assignedTester : null;
    }
    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public void setAssignedDeveloper(int assignedDeveloper) {
        this.assignedDeveloper = assignedDeveloper;
    }

    public void setAssignedTester(int assignedTester) {
        this.assignedTester = assignedTester;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Issue)) return false;
        final Issue other = (Issue) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$issueId = this.getIssueId();
        final Object other$issueId = other.getIssueId();
        if (this$issueId == null ? other$issueId != null : !this$issueId.equals(other$issueId)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        if (this.getCategoryId() != other.getCategoryId()) return false;
        final Object this$productVersion = this.getProductVersion();
        final Object other$productVersion = other.getProductVersion();
        if (this$productVersion == null ? other$productVersion != null : !this$productVersion.equals(other$productVersion))
            return false;
        final Object this$priority = this.getPriority();
        final Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$createdDate = this.getCreatedDate();
        final Object other$createdDate = other.getCreatedDate();
        if (this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate))
            return false;
        final Object this$ClosedDate = this.getClosedDate();
        final Object other$ClosedDate = other.getClosedDate();
        if (this$ClosedDate == null ? other$ClosedDate != null : !this$ClosedDate.equals(other$ClosedDate))
            return false;
        final Object this$deadlineDate = this.getDeadlineDate();
        final Object other$deadlineDate = other.getDeadlineDate();
        if (this$deadlineDate == null ? other$deadlineDate != null : !this$deadlineDate.equals(other$deadlineDate))
            return false;
        if (this.getAssignedDeveloper() != other.getAssignedDeveloper()) return false;
        if (this.getAssignedTester() != other.getAssignedTester()) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $issueId = this.getIssueId();
        result = result * PRIME + ($issueId == null ? 43 : $issueId.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        result = result * PRIME + this.getCategoryId();
        final Object $productVersion = this.getProductVersion();
        result = result * PRIME + ($productVersion == null ? 43 : $productVersion.hashCode());
        final Object $priority = this.getPriority();
        result = result * PRIME + ($priority == null ? 43 : $priority.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        final Object $ClosedDate = this.getClosedDate();
        result = result * PRIME + ($ClosedDate == null ? 43 : $ClosedDate.hashCode());
        final Object $deadlineDate = this.getDeadlineDate();
        result = result * PRIME + ($deadlineDate == null ? 43 : $deadlineDate.hashCode());
        result = result * PRIME + this.getAssignedDeveloper();
        result = result * PRIME + this.getAssignedTester();
        return result;
    }

    public String toString() {
        return "Issue(issueId=" + this.getIssueId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", categoryId=" + this.getCategoryId() + ", productVersion=" + this.getProductVersion() + ", priority=" + this.getPriority() + ", status=" + this.getStatus() + ", createdDate=" + this.getCreatedDate() + ", ClosedDate=" + this.getClosedDate() + ", deadlineDate=" + this.getDeadlineDate() + ", assignedDeveloper=" + this.getAssignedDeveloper() + ", assignedTester=" + this.getAssignedTester() + ")";
    }
}
