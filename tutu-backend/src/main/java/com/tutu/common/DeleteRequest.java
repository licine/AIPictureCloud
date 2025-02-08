package com.tutu.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2025-02-04 10:29
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}

