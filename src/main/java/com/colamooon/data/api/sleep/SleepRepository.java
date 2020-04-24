package com.colamooon.data.api.sleep;

import io.thevita.data.api.common.model.ActiveType;
import io.thevita.data.api.sleep.model.Sleep;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SleepRepository extends ReactiveMongoRepository<Sleep, String> {
    Flux<Sleep> findAllByActiveAndMemberId(ActiveType activeType, String memberId);

    Mono<Long> countAllByActiveAndMemberId(ActiveType activeType, String memberId);

    Mono<Sleep> findFirstByActiveAndMemberIdOrderByCreatedAtDesc(ActiveType activeType, String memberId);
    Mono<Sleep> findFirstByActiveAndMemberIdOrderByEndTimeDesc(ActiveType activeType, String memberId);

}