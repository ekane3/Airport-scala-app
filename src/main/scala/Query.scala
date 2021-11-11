import MainEntry._
import scala.util.Try
import scala.io.StdIn
import AirportAndRunways._

/**
*@author: EKANE & NZEKET
*@version: 1.0
*/

object Query{

    /*
    * @TODO : A function that takes user input and return country code if country entered
    */
    def readQueryUserInput(userInput: String = "Please Enter a Country Code or Country Name \n" ): String = StdIn.readLine(userInput) match {
        case "" => readQueryUserInput(userInput)
        case x  => deriveCountryCode(x.toUpperCase())
    }
    /*
    * @TODO : A function that derive the country from supplied country code or country name or partial country name using fuzzy matching logic.
    * As of now just a unique set of fuzzy names are implemented.
    */
    def deriveCountryCode(passedInput: String): String = passedInput.length match {
        case 2 => passedInput
        case _ => getCountryCode(countryFromPartialName(passedInput))
    }

    /**
    * @TODO : A fuzzy matching logic method to interpret/find the name from partial or full supplied names.
    */
    def countryFromPartialName(passedInput: String, matchLogic: String = "FULL"): String = matchLogic match {
        case "FULL" => Try {
        countriesData.find{ _.split(",")(2).toLowerCase() == passedInput.toLowerCase() }.map{ _.split(",")(2) }.toList.head}.getOrElse(countryFromPartialName(passedInput, "PARTIAL"))
        case "PARTIAL" => Try {
        countriesData.find { _.split(",")(2).substring(0, passedInput.length).toLowerCase() == passedInput.toLowerCase() }.
            map { _.split(",")(2) }.toList.head
        }.getOrElse(countryFromPartialName(passedInput, "UNMATCHED"))
        case _ => ""
    }

    /*
    * @TODO : A function to combine all the above functions.
    */
    def getAirtportsWithRunways(inputCountryCode: String): List[AirportAndRunways] = {
        // country, airport name, airport identifier and runways
        
        val countryName:String = getCountryName(inputCountryCode)

        val ListOfAirports:List[AirportAndRunways] = 
                            airportsData.filter{ _.split(",")(8) == inputCountryCode}
                                         .map { x => AirportAndRunways(countryName, x.split(",")(3), x.split(",")(1)) }.toList
        val ListOfRequiredAirports:List[String] = ListOfAirports.map{ x => x.airportIdentifier}
        val ListOfRequiredRunways:List[String] = runwaysData.filter{ x=> ListOfRequiredAirports.contains(x.split(",")(2))}.toList

   
        ListOfAirports.map{
            x =>  
            val runwaysList: List[String] = ListOfRequiredRunways.filter { _.split(",")(2) == x.airportIdentifier }.toList
            x.copy(runways = runwaysList)
        }
    }

    /*
    * @TODO: Print all informations
    */
    def showAirportsAndRunways(AirportsList:List[AirportAndRunways]):Unit={
        AirportsList.size match {
            case 0 => println("No Airports Found")
            case _ => AirportsList.foreach{ x => println(x.country + "," + x.airportName + "," + x.airportIdentifier + "," + x.runways)}
        }
    }

}
