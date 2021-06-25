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

**Corporates**
- Get all bank corporates
> GET /api/v1/corporates/bank
- Get all digital wallet corporates
> GET /api/v1/corporates/wallet
- Get corporate by ID
> GET /api/v1/corporates/{corporateId}
