package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Article {
    private Integer id;
    private String title;
    private String content;
    private java.util.Date createTime;
    private Integer viewCount;
    private Integer userId;

}
