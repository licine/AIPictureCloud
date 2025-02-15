package com.tutu.api.aliyunai.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author shkstart
 * @create 2025-02-14 15:00
 */
@Data
public class GetGeneratePictureTaskResponse implements Serializable {
    private String taskId;
    private String taskStatus;
    private String submitTime;
    private String scheduledTime;
    private String endTime;
    private List<Result> results;
    private TaskMetrics taskMetrics;
    private String code;
    private String message;
    private Usage usage;
    private String requestId;

    // Getters and Setters

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public TaskMetrics getTaskMetrics() {
        return taskMetrics;
    }

    public void setTaskMetrics(TaskMetrics taskMetrics) {
        this.taskMetrics = taskMetrics;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public static class Result {
        private String origPrompt;
        private String actualPrompt;
        private String url;
        private String code;
        private String message;

        // Getters and Setters

        public String getOrigPrompt() {
            return origPrompt;
        }

        public void setOrigPrompt(String origPrompt) {
            this.origPrompt = origPrompt;
        }

        public String getActualPrompt() {
            return actualPrompt;
        }

        public void setActualPrompt(String actualPrompt) {
            this.actualPrompt = actualPrompt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class TaskMetrics {
        private Integer total;
        private Integer succeeded;
        private Integer failed;

        // Getters and Setters

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getSucceeded() {
            return succeeded;
        }

        public void setSucceeded(Integer succeeded) {
            this.succeeded = succeeded;
        }

        public Integer getFailed() {
            return failed;
        }

        public void setFailed(Integer failed) {
            this.failed = failed;
        }
    }

    public static class Usage {
        private Integer imageCount;

        // Getters and Setters

        public Integer getImageCount() {
            return imageCount;
        }

        public void setImageCount(Integer imageCount) {
            this.imageCount = imageCount;
        }
    }


}
