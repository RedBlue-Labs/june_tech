package com.example.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class ScopePrototypeBean {

    @PostConstruct
    public void init() {
        log.info("ScopePrototypeBean PostConstruct 호출 : {} ", this);
    }

    @PreDestroy
    public void end() {
        log.info("ScopePrototypeBean PreDestroy 호출 : {}", this);
    }
}
