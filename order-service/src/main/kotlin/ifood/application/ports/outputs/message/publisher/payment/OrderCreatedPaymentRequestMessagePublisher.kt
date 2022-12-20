package ifood.application.ports.outputs.message.publisher.payment

import ifood.commons.event.publisher.DomainEventPublisher
import ifood.domain.event.OrderCreatedEvent

interface OrderCreatedPaymentRequestMessagePublisher: DomainEventPublisher<OrderCreatedEvent> {
}