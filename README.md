# sec_c_sec_c_joel.premkumar__corejava_project_2

<div align="center">
  <img src="er_image/stock_module.png" alt=" \Database Design" width="60%">
</div>

## Stock Table

This table stores information about stocks.

## Stock Table Schema

| Field Name          | Data Type         | Constraints                            |
|---------------------|-------------------|----------------------------------------|
| id                  | INT               | AUTO_INCREMENT, PRIMARY KEY            |
| stockName           | VARCHAR(30)       | NOT NULL, UNIQUE                       |
| isin                | VARCHAR(20)       | NOT NULL                               |
| descrip             | VARCHAR(500)      | NOT NULL                               |
| price               | DOUBLE            | NOT NULL                               |
| creation_date_time  | TIMESTAMP         | DEFAULT CURRENT_TIMESTAMP              |
| expire_date_time    | TIMESTAMP         | DEFAULT CURRENT_TIMESTAMP                                       |
