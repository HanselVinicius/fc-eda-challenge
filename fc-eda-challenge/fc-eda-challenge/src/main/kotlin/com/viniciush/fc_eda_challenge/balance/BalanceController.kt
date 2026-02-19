package com.viniciush.fc_eda_challenge.balance

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/balances")
class BalanceController(
    val balanceService: BalanceService,
) {
    @GetMapping("/{accountId}")
    fun getBalanceByAccountId(
        @PathVariable accountId: String,
    ): BalanceEntity? = this.balanceService.getBalancesByAccountId(accountId)
}
