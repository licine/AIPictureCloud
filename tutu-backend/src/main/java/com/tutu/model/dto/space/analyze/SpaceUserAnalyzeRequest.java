package com.tutu.model.dto.space.analyze;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author shkstart
 * @create 2025-02-15 11:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SpaceUserAnalyzeRequest extends SpaceAnalyzeRequest {

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 时间维度：day / week / month
     */
    private String timeDimension;
}
