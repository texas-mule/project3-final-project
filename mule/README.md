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

## Other server urls

Mule Server
```
http://texasmuleprod1.us-east-2.elasticbeanstalk.com/
```

Microservices
```
ec2-3-14-70-98.us-east-2.compute.amazonaws.com
```

Salesforce
```
DB3: project3-saleforce-test-3.cchrp7vuxlcj.us-east-2.rds.amazonaws.com
Port: 5432
```
