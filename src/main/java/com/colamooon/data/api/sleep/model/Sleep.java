package com.colamooon.data.api.sleep.model;

import io.thevita.data.api.common.model.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@EqualsAndHashCode(callSuper = false)
@Document
@Builder
public class Sleep extends BaseEntity {

    private String memberId;
    private String uuid;
    private String createTime;
    private String updateTime;
    private String packageName;
    private String deviceUuid;
    private String custom;
    private String healthDataType;

    private Long startTime;
    private Long endTime;
    private Long timeOffset;

    private String comment;

}
