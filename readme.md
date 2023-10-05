# Spring and Infinispan Rest API Integration

## Table Structure
Using a MySql table
```sql
create table t_gen
(
    bank_id           int           not null,
    sub_account_code  varchar(16)   null,
    sub_description   varchar(100)  null,
    fi_bank           char(3)       null,
    priority          int           null,
    bank_code         char(3)       null,
    bank_branch       varchar(100)  null,
    bank_account_no   varchar(30)   null,
    bank_account_name varchar(100)  null,
    currency_code     char(3)       null,
    fi_plafond        bigint        null,
    bank_fee          decimal(9, 6) null,
    contact_person    varchar(100)  null,
    contact_telephone varchar(50)   null,
    email             varchar(100)  null,
    record_status     varchar(1)    null,
    constraint t_gen_bank_id_uindex
        unique (bank_id)
);

alter table t_gen
    add primary key (bank_id);

INSERT INTO db_test.t_gen (bank_id, sub_account_code, sub_description, fi_bank, priority, bank_code, bank_branch, bank_account_no, bank_account_name, currency_code, fi_plafond, bank_fee, contact_person, contact_telephone, email, record_status) VALUES (1, 'SUB_01', 'DESC_01', 'FIB', 3, 'COD', 'BRANCH_01', '0001', 'ACCT_NAME', 'IDR', 1000000, 100.766510, 'CP', '08111111', 'email@email.com', 'Y');

INSERT INTO db_test.t_gen (bank_id, sub_account_code, sub_description, fi_bank, priority, bank_code, bank_branch, bank_account_no, bank_account_name, currency_code, fi_plafond, bank_fee, contact_person, contact_telephone, email, record_status) VALUES (2, 'SUB_02', 'DESC_02', 'FIC', 2, 'DOL', 'BRANCH_02', '0002', 'ACCT_002', 'USD', 2000, 15.244310, 'LE', '021524311', 'some@random.com', 'N');
```

## Infinispan Image
We are using a custom Infinispan with a mysql jdbc driver, 
```
$ docker build -t custom-infinispan-with-mysql .
```

## Build Jar File
```
$ mvn clean package -s settings.xml
```

## Create Proto Schema in Infinispan
We can import `GenMdBankDTO.proto` schema into Infinispan server by copying the content of `GenMdBankDTO.proto` into Infinispan's `Add Protobuf schema` 
![Create Protobuf Schema](image/proto01.png)

## Create Database connection
To create `some-cache` in Infinispan, we can use `create cache` menu and select `add cache configuration`, and copy the content of `some-cache.json` there. 
![create cache](image/proto02.png)

## How to Test
Get some data from `some-cache`
```
$ time curl -kv "http://localhost:8080/get-some-cache"

*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /get-some-cache HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.65.0
> Accept: */*
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Thu, 05 Oct 2023 07:51:52 GMT
<
* Connection #0 to host localhost left intact
{"1":{"bank_id":"1","sub_account_code":"SUB_01","sub_description":"DESC_01","fi_bank":"FIB","priority":3,"bank_code":"COD","bank_branch":"BRANCH_01","bank_account_no":"0001","bank_account_name":"ACCT_NAME","currency_code":"IDR","fi_plafond":"1000000","bank_fee":100.76651,"contact_person":"CP","contact_telephone":"08111111","email":"email@email.com","record_status":"Y"},"2":{"bank_id":"2","sub_account_code":"SUB_02","sub_description":"DESC_02","fi_bank":"FIC","priority":2,"bank_code":"DOL","bank_branch":"BRANCH_02","bank_account_no":"0002","bank_account_name":"ACCT_002","currency_code":"USD","fi_plafond":"2000","bank_fee":15.24431,"contact_person":"LE","contact_telephone":"021524311","email":"some@random.com","record_status":"N"}}

real 0m 0.13s
user    0m 0.04s
sys     0m 0.03s
```

Add some data
```
$ time curl -kv "http://localhost:8080/add-some-cache?bank_id=3&sub_account_code=SUB_03&sub_description=desc_03&fi_bank=III&priority=2&bank_code=BCA&bank_branch=BRANCH_03&bank_account_no=9181&bank_account_name=ACCT_03&currency_code=GBR&fi_plafond=5000&bank_fee=817.251514&contact_person=CP01&contact_telephone=8171625&email=edwin@redhat.com&record_status=1"
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /add-some-cache?bank_id=3&sub_account_code=SUB_03&sub_description=desc_03&fi_bank=III&priority=2&bank_code=BCA&bank_branch=BRANCH_03&bank_account_no=9181&bank_account_name=ACCT_03&currency_code=GBR&fi_plafond=5000&bank_fee=817.251514&contact_person=CP01&contact_telephone=8171625&email=edwin@redhat.com&record_status=1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.65.0
> Accept: */*
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Thu, 05 Oct 2023 07:51:00 GMT
<
* Connection #0 to host localhost left intact
{"bank_id":"3","sub_account_code":"SUB_03","sub_description":"desc_03","fi_bank":"III","priority":2,"bank_code":"BCA","bank_branch":"BRANCH_03","bank_account_no":"9181","bank_account_name":"ACCT_03","currency_code":"GBR","fi_plafond":"5000","bank_fee":817.251514,"contact_person":"CP01","contact_telephone":"8171625","email":"edwin@redhat.com","record_status":"1"}

real    0m 0.31s
user    0m 0.03s
sys     0m 0.06s
```