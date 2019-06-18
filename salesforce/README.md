# Readme

# Salesforce/SOAP Sprints

## Sprint 1
6/5/2019

- Create Salesforce Account
- Create two Salesforce tokens
- Create jar dependencies as needed
- Finalize Maven Dependencies
- Create Rec Specs
- Start development on Spring boot apps
- Research authentication library
- Research Salesforce visualizer

## Sprint 2
6/6/2019

- Configure Salesforce Data Persistence
- Connect to Salesforce Data Persistence
- Finalize all endpoints
- Finish writing rest controllers
- Start developing authentication library
- 50% complete: develop Spring boot apps.
- Start development on visualizer
- Start developing Junit testing on spring boot apps

## Sprint 3
6/7/2019

- Finish Spring Boot app development:
  - Expense app
  - Revenue app
- 33% complete: authentication library
- Generate authentication tokens
- 33% complete: visualizer
- 50% complete: Junit testing on Spring boot apps
- Begin work on documentation on Spring boot apps

## Sprint 4
6/8/2019

- Review Spring Boot applications:
  - Expense app
  - Revenue app
- 67% complete: authentication library
- 100% complete: Junit testing on Spring boot apps
- 67% complete: visualizer
- 50% complete: documentation on Spring boot apps
- Begin work on documentation on visualizer
- Begin work on documentation on authentication library

## Sprint 5
6/9/2019

- 100% complete: authentication library
- Clean and refactor code as needed
- 100% complete: visualizer
- Begin work on presentation slides
- 100% complete: documentation on Spring boot apps
- 100% complete: Junit testing on visualizer
- 100% complete: Junit testing on authentication library
- 50% complete: documentation on visualizer
- 50% complete: documentation on authentication library

## Sprint 6
6/10/2019

- Review visualizer
- Review authentication library
- Finish presentation slides
- 100% complete: documentation on visualizer
- 100% complete: documentation on authentication library

