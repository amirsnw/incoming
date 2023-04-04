package com.incomeBank.util;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;
import java.io.Serializable;

public class JsonResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;

    private Family family;

    private String reason;

    private String traceId;

    private T data;

    /**
     * Used for response mapping.
     */
    public JsonResponse() {
    }

    public JsonResponse(Status status) {
        super();
        this.status = status.getStatusCode();
        this.family = status.getFamily();
        this.reason = status.getReasonPhrase();
    }

    public JsonResponse(Status status, T data) {
        this(status);
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int code) {
        this.status = code;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String message) {
        this.reason = message;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "status=" + status +
                ", family=" + family +
                ", reason='" + reason + '\'' +
                ", traceId='" + traceId + '\'' +
                '}';
    }
}
