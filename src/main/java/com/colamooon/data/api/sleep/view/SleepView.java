package com.colamooon.data.api.sleep.view;

import com.colamooon.data.api.common.model.ActiveType;
import com.colamooon.data.api.common.model.BaseView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class SleepView extends BaseView {

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

    public SleepView(String id, ActiveType active, Long updatedAt, Long createdAt, Long createdId, Long updatedId, String memberId, String uuid, String createTime, String updateTime, String packageName, String deviceUuid, String custom, String healthDataType, Long startTime, Long endTime, Long timeOffset, String comment) {
        super(id, active, updatedAt, createdAt, createdId, updatedId);
        this.memberId = memberId;
        this.uuid = uuid;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.packageName = packageName;
        this.deviceUuid = deviceUuid;
        this.custom = custom;
        this.healthDataType = healthDataType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeOffset = timeOffset;
        this.comment = comment;
    }
}
