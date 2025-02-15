package com.tutu.api.aliyunai.model;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2025-02-14 15:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGeneratePictureTaskResponse implements Serializable {

    private String taskId;

    private String taskStatus;

    private String requestId;

    private String code;

    private String message;


}
