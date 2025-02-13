package com.tutu.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2025-02-13 19:54
 */
@Data
public class SearchPictureByColorRequest implements Serializable {

    /**
     * 图片主色调
     */
    private String picColor;

    /**
     * 空间 id
     */
    private Long spaceId;

    private static final long serialVersionUID = 1L;
}
