**RSS-PARSER**
----
  This is a Spring Boot application that polls a RSS feed every 5 minutes, and stores any items or updates or in an in-memory database, H2. This application exposes     end points to get the latest 10 items(In base scenario) of rss feed in the database.
  
* **URL**

  http://{host}:{port}/v1/rssFeed/items
    
  http://{host}:{port}/v1/rssFeed/items=?page=?&size=?&sort=?&direction=?
  

* **Method:**

  `GET`
  
*  **URL Params**

    There are 4 url params related to this end point which can be used to filter out the rss feed entries. But all those parameters are optional.
  
   **Required:**
 
    No required params

   **Optional:**
 
   ` page=[alphanumeric]` (default = 0) - page number which can be used to get the entries in that page when considering pagination.
   
   `size=[alphanumeric]` (default = 10) - number of entires which should be loaded into the get request
   
   `direction=[char]`(default = 'dsc') - whether it is in ascending order or descending order
   
   `sort=[char]`(default = 'publicationDate') - the parameter of sorting


* **Data Params**

  No any data params since it is only get rquests
  
* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** 
    
    	"id":2, "title":"The Sunday Read: “Fear on Cape Cod as Sharks Hunt Again”","description":"...", "author":"thedaily@nytimes.com (The New York      Times)","publicationDate":"2021-10-31T10:00:00.000+00:00","pollingEvent":"id":1,"updatedRowCount":1363,"updatedTime":"2021-10-31T17:16:54.790+00:00","feeds":null
 
* **Error Response:**

  <_Most endpoints will have many ways they can fail. From unauthorized access, to wrongful parameters etc. All of those should be liste d here. It might seem repetitive, but it helps prevent assumptions from being made where they should be._>

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "Log in" }`

  OR

  * **Code:** 422 UNPROCESSABLE ENTRY <br />
    **Content:** `{ error : "Email Invalid" }`

* **Sample Call:**

  http://localhost:8080/v1/rssFeed/items
  
  http://localhost:8080/v1/rssFeed/items?page=0&size=2&sort=publicationDate&direction=dsc
  

* **Notes:**

  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
