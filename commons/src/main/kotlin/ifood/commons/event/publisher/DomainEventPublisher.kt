package ifood.commons.event.publisher

import ifood.commons.event.DomainEvent

interface DomainEventPublisher<T> {
    fun publish(domainEvent: T)
}