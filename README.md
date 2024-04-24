# Introduction
I have an endpoint that allows for updates, and it needs to validate the lifecycle status to follow a specific flow. The flow implementation to achieve this lifecycle management process 

Microservice of a catalog element is started the first status is “In study”. 

When the conception of the catalog element is accepted, its status is changed to “In design”.

If the design is approved its status is changed to “In test”.


Then either the test is OK and then its status is changed to “Active” or the test falls and its status is changed to “Rejected”.

The "Rejected" status is a final status. 

When a catalog element is in a “Active” status it means, it has been validated and tested, but it is still not available for customers.

When the beginning of marketing is reached, its status is changed to “Launched”.

At this moment, customers can buy it.

If the catalog element is not launched, its status is changed to “Retired”.

The same status is achieved when a catalog element reaches the end of marketing.  

The “Retired” status means it cannot be sold to any new customers, but previous customers can still have it. 

When no more customer holds the catalog element, its status is changed to “Obsolete” meaning it can be removed from the catalog.

# Features <br/>
  - catalog element serivice


# Technologies Used: 

🔘   Spring-Boot 3 Micro-Services <br/>
🔘   Springframework 6 <br/>
🔘   Spring-Data <br/>
🔘   Hikari Connection Pool <br/>
🔘   Hibernate - ORM <br/>
🔘   H2 Database <br/>

# Domain Knowledge: 
Retail - Business to Customer (B2C)

# Contact:

Cell : +27 (0) 71 741 6469 <br/>
📧 e-mall : mandisamkhungo@live.com <br/>
