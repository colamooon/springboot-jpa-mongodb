package com.colamooon.data.api.sleep;

import io.thevita.data.api.common.model.ActiveType;
import io.thevita.data.api.sleep.model.SleepStage;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SleepStageRepository extends ReactiveMongoRepository<SleepStage, String> {
    Flux<SleepStage> findAllByActiveAndSleepId(ActiveType activeType);

    Mono<SleepStage> countAllByActiveAndSleepId(ActiveType activeType);

    Mono<SleepStage> findFirstByActiveAndMemberIdOrderByEndTimeDesc(ActiveType activeType, String memberId);
}