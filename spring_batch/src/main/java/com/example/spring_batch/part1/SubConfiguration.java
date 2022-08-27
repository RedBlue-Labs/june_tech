package com.example.spring_batch.part1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SubConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job subJob() {
        return jobBuilderFactory.get("subJob")
                .incrementer(new RunIdIncrementer())
                .start(this.subStep())
                .build();
    }

    @Bean
    public Step subStep() {
        return stepBuilderFactory.get("subStep")
                .tasklet(((contribution, chunkContext) -> {
                    log.info("sub Job start");
                    return RepeatStatus.FINISHED;
                })).build();
    }
}
