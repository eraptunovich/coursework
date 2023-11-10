package com.example.coursework.models;

public class Issue {
    private int issueId;
    private String title;
    private String description;
    private int categoryId;
    private String productVersion;
    private String priority;
    private String status;
    private String createdDate;
    private String ClosedDate;
    private String deadlineDate;
    private int assignedDeveloper;
    private int assignedTester;

    public Issue() {
    }

    public int getIssueId() {
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

    public String getCreatedDate() {
        return this.createdDate;
    }

    public String getClosedDate() {
        return this.ClosedDate;
    }

    public String getDeadlineDate() {
        return this.deadlineDate;
    }

    public int getAssignedDeveloper() {
        return this.assignedDeveloper;
    }

    public int getAssignedTester() {
        return this.assignedTester;
    }

    public void setIssueId(int issueId) {
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

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setClosedDate(String ClosedDate) {
        this.ClosedDate = ClosedDate;
    }

    public void setDeadlineDate(String deadlineDate) {
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
        if (this.getIssueId() != other.getIssueId()) return false;
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

    protected boolean canEqual(final Object other) {
        return other instanceof Issue;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIssueId();
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
