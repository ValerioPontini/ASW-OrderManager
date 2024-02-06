package asw.ordermanager.orderservice.eventpublisher;

import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.orderservice.api.event.OrderServiceEventChannel; 
import asw.ordermanager.orderservice.domain.OrderEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Component
public class OrderEventKafkaPublisher implements OrderEventPublisher{

	@Autowired
	private KafkaTemplate<String, DomainEvent> template;

	private String channel = OrderServiceEventChannel.channel;

	public void publish(DomainEvent event) {
		template.send(channel, event);
	}
}