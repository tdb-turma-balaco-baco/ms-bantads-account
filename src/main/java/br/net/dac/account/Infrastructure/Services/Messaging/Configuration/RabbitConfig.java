package br.net.dac.account.Infrastructure.Services.Messaging.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.net.dac.account.Application.Services.Client.Events.CreateAccountEvent;
import br.net.dac.account.Application.Services.Client.Events.UpdateAccountEvent;
import br.net.dac.account.Application.Services.Client.Events.UpdateStatusAccountEvent;
import br.net.dac.account.Application.Services.Manager.Commands.Events.SwapManagerEvent;
import br.net.dac.account.Application.Services.Manager.Commands.Events.UpdateManagerEvent;
import br.net.dac.account.Domain.Events.ChangedStatusAccountEvent;
import br.net.dac.account.Domain.Events.CreatedAccountEvent;
import br.net.dac.account.Domain.Events.ErrorAccountEvent;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class RabbitConfig {
    @Value("${account.queue}")
    private String accountQueue;

    @Value("${database-sync.queue}")
    private String databaseSyncQueue;

    @Value("${account-response.queue}")
    private String accountResponseQueue;

    @Bean
    public Queue accountQueue() {
        return new Queue(accountQueue, true);
    }

    @Bean
    public Queue accountResponseQueue() {
        return new Queue(accountResponseQueue, true);
    }

    @Bean
    public Queue databaseSyncQueue() {
        return new Queue(databaseSyncQueue, true);
    }

    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setClassMapper(classMapper());
        return converter;
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        classMapper.setIdClassMapping(customClassMapping());
        classMapper.setTrustedPackages("*");
        return classMapper;
    }

    public Map<String, Class<?>> customClassMapping(){
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("CreateAccountEvent", CreateAccountEvent.class);
        idClassMapping.put("UpdateAccountEvent", UpdateAccountEvent.class);
        idClassMapping.put("UpdateStatusAccountEvent", UpdateStatusAccountEvent.class);
        idClassMapping.put("UpdateManagerEvent", UpdateManagerEvent.class);
        idClassMapping.put("SwapManagerEvent", SwapManagerEvent.class);

        idClassMapping.put("ChangedStatusAccountEvent", ChangedStatusAccountEvent.class);
        idClassMapping.put("CreatedAccountEvent", CreatedAccountEvent.class);
        idClassMapping.put("ErrorAccountEvent", ErrorAccountEvent.class);
        
        return idClassMapping;
    }


    public AmqpTemplate template(ConnectionFactory connection) {
        RabbitTemplate template = new RabbitTemplate(connection);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
