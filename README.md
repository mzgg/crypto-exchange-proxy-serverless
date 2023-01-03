# crypto-exchange-proxy-serverless
AWS Multiple Crypto Exchange Platform provide price action as FaaS

### Test for Ip Check Function in Local
```curl -H "Content-Type: text/plan" localhost:8080/getIpCheck```

### Test for HttpRequest relevant platform
- If the function is being wanted to make a test in the AWS lambda panel test tool, it can be used in the JSON code below
```json
{
  "queryStringParameters": {
    "currency_pair": "BTC_USDT",
    "limit":1
  },
  "pathParameters": {
    "proxy": "/gateio/spot/trades"
  }
}
```
Ex Response
```json
[
  {
    "id": "4855939694",
    "create_time": "1672723486",
    "create_time_ms": "1672723485994.729000",
    "currency_pair": "BTC_USDT",
    "side": "buy",
    "amount": "0.0015",
    "price": "16692.5"
  }
]
```



- If the function is being wanted to make a test in local, it can be used in curl below

```curl -H "Content-Type: text/plain" localhost:8080/getResponseFromExchangeData/spot/trades -d '{ "queryStringParameters": { "currency_pair": "BTC_USDT", "limit":1 }, "pathParameters": { "proxy": "/spot/trades" } }'```

-If The function will be used via Api Gateway Service in aws, follow the below steps
  - Create an APi Gateway which `HTTP API` and choose lambda function in Step1
  - Change the `Resource path` textbox with `/{proxy+}` and method `ANY` in Step2
  - Don't change anything in Step3
  - Done, party hard :) 


  
 ####Dont' miss the descripe the `Environment variables`.
```
FUNCTION_NAME=getResponseFromExchangeData
or
FUNCTION_NAME=getIpCheck
```
