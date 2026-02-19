package com.viniciush.fc_eda_challenge.balance.events

import com.fasterxml.jackson.annotation.JsonProperty

data class BalancePayloadDto(
    @JsonProperty("account_id_from")
    val accountIdFrom: String,
    @JsonProperty("account_id_to")
    val accountIdTo: String,
    @JsonProperty("balance_account_id_from")
    val balanceFrom: Float,
    @JsonProperty("balance_account_id_to")
    val balanceTo: Float,
)
