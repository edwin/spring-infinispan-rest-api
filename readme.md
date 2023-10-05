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