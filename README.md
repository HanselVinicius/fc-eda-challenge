# FC EDA PROJECT

## Feito em kotlin e usado o projeto de golang cedido no curso

### Para rodar

```shell
docker compose up -d --build
```

### Indicações uteis

* [Pasta de Migrations](./fc-eda-challenge/fc-eda-challenge/src/main/resources/db/migration/V1__create_balances_table.sql)
* [Migrations da wallet api](./fc-eda/cmd/walletcore/main.go)
* [Arquivo http da api de balances](./fc-eda-challenge/fc-eda-challenge/.http)
* [Arquivo http da api de wallets](./fc-eda/api/client.http)

obs: os valores do arquivo http foram estrategicamente preparados para refletir as migrations 
