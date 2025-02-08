package com.tutu.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author shkstart
 * @create 2025-02-07 17:48
 */
@Data
public class PictureTagCategory {

    /**
     * 标签列表
     */
    private List<String> tagList;

    /**
     * 分类列表
     */
    private List<String> categoryList;
}

