package com.colamooon.data.api.sample;

import com.colamooon.data.api.common.exception.ErrorMessageCode;
import com.colamooon.data.api.sample.exception.SampleValidException;
import com.colamooon.data.api.sample.view.SampleView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleValidator {

    public void postValidate(SampleView sampleView) {
        log.debug("]-----] SampleValidator::postValidate.sampleView [-----[ {}", sampleView);
        if (StringUtils.isBlank(sampleView.getTitle())) {
            throw new SampleValidException(ErrorMessageCode.SAMPLE_TITLE_IS_REQUIRED);
        }

    }

}
