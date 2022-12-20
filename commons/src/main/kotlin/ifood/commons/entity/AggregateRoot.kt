package ifood.commons.entity

abstract class AggregateRoot<T> : BaseEntity<T> {
    constructor(id: T) : super(id)
    constructor() : super()
}