package com.colamooon.data.api.sleep;

import com.colamooon.data.api.common.exception.ErrorMessageCode;
import com.colamooon.data.api.sleep.view.SleepViews;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
@RequiredArgsConstructor
public class SleepHandler {

    private final SleepService sleepService;

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_GUEST')")
    public Mono<ServerResponse> postSleeps(ServerRequest request) {
        log.info("]-----] SleepHandler::postSleeps call [-----[");
        Mono<SleepViews> sleepViewsMono = request.bodyToMono(SleepViews.class);
        return request.principal()
                .flatMap(p -> Mono.just(p.getName()))
                .flatMap(memberId ->
                        sleepViewsMono.flatMap(sleepViews -> sleepService.postSleeps(sleepViews, memberId).collectList())
                )
                .flatMap(result -> ok().body(fromValue(ErrorMessageCode.SUCCESS.getCode())))
                .switchIfEmpty(notFound().build());

    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_GUEST')")
    public Mono<ServerResponse> getLastestOne(ServerRequest request) {
        log.info("]-----] SleepHandler::getLastestOne call [-----[");
        return request.principal()
                .flatMap(p -> Mono.just(p.getName()))
                .flatMap(sleepService::getLastestOne)
                .flatMap(result -> ok().body(fromValue(result)))
                .switchIfEmpty(notFound().build());

    }

}
