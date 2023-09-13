# tenant-service
Tenant Service provides APIs to create tenants and also an API to get all the tenants with data sources for the tenants.

Before starting the Tenant Service we need start the `postgres` at port `5432` with username - `postgres` and password - `password123`. 
If you're using docker
  
  `docker run -itd -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password123 -p 5432:5432 -v /data:/var/lib/postgresql/data --name postgresql postgres`

Then you can start the `tenant-service.

You can create the tenants as shown below.

![image](https://github.com/sancs890/tenant-service-2/assets/39801950/6434de09-9e02-47b2-8180-2758f8472f15)

You can use get API to list all the tenants.

![image](https://github.com/sancs890/tenant-service-2/assets/39801950/38bc678a-d40d-446f-aefd-599882ac18e3)





