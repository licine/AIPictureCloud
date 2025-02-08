package com.tutu.model.dto.picture;

import lombok.Data;

/**
 * @author shkstart
 * @create 2025-02-08 11:43
 */
@Data
public class PictureUploadByBatchRequest {

    /**
     * 搜索词
     */
    private String searchText;

    /**
     * 抓取数量
     */
    private Integer count = 10;

    /**
     * 名称前缀
     */
    private String namePrefix;



}
