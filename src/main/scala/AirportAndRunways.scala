/**
*@author: EKANE & NZEKET
*@version: 1.0
*/

/**
 * Creating a case class for Airports with country, airport name, identifier and runways.
 */
case class AirportAndRunways(country: String, airportName: String, airportIdentifier: String, runways: List[String] = List[String]())
