## Airport scala App
#### *Programming Language: **Scala***
<br>

### 📖 Description
This is a console scala app that uses data from 3 csv files airports.csv, runways.csv and airlines.csv that are located in the src/main/data folder to enable a user to search for an airport and its associated runways and airlines information and to display some other basic informations.
<br>

> The approach used here is a functional programming approach. Click [here](https://docs.scala-lang.org/overviews/scala-book/functional-programming.html) to know more about functional programming. 

So the app has two parts : query and report.
- Query :  
    - User enters a country name or code and the app displays the airport & runways at each airport. (See screesnshots below)
    - User can also enter a partial country name because the query supports matching partial/fuzzy names. e.g. entering zimb will result in Zimbabwe
- Report:
    - The app displays the top 10 countries with the highest number of airport. (See screenshots below)
    - The app displays the bottom 10 countries with the lowest number of airport.
    - The app displays type of runways per country
    - The app displays the top 10 most runway latitude

<br>

### ✔️ How to run the app
 - Clone the app using the following command: ``git clone https://github.com/ekane3/Airport-scala-app.git``
 - Go to the app folder and run the following command: `` sbt run ``  (or `` sbt clean compile run `` if you want to clean the project before running it)  
 The app will run in the terminal.
 - To run tests, go to the app folder and run the following command: ``sbt test`` 

<br>

### 🖼️ Some screenshots of the app
<br>

- Running the app:  
    - Menu : choose query or report  

    <img src="src/main/images/capture_menu.png" alt="Screenshot of tests - sbt test" style="margin: 10px;" />  

    If user enters query we have  the following 👇 :

    - Query :  
    <img src="src/main/images/capture_query.png" alt="Screenshot of tests - sbt test" style="margin: 10px;" />  
    - Report :  
    <img src="src/main/images/capture_report.png" alt="Screenshot of tests - sbt test" style="margin: 10px;" /> 

<br>

- Running the tests:  

<img src="src/main/images/capture_test.png" alt="Screenshot of tests - sbt test" style=" margin: 10px;" />
