# Mule Endpoints

## Finance
```
/finances/{departmentid}/{timeframe}

/assets/{departmentid}
```

## Department
```
/departments/{type}

/invoice/{departmentid}?email={email}
```

## Security
```
/login/{username}/{password}
```

## Stock Portfolio JSON Example
```
[{
name:"Fire Department",
ticket-symbol:"google",
shares:60000,
purchaseprice:180.00
}, 
{
name:"Police Department",
ticket-symbol:"aapl",
shares:50000,
purchaseprice:200.00
}]
```

## Funds JSON example
```
{
name:"fire",
amount:1.00,
date:"2019-04-01"
}
```

## Expenses JSON Examples
```
{
name:"fire",
amount:1.00,
date:"2019-04-01"
}
```
