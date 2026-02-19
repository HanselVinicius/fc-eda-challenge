package com.viniciush.fc_eda_challenge.balance

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BalanceRepository : JpaRepository<BalanceEntity, Long> {
    fun findByAccountId(accountId: String): BalanceEntity?
}
