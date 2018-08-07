package com.vcg.provider.model;

import com.vcg.common.base.BaseModel;

public class Attachments extends BaseModel<Attachments> {

    private static final long serialVersionUID = 6175886146195734749L;

    private Integer id;

    private Integer providerId;

    private String type;

    private String status;

    private String path;

    private String remark;

    public Integer getId() {
        return id;
    }

    public Attachments setId(Integer id) {
        this.id = id;
		return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public Attachments setProviderId(Integer providerId) {
        this.providerId = providerId;
		return this;
    }

    public String getType() {
        return type;
    }

    public Attachments setType(String type) {
        this.type = type == null ? null : type.trim();
		return this;
    }

    public String getStatus() {
        return status;
    }

    public Attachments setStatus(String status) {
        this.status = status == null ? null : status.trim();
		return this;
    }

    public String getPath() {
        return path;
    }

    public Attachments setPath(String path) {
        this.path = path == null ? null : path.trim();
		return this;
    }

    public String getRemark() {
        return remark;
    }

    public Attachments setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
		return this;
    }
}
