package com.viniciush.fc_eda_challenge.balance.events

import com.fasterxml.jackson.annotation.JsonProperty

data class BalanceUpdatedDto(
    @JsonProperty("Name")
    val name: String,
    @JsonProperty("Payload")
    val payload: BalancePayloadDto,
)
