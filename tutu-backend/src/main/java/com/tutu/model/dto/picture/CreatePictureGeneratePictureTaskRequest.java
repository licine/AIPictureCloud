package com.tutu.model.dto.picture;

import com.tutu.api.aliyunai.model.CreateGeneratePictureTaskRequest;
import com.tutu.api.aliyunai.model.CreateOutPaintingTaskRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2025-02-14 17:12
 */
@Data
public class CreatePictureGeneratePictureTaskRequest implements Serializable {

    /**
     * 图片 id
     */
    private Long pictureId;

    /**
     * 扩图参数
     */
    private CreateGeneratePictureTaskRequest.Parameters parameters;

    private static final long serialVersionUID = 1L;
}
