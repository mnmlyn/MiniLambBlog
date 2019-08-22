package com.mnmlyn.blog.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 文章表的数据对象
 *
 * @author mnmlyn
 * @date 2019/10/12
 */
@Getter
@Setter
public class ArticleDO {
    private Integer id;
    private Integer articleId;
    private String title;
    private String author;
    private Date gmtCreate;
    private Date gmtModify;
    private Integer state;
    private String mdContent;
    private String content;
    private Integer type;
    private String summary;
}
