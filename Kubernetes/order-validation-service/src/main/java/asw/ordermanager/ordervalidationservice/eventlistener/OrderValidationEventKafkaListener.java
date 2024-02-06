package asw.ordermanager.ordervalidationservice.eventlistener;

import asw.ordermanager.common.api.event.DomainEvent;


 
import asw.ordermanager.orderservice.api.event.OrderServiceEventChannel;
import asw.ordermanager.productservice.api.event.ProductStockLevelUpdatedEventChannel;
import asw.ordermanager.productservice.api.event.ProductCreatedEventChannel;

import asw.ordermanager.ordervalidationservice.domain.OrderValidationServiceEventHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import java.util.logging.Logger;



@Component 
public class OrderValidationEventKafkaListener {


	private final Logger logger = Logger.getLogger(this.getClass().toString());

    @Autowired
    private OrderValidationServiceEventHandler orderValidationServiceEventHandler;

	@KafkaListener(topics = {ProductCreatedEventChannel.channel, OrderServiceEventChannel.channel, ProductStockLevelUpdatedEventChannel.channel}, groupId="ordervalidationservic")
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        DomainEvent event = record.value();
		orderValidationServiceEventHandler.onEvent(event); 
    }



}