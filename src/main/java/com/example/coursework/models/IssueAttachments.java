package com.example.coursework.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "issueattachments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueAttachments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "attachmentId")
    private Long attachmentId;
    @Column(name = "filename")
    private String fileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contenttype")
    private String contentType; //расширение файла
    @Column(name = "ispreviewimage")
    private boolean isPreviewImage;
    @Lob
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Issue issue;
}