# Expense RAML
```
#%RAML 1.0
title: Expense
/expense:
  post:
    description: Add an expense
    body:
      application/json:
        example: |
          {
            "name": "Fire Department",
            "amount": 800.00,
            "date": "2019-04-01",
            "description": "pencil",
            "quantity": 30
          }
    responses:
      201:
  /{organization}:
    get:
      queryParameters:
        start:
          displayName: Start Date
          type: date-only
          description: Only show expenses starting on this date.
          example: 2019-01-01
        end:
          displayName: End Date
          type: date-only
          description: Only show expenses ending on this date.
          example: 2019-03-31
      responses:
        200:
          body:
            application/json:
              example: |
                [
                  {
                    "id": 4,
                    "name": "Fire Department",
                    "amount": 45.00,
                    "date": "2019-04-01T00:00:00.000+0000",
                    "description": "pencil",
                    "quantity": 30
                  },
                  {
                    "id": 3,
                    "name": "Fire Department",
                    "amount": 35.00,
                    "date": "2019-01-01T00:00:00.000+0000",
                    "description": "pencil",
                    "quantity": 30
                  },
                  {
                    "id": 2,
                    "name": "Fire Department",
                    "amount": 40.00,
                    "date": "2018-10-01T00:00:00.000+0000",
                    "description": "pencil",
                    "quantity": 30
                  },
                  {
                    "id": 1,
                    "name": "Fire Department",
                    "amount": 85.00,
                    "date": "2018-07-01T00:00:00.000+0000",
                    "description": "Ladder Truck",
                    "quantity": 1
                  }
                ]
    /summary:
      get:
        description: get expenses summarized over the time period
        queryParameters:
          start:
            displayName: Start Date
            type: date-only
            description: Only show expenses starting on this date.
            example: 2019-01-01
          end:
            displayName: End Date
            type: date-only
            description: Only show expenses ending on this date.
            example: 2019-03-31
        responses:
          200:
            body:
              application/json:
                example: |
                  [
                    {
                      "name": "Fire Department",
                      "amount": 120.00,
                      "description": "pencil",
                      "quantity": 90
                    },
                    {
                      "name": "Fire Department",
                      "amount": 85.00,
                      "description": "Ladder Truck",
                      "quantity": 1
                    }
                  ]
    /{date}:
      get:
        description: get all expenses from the given date.
        responses:
          200:
            body:
              application/json:
                example: |
                  [
                    {
                      "id": 1,
                      "name": "Fire Department",
                      "amount": 85.00,
                      "date": "2018-07-01T00:00:00.000+0000"
                      "description": "Ladder Truck",
                      "quantity": 1
                    }
                  ]
    /{description}:
      get:
        description: get all expenses matching the given description.
        queryParameters:
          start:
            displayName: Start Date
            type: date-only
            description: Only show expenses starting on this date.
            example: 2019-01-01
          end:
            displayName: End Date
            type: date-only
            description: Only show expenses ending on this date.
            example: 2019-03-31
        responses:
          200:
            body:
              application/json:
                example: |
                  [
                    {
                      "id": 4,
                      "name": "Fire Department",
                      "amount": 45.00,
                      "date": "2019-04-01T00:00:00.000+0000",
                      "description": "pencil",
                      "quantity": 30
                    },
                    {
                      "id": 3,
                      "name": "Fire Department",
                      "amount": 35.00,
                      "date": "2019-01-01T00:00:00.000+0000",
                      "description": "pencil",
                      "quantity": 30
                    },
                    {
                      "id": 2,
                      "name": "Fire Department",
                      "amount": 40.00,
                      "date": "2018-10-01T00:00:00.000+0000",
                      "description": "pencil",
                      "quantity": 30
                    }
                  ]
    /{id}:
      get:
        description: get expense by id.
        responses:
          200:
            body:
              application/json:
                example: |
                  {
                    "id": 1,
                    "name": "Fire Department",
                    "amount": 85.00,
                    "date": "2018-07-01T00:00:00.000+0000"
                    "description": "Ladder Truck",
                    "quantity": 1
                  }
      put:
        description: overwrite an expense
        body:
          application/json:
            example: |
              {
                "name": "Fire Department",
                "amount": 799.00,
                "date": "2019-04-01"
              }
        responses:
          200:     
      delete:
        description: delete an expense
        responses:
          204:
```

# Stock RAML

```
#%RAML 1.0
title: Stock
/stock:
  post:
    description: Add a stock
    body:
      application/json:
        example: |
          {
            "tickerSymbol": "AAPL",
            "name": "Apple Inc.",
            "stockPrice": 800.00,
            "sharesOwned": 100.00
          }
    responses:
      201:
  /{organization}:
    get:
      responses:
        200:
          body:
            application/json:
              example: |
                [
                  {
                    "tickerSymbol": "AAPL",
                    "name": "Apple Inc.",
                    "stockPrice": 800.00,
                    "sharesOwned": 100.00
                  },
                  {
                    "tickerSymbol": "GOG",
                    "name": "oo",
                    "stockPrice": 750.00,
                    "sharesOwned": 95.00
                  },
                  {
                    "tickerSymbol": "AAPL",
                    "name": "Apple Inc.",
                    "stockPrice": 900.00,
                    "sharesOwned": 120.00
                  },
                  {
                    "tickerSymbol": "AAPL",
                    "name": "Apple Inc.",
                    "stockPrice": 820.00,
                    "sharesOwned": 110.00
                  }
                ]
    /{organization}/{tickersymbol}:
      get:
        responses:
          200:
            body:
              application/json:
                example:
                    {
                      "tickerSymbol": "AAPL",
                      "name": "Apple Inc.",
                      "stockPrice": 800.00,
                      "sharesOwned": 100.00
                    }
      put:
        description: overwrite a stock
        body:
          application/json:
            example: |
              {
                "tickerSymbol": "AAPL",
                "name": "Apple Inc.",
                "stockPrice": 800.00,
                "sharesOwned": 100.00
              }
        responses:
          200:     
      delete:
        description: delete a stock
        responses:
          204:
```
