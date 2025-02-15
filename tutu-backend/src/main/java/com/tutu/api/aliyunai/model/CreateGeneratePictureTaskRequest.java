package com.tutu.api.aliyunai.model;

import cn.hutool.core.annotation.Alias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2025-02-14 15:00
 */
@Data
public class CreateGeneratePictureTaskRequest implements Serializable {

    private String model="wanx2.1-t2i-turbo";

    private Input input;

    private Parameters parameters;



    // Inner class for 'input'
    @Data
    public static class Input {

        @Alias("prompt")
        private String prompt;

        @Alias("negative_prompt")
        private String negativePrompt;


    }

    // Inner class for 'parameters'
    @Data
    public static class Parameters {
        @Alias("size")
        private String size;

        @Alias("n")
        private Integer n;

        @Alias("seed")
        private Integer seed;

        @Alias("prompt_extend")
        private Boolean promptExtend;

        @Alias("watermark")
        private Boolean watermark;
    }
}
