package com.viniciush.fc_eda_challenge.balance

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Service
@Slf4j
class BalanceService(
    val balanceRepository: BalanceRepository,
) {
    fun getBalancesByAccountId(accountId: String): BalanceEntity? = this.balanceRepository.findByAccountId(accountId)

    fun createBalance(balance: BalanceEntity): BalanceEntity = balanceRepository.save(balance)

    fun updateBalance(balance: BalanceEntity): BalanceEntity = balanceRepository.save(balance)
}
