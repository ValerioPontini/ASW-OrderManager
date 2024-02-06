package asw.ordermanager.productservice.eventpublisher;

import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.productservice.api.event.ProductCreatedEventChannel; 
import asw.ordermanager.productservice.domain.ProductEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Component
public class ProductCreatedEventKafkaPublisher implements ProductEventPublisher{

	@Autowired
	private KafkaTemplate<String, DomainEvent> template;

	private String channel = ProductCreatedEventChannel.channel;

	public void publish(DomainEvent event) {
		template.send(channel, event);
	}
}