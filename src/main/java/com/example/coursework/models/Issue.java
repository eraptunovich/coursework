package com.example.coursework.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private IssueCategories category;

    @Column(name="Productversion")
    private String productVersion;

    @Column(name = "priority")
    private String priority;

    @Column(name = "status")
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

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

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

    public Issue(Long issueId, String title, String description, IssueCategories category, String productVersion, String priority, String status, LocalDateTime createdDate, Date ClosedDate, Date deadlineDate, int assignedDeveloper, int assignedTester) {
        this.issueId = issueId;
        this.title = title;
        this.description = description;
        this.category = category;
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

    public IssueCategories getCategoryId() {
        return this.category;
    }

    public void setCategoryId(IssueCategories category) {
        this.category = category;
    }

}
