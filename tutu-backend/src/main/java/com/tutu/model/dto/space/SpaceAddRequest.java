package com.tutu.model.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2025-02-11 17:42
 */
@Data
public class SpaceAddRequest implements Serializable {

    /**
     * 空间名称
     */
    private String spaceName;

    /**
     * 空间级别：0-普通版 1-专业版 2-旗舰版
     */
    private Integer spaceLevel;

    private static final long serialVersionUID = 1L;
}
