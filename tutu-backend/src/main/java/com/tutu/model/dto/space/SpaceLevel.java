package com.tutu.model.dto.space;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shkstart
 * @create 2025-02-11 21:59
 */
@Data
@AllArgsConstructor
public class SpaceLevel {

    private int value;

    private String text;

    private long maxCount;

    private long maxSize;
}

