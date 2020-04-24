package com.colamooon.data.api.sample.model;

import io.thevita.data.api.common.model.BaseEntity;
import io.thevita.data.api.sample.constant.SampleStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@EqualsAndHashCode(callSuper = false)
@Document
@Builder
public class Sample extends BaseEntity {

    private String title;
    private String contents;

    @Builder.Default
    private SampleStatus status = SampleStatus.INIT;


}
