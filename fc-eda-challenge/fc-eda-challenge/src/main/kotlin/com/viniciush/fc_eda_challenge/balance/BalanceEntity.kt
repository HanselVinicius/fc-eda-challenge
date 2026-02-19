package com.viniciush.fc_eda_challenge.balance

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "balance")
open class BalanceEntity(
    @Column(name = "account_id", nullable = false)
    open var accountId: String,
    @Column(name = "balance", nullable = false)
    open var balance: Float,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
}
