package com.example.yonhapnews.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "heony_dev_yonhap_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeonyNews{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String link;
    private String comments;
    private Timestamp pub_date;
    private String category;
    private String description;
    private String content;
    private Timestamp reg_date;

    @Column(name = "save_date")
    @CreationTimestamp
    private Timestamp saveDate;

}
