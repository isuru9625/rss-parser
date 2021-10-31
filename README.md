**RSS-PARSER**
----
  This is a Spring Boot application that polls a RSS feed every 5 minutes, and stores any items or updates or in an in-memory database, H2. This application exposes     end points to get the latest 10 items of rss feed in the database.
  
* **URL**

  http://{host}:{port}/v1/rssFeed/items
  
  eg: - http://localhost:8080/v1/rssFeed/items

* **Method:**

  `GET`
  
*  **URL Params**

  There are 4 url params related to this end point which can be used to filter out the rss feed entries. But all those parameters are optional.
  
   **Required:**
 
   No required params

   **Optional:**
 
   `page=[alphanumeric]` (default = 0) - page number which can be used to get the entries in that page when considering pagination.
   
   `size=[alphanumeric]` (default = 10) number of entires which should be loaded into the get request
   
   `direction=[char]`(default = 'dsc') 
   
   `sort=[char]`


* **Data Params**

  No any data params since it is only get rquests
  
* **Success Response:**
  
  <_What should the status code be on success and is there any returned data? This is useful when people need to to know what their callbacks should expect!_>

  * **Code:** 200 <br />
    **Content:** `{ id : 12 }`
 
* **Error Response:**

  <_Most endpoints will have many ways they can fail. From unauthorized access, to wrongful parameters etc. All of those should be liste d here. It might seem repetitive, but it helps prevent assumptions from being made where they should be._>

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "Log in" }`

  OR

  * **Code:** 422 UNPROCESSABLE ENTRY <br />
    **Content:** `{ error : "Email Invalid" }`

* **Sample Call:**

  <_Just a sample call to your endpoint in a runnable format ($.ajax call or a curl request) - this makes life easier and more predictable._> 

* **Notes:**

  <_This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here._> 
