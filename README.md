**Run The Application**

  clone the repository, https://github.com/isuru9625/rss-parser.git and run ResParserApplication.java. The default port is 8080.
  And the documentation of this application is shown in below. 


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
 
    `page=[alphanumeric]` (default = 0) - page number which can be used to get the entries in that page when considering pagination.
   
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

  * **Code:** 404 Not Found <br />
    **Content:** `{ error : "Log in" }`


* **Sample Call:**

  http://localhost:8080/v1/rssFeed/items
  
  http://localhost:8080/v1/rssFeed/items?page=0&size=2&sort=publicationDate&direction=dsc
  

* **Suggestions:**
  
  Better to remove html tags from the response description
  
  More parameter can be introduced in the end points to get more specific records
  
  Further exceptions handling can be done
  
  Can use different log levels
  
  Can improve unit tests in different other paths
  
  
  
