package com.tutu.model.dto.picture;

import com.tutu.api.aliyunai.model.CreateTextDrawingTaskRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2025-02-14 17:12
 */
@Data
public class CreatePictureTextDrawingTaskRequest implements Serializable {

    /**
     * 正向提示词
     */
    private String prompt;

    /**
     * 反向提示词
     */
    private String negative_prompt ;

    /**
     * 扩图参数
     */
    private CreateTextDrawingTaskRequest.Parameters parameters;

    private static final long serialVersionUID = 1L;
}
