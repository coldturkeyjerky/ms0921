# Demo Rental Application
Allows users to checkout various tools

### Technical Overview
This is a REST service built on Sprint Boot, MyBatis, and H2. Built with IntelliJ. There is currently no frontend
but it should be easy enough to integrate one. You can use Postman or a similar HTTP client to
interact with the service. The service runs on port `8082`.

The H2 database can be accessed via `localhost:8082/h2-console`

There's only one endpoint:

***Checkout***
***
Returns rental agreement information about a checkout in JSON format

* **URL**

    /checkout


* **Method**

    `POST`


* **Request Body Example**
```json
{
    "toolCode": "JAKR",
    "rentalDays": 5,
    "discountPercent": 30,
    "checkoutDate": "2015-09-03"
}
```

* **Response**
```json
{
    "id": 1,
    "toolCode": "JAKR",
    "toolType": "Jackhammer",
    "toolBrand": "Ridgid",
    "rentalDays": 5,
    "checkoutDate": "2015-09-03",
    "dueDate": "2015-09-08",
    "dailyRentalCharge": 2.99,
    "chargeDays": 3,
    "preDiscountCharge": 8.97,
    "discountPercent": 30,
    "discountAmount": 2.69,
    "finalCharge": 6.28
}
```

* **Curl Example**

```curl
curl --location --request POST 'localhost:8082/checkout' \
--header 'Content-Type: application/json' \
--data-raw '{
    "toolCode": "JAKR",
    "rentalDays": 5,
    "discountPercent": 30,
    "checkoutDate": "2015-09-03"
}'
```


**Things That Could Improve, But Didn't Make It In Time**
* UI via Angular, React, or some other framework -- rather than just a service
* Tighter design of the DB schema
* More input sanitization
* Better JSON error messages
* Parameterization of the existing queries
* Additional endpoints (for adding new tool and charge data)
* Additional tests at Controller level (current tests at Mapper level)
* All the things