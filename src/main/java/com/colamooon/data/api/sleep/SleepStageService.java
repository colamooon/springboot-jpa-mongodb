package com.colamooon.data.api.sleep;

import io.thevita.data.api.common.model.ActiveType;
import io.thevita.data.api.sleep.exception.SleepStageNotFoundException;
import io.thevita.data.api.sleep.model.SleepStage;
import io.thevita.data.api.sleep.view.SleepStageView;
import io.thevita.data.api.sleep.view.SleepStageViews;
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
public class SleepStageService {

    private final SleepStageRepository sleepStageRepository;

    public Flux<SleepStage> postSleepStages(SleepStageViews sleepStageViews, String memberId) {
        log.debug("]-----] SleepStageService::postSleeps sleepViews [-----[ {}", sleepStageViews);
        List<SleepStage> sleepStages = sleepStageViews.getSleepStageViews().stream().map(sleepStageView -> {
            sleepStageView.setMemberId(memberId);
            return sleepStageViewToEntity(sleepStageView);
        }).collect(Collectors.toList());
        return sleepStageRepository.saveAll(sleepStages);
    }

    public Mono<SleepStageView> getLastestOne(String memberId) {
        log.debug("]-----] SleepStageService::getLastestOne memberId [-----[ {}", memberId);
        return sleepStageRepository.findFirstByActiveAndMemberIdOrderByEndTimeDesc(ActiveType.ACTIVE, memberId)
                .map(this::sleepStageEntityToView)
                .switchIfEmpty(Mono.error(new SleepStageNotFoundException()));
    }

    public SleepStageView sleepStageEntityToView(SleepStage sleepStage) {
        log.debug("]-----] SleepService::sleepEntityToView sleepStage [-----[ {}", sleepStage);
        return SleepStageView.builder()
                .id(sleepStage.getId())
                .active(sleepStage.getActive())
                .createdAt(sleepStage.getCreatedAt())
                .createdId(sleepStage.getCreatedId())
                .memberId(sleepStage.getMemberId())
                .uuid(sleepStage.getUuid())
                .createTime(sleepStage.getCreateTime())
                .updateTime(sleepStage.getUpdateTime())
                .packageName(sleepStage.getPackageName())
                .deviceUuid(sleepStage.getDeviceUuid())
                .custom(sleepStage.getCustom())
                .healthDataType(sleepStage.getHealthDataType())
                .startTime(sleepStage.getStartTime())
                .endTime(sleepStage.getEndTime())
                .timeOffset(sleepStage.getTimeOffset())
                .sleepId(sleepStage.getSleepId())
                .stage(sleepStage.getStage())
                .build();
    }

    public SleepStage sleepStageViewToEntity(SleepStageView sleepStageView) {
        log.debug("]-----] SleepStageService::sleepStageViewToEntity sleepStageView [-----[ {}", sleepStageView);
        return SleepStage.builder()
                .memberId(sleepStageView.getMemberId())
                .uuid(sleepStageView.getUuid())
                .createTime(sleepStageView.getCreateTime())
                .updateTime(sleepStageView.getUpdateTime())
                .packageName(sleepStageView.getPackageName())
                .deviceUuid(sleepStageView.getDeviceUuid())
                .custom(sleepStageView.getCustom())
                .healthDataType(sleepStageView.getHealthDataType())
                .startTime(sleepStageView.getStartTime())
                .endTime(sleepStageView.getEndTime())
                .timeOffset(sleepStageView.getTimeOffset())
                .sleepId(sleepStageView.getSleepId())
                .stage(sleepStageView.getStage())
                .build();
    }

}
