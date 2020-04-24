package com.colamooon.data.api.sample.view;

import com.colamooon.data.api.common.model.BaseView;
import com.colamooon.data.api.sample.constant.SampleStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class SampleView extends BaseView {

    private String title;
    private String contents;
    private SampleStatus status;

}
