import scala.io.Source
import java.io.File
import scala.io.StdIn
import Query._
import Report._

object MainEntry{

    /*
    * @TODO : // Standard messages for user interaction
    */


    /*
    * @TODO: path to the csv files
    */


    /*
    * @TODO : Load the csv files into variables
    */


    /*
    *  @TODO: Create a map of country code and country name
    *  CodetoCountryMap : This is a map of country code and country name
    *  This is used to get the country name from the country code
    *  CountrytoCodeMap : This is a map of country name and country code
    *  This is used to get the country code from the country name
    */



    /*
    * @TODO : Function to get country name from country code
    */
     def getCountryName(countryCode: String): String = {
        
    }

    /*
    * @TODO : Function to get country code from country name
    */
    def getCountryCode(countryName: String): String = {
        
    }

    /*
    * @TODO: Function that Reads the user input
    * Make sure that the user input is either query or report
    */
    def readUserInput(): String = {
        
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
            }
            case "report" => {
                // User wants to report
                //showAir(userInput)
                println("\n\n=============REPORT=============")
                //showReport()
            }

            case _ => {
                println("Invalid input")
            }

        }

    }









}