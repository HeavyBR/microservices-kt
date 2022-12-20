package ifood.application.ports.inputs.message.listener.payment

import ifood.application.dto.message.PaymentResponse

interface PaymentResponseMessageListener {
    fun paymentCompleted(paymentResponse: PaymentResponse)
    fun paymentCancelled(paymentResponse: PaymentResponse)
}