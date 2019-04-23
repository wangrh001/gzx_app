package com.bangnd.batch.framework;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//https://www.cnblogs.com/slimshady/p/10064898.html
@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jbf;

    @Autowired
    private StepBuilderFactory sbf;

    @Autowired
    private ApplicationContext ctx;;

    @Bean
    public Job processJob() {
        return jbf.get("processJob")
                .incrementer(new RunIdIncrementer()).listener(listener())
                .flow(orderStep1()).end().build();
    }

    @Bean
    public Step orderStep1() {
        return sbf.get("orderStep1").<String, String>chunk(1)
                .reader(ctx.getBean(Reader.class)).processor(ctx.getBean(Processor.class))
                .writer(ctx.getBean(Writer.class)).build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionListener();
    }
    //下面这种方式也可以
//    @Bean
//    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager)
//            throws Exception {
//        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
//        jobRepositoryFactoryBean.setDataSource(dataSource);
//        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
//        jobRepositoryFactoryBean.setDatabaseType("mysql");
//        return jobRepositoryFactoryBean.getObject();
//    }
//    @Bean
//    public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager)
//            throws Exception {
//        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
//        jobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
//        return jobLauncher;
//    }
//    @Bean
//    public Job importJob(JobBuilderFactory jobs, Step s1) {
//        return jobs.get("importJob")
//                .incrementer(new RunIdIncrementer())
//                .flow(s1)
//                .end()
//                .build();
//    }
//    @Bean
//    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<String> reader, ItemWriter<String> writer,
//                      ItemProcessor<String,String> processor) {
//        return stepBuilderFactory
//                .get("step1")
//                .<String, String>chunk(65000)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .build();
//    }
}