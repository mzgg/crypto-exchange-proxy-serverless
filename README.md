# crypto-exchange-proxy-serverless

##AWS Multiple Crypto Exchange Platform provide price action as FaaS

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
- If the function is being wanted to make a test in local, it can be used in curl below

```curl -H "Content-Type: text/plain" localhost:8080/getResponseFromExchangeData/spot/trades -d '{ "queryStringParameters": { "currency_pair": "BTC_USDT", "limit":1 }, "pathParameters": { "proxy": "/spot/trades" } }'```

 