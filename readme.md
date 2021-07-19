# Project Details
### API Specifications

**Customers Endpoints**
- Create new customers
> POST /api/v1/customers
- Find by ID card number or account number
> GET /api/v1/customers/find?idCardNumber=&accountNumber=

**Accounts Endpoints**
- Create new accounts
> POST /api/v1/accounts?customerId={}
- Get account details by account number
> GET /api/v1/accounts/{accountNumber}
- Get account's transactions
> GET /api/v1/accounts/{accountNumber}/transactions

**Transfer Endpoints**
- Fund transfer
> POST /api/v1/transfers
- Fund transfer domestic
> POST /api/v1/transfers/domestic

**Top Up E-Wallet Endpoints**
- E-Wallet codes:
> - Gopay (9101)
> - OVO (9102)
> - Dana (9103)
> - Shopeepay (9104)
> - LinkAja (9105)
- Top Up E-Wallet with Virtual Account
> POST /api/v1/transfers/virtual

**Payment**
- Pay with QR
> POST /api/v1/payment/qr
- Pay mobile phone credit prepaid
> POST /api/v1/payment/mobile/prepaid/credit 
- Pay mobile phone data prepaid
> POST /api/v1/payment/mobile/prepaid/data
- Pay electricity prepaid
> POST /api/v1/payment/electricity/prepaid
- Pay electricity postpaid
> POST /api/v1/payment/electricity/postpaid

**Provider**
- Get all providers
> GET /api/v1/providers
- Get provider by ID
> GET /api/v1/providers/{providerId}
- Get provider by Prefix
> GET /api/v1/providers/find?prefixNumber=

**Prepaid**
- Get mobile phone credit prepaid options
> GET /api/v1/prepaid/mobile/credit
- Get mobile phone data prepaid options
> GET /api/v1/prepaid/mobile/credit
- Get electricity prepaid options
> GET /api/v1/prepaid/electricity  
- Get mobile phone credit prepaid option by ID
> GET /api/v1/prepaid/mobile/credit/{prepaidId}
- Get mobile phone data prepaid option by ID
> GET /api/v1/prepaid/mobile/data/{prepaidId}
- Get electricity prepaid option by ID
> GET /api/v1/prepaid/electricity/{prepaidId}

**Corporates**
- Get all bank corporates
> GET /api/v1/corporates/bank
- Get all digital wallet corporates
> GET /api/v1/corporates/wallet
- Get all merchant corporates
> GET /api/v1/corporates/merchant
- Get corporate by ID
> GET /api/v1/corporates/{corporateId}
