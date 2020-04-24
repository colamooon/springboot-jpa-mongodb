package com.colamooon.data.api.sleep;

import io.thevita.data.api.common.model.ActiveType;
import io.thevita.data.api.sleep.exception.SleepNotFoundException;
import io.thevita.data.api.sleep.model.Sleep;
import io.thevita.data.api.sleep.view.SleepView;
import io.thevita.data.api.sleep.view.SleepViews;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class SleepService {

    private final SleepRepository sleepRepository;

    public Flux<Sleep> postSleeps(SleepViews sleepViews, String memberId) {
        log.debug("]-----] SleepService::postSleeps sleepViews [-----[ {}", sleepViews);
        log.debug("]-----] SleepService::postSleeps memberId [-----[ {}", memberId);
        List<Sleep> sleeps = sleepViews.getSleepViews().stream().map(sleepView -> {
            sleepView.setMemberId(memberId);
            return sleepViewToEntity(sleepView);
        }).collect(Collectors.toList());
        return sleepRepository.saveAll(sleeps);
    }

    public Mono<SleepView> getLastestOne(String memberId) {
        log.debug("]-----] SleepService::getLastestOne memberId [-----[ {}", memberId);
        return sleepRepository.findFirstByActiveAndMemberIdOrderByEndTimeDesc(ActiveType.ACTIVE, memberId)
                .map(this::sleepEntityToView)
                .switchIfEmpty(Mono.error(new SleepNotFoundException()));
    }

    public SleepView sleepEntityToView(Sleep sleep) {
        log.debug("]-----] SleepService::sleepEntityToView sleep [-----[ {}", sleep);
        return SleepView.builder()
                .id(sleep.getId())
                .active(sleep.getActive())
                .createdAt(sleep.getCreatedAt())
                .createdId(sleep.getCreatedId())
                .memberId(sleep.getMemberId())
                .uuid(sleep.getUuid())
                .createTime(sleep.getCreateTime())
                .updateTime(sleep.getUpdateTime())
                .packageName(sleep.getPackageName())
                .deviceUuid(sleep.getDeviceUuid())
                .custom(sleep.getCustom())
                .healthDataType(sleep.getHealthDataType())
                .startTime(sleep.getStartTime())
                .endTime(sleep.getEndTime())
                .timeOffset(sleep.getTimeOffset())
                .comment(sleep.getComment())
                .build();
    }

    public Sleep sleepViewToEntity(SleepView sleepView) {
        log.debug("]-----] SleepService::sleepViewToEntity sleepView [-----[ {}", sleepView);
        return Sleep.builder()
                .memberId(sleepView.getMemberId())
                .uuid(sleepView.getUuid())
                .createTime(sleepView.getCreateTime())
                .updateTime(sleepView.getUpdateTime())
                .packageName(sleepView.getPackageName())
                .deviceUuid(sleepView.getDeviceUuid())
                .custom(sleepView.getCustom())
                .healthDataType(sleepView.getHealthDataType())
                .startTime(sleepView.getStartTime())
                .endTime(sleepView.getEndTime())
                .timeOffset(sleepView.getTimeOffset())
                .comment(sleepView.getComment())
                .build();
    }

}
