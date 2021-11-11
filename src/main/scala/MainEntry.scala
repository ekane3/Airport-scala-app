import scala.io.Source
import java.io.File
import scala.io.StdIn
import Query._
import Report._

/**
*@author: EKANE & NZEKET
*@version: 1.0
*/


/**
 * Creating a case class for Airports with country, airport name, identifier and runways.
 */
//case class AirportAndRunways(country: String, airportName: String, airportIdentifier: String, runways: List[String] = List[String]())

object MainEntry{

    /*
    * @TODO: path to the csv files
    */
    val airportFile: String = "src/main/data/airports.csv"
    val countryFile: String = "src/main/data/countries.csv"
    val runwaysFile: String = "src/main/data/runways.csv"

    /*
    * @TODO : Load the csv files into variables
    */
    val airportsData: List[String] = Source.fromFile(new File(airportFile)).getLines.drop(1).toList map(_.replaceAll("\"", ""))
    val countriesData: List[String] = Source.fromFile(new File(countryFile)).getLines.drop(1).toList map { _.replaceAll("\"", "") }
    val runwaysData: List[String] = Source.fromFile(new File(runwaysFile)).getLines.drop(1).toList map { _.replaceAll("\"", "") }


    /*
    *  @TODO: Create a map of country code and country name
    *  CodetoCountryMap : This is a map of country code and country name
    *  This is used to get the country name from the country code
    *  CountrytoCodeMap : This is a map of country name and country code
    *  This is used to get the country code from the country name
    */
    val CodetoCountryMap: Map[String, String] = countriesData.map(x => x.split(",")).map(x => (x(1), x(2))).toMap
    val CountrytoCodeMap: Map[String, String] = countriesData.map(x => x.split(",")).map(x => (x(2), x(1))).toMap


    /*
    * @TODO : Function to get country name from country code
    */
     def getCountryName(countryCode: String): String = {
        if (CodetoCountryMap.contains(countryCode)) {
            CodetoCountryMap(countryCode)
        } else {
            "Country not found"
        }
    }

    /*
    * @TODO : Function to get country code from country name
    */
    def getCountryCode(countryName: String): String = {
        if (CountrytoCodeMap.contains(countryName)) {
            CountrytoCodeMap(countryName)
        } else {
            "Country not found"
        }    
    }

    /*
    * @TODO: Function that Reads the user input
    * Make sure that the user input is either query or report
    */
    def readUserInput(): String = {
        var userInput: String = ""
        do {
            userInput = StdIn.readLine("Please what do you want ? A QUERY or REPORTS \nEnter : \n\tquery : for query. e.g: list airports of a country \n\treport: to show fresh analysis of airports \n")
            userInput = userInput.toLowerCase()
        } while (!(userInput.equals("query") || userInput.equals("report")))
        userInput
    }

    /*
    * @TODO : Main function
    */
    def main(args: Array[String]): Unit = {
        // Main entry point for the program
        // This is where the user will interact with the program
        // The user will be asked to enter query or report
        // Lets make a pattern match on readUserInput 

        println("\n\n=============DEBUT=============")
        println("\nWelcome to the Airport Database\n")

        var userInput: String = readUserInput()
        userInput match {
            case "query" => {
                // User wants to query
                //showAirports(userInput)
                println("\n\n=============QUERY=============")
                showAirportsAndRunways(getAirtportsWithRunways(readQueryUserInput()))            }
            case "report" => {
                // User wants to report
                //showAir(userInput)
                println("\n\n=============REPORT=============")
                showReport()
            }

            case _ => {
                println("Invalid input")
            }

        }

    }









}