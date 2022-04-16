### Spring boot service using [NBP API]( http://api.nbp.pl/en.html)

#### Application contains following endpoints:

+ `GET http://localhost:8080/api/gold-price/average` - returns average gold price for the last 14 business days <br>
  **Example**:
  [
  {
  "price": 266.46,
  "date": "2022-03-29"
  }, {
  "price": 263.96,
  "date": "2022-04-06"
  }, {
  "price": 264.41,
  "date": "2022-04-07"
  }, {
  "price": 265.46,
  "date": "2022-04-08"
  },...
  ]
<br><br>
+ `GET http://localhost:8080/api/exchange-rates/{currencyCode}/` - returns currency exchange rate PLN to {currencyCode}
  for the last 5 business days. <br>
  returns currency exchange rate PLN to {currencyCode} for the last 5 business days.<br>
  **Example**: <br>
  currencyCode = "gbp" <br>
  {
  "currency": "funt szterling",
  "rates": [
  {
  "date": "2022-04-11",
  "price": 5.5484 }, {
  "date": "2022-04-12",
  "price": 5.5819 }, {
  "date": "2022-04-13",
  "price": 5.5761 }, {
  "date": "2022-04-14",
  "price": 5.5923 }, {
  "date": "2022-04-15",
  "price": 5.6019 }
  ]
  }
<br><br>
#### To run the application with maven installed type in your terminal:
  `git clone https://github.com/kBlazewicz/NBPCaller` <br>
  `cd NBPCaller`<br>
  `mvn spring-boot:run`

<br>
  