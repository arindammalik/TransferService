# TransferMoneyService

## The project helps to setup user-accounts and transfer balance between them

Download the project using
```bash
git clone https://github.com/arindammalik/TransferService.git
```
Install gradle
```
https://spring.io/guides/gs/gradle/
```

```
cd TransferService
./gradlew bootRun 
or you can run using your IDE
```



### The project has 3 main feature
#### 1. Setup an account
Input is expected in the format of string and big decimal
```
curl --location --request POST 'http://localhost:8080/userDetails/v1/createNewUser' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"arindam malik",
    "balance": 12
}'
```

#### 2. Check balance
Change Path variable to your account id received when account was created
```
curl --location --request GET 'http://localhost:8080/userDetails/v1/getBalance/1'
```

#### 3. Transfer Money between account
Path variable contains sourceId, and request body contains destination account id and amount to be transferred.
```
curl --location --request POST 'http://localhost:8080/transaction/v1/transferMoney/1' \
--header 'Content-Type: application/json' \
--data-raw '{	"destAccountNum":2,
	"amount":1000
}'
```


## Stuck somewhere?
Please feel free to reach out to me here:
[Arindam Malik](mailto:arindammalik96@gmail.com)
