package com.viniciush.fc_eda_challenge.balance.events

import com.viniciush.fc_eda_challenge.balance.BalanceEntity
import com.viniciush.fc_eda_challenge.balance.BalanceService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaBalanceConsumer(
    private val balanceService: BalanceService,
) {
    @KafkaListener(topics = ["balances"], containerFactory = "balanceKafkaListenerContainerFactory")
    fun listen(message: BalanceUpdatedDto) {
        val payload = message.payload

        processAccountUpdate(payload.accountIdFrom, payload.balanceFrom)
        processAccountUpdate(payload.accountIdTo, payload.balanceTo)
    }

    private fun processAccountUpdate(
        accountId: String,
        newBalance: Float,
    ) {
        val account = balanceService.getBalancesByAccountId(accountId)

        if (account != null) {
            account.balance = newBalance
            balanceService.updateBalance(account)
        } else {
            val newAccount =
                BalanceEntity(
                    accountId = accountId,
                    balance = newBalance,
                )
            balanceService.createBalance(newAccount)
        }
    }
}
