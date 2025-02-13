package com.tutu.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2025-02-13 17:31
 */
@Data
public class SearchPictureByPictureRequest implements Serializable {

    /**
     * 图片 id
     */
    private Long pictureId;

    private static final long serialVersionUID = 1L;
}

