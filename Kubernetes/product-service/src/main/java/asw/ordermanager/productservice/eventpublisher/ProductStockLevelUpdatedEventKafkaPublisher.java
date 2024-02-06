package asw.ordermanager.productservice.eventpublisher;

import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.productservice.api.event.ProductStockLevelUpdatedEventChannel; 
import asw.ordermanager.productservice.domain.ProductEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import java.util.logging.Logger;


import java.util.logging.Logger;

@Component
public class ProductStockLevelUpdatedEventKafkaPublisher implements ProductEventPublisher{

	private final Logger logger = Logger.getLogger(this.getClass().toString());

	@Autowired
	private KafkaTemplate<String, DomainEvent> template;

	private String channel = ProductStockLevelUpdatedEventChannel.channel;

	public void publish(DomainEvent event) {
		template.send(channel, event);
	}
}