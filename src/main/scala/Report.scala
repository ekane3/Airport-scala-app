import  MainEntry._

/**
*@author: EKANE & NZEKET
*@version: 1.0
*/

object Report{

    /*
    * @TODO : Create a tuple of country name and the count of airports
    */
    val CountryAirportCount: List[(String, Int)] = airportsData.map(_.split(",")(8)).groupBy(identity).mapValues { _.size }.toList

    /**
    * @TODO : sort the List of country names with airport count in ascending and descending order
    */
    val TopCountries: List[(String, Int)] = CountryAirportCount.sortWith(_._2 > _._2)
    val BottomCountries: List[(String, Int)] = CountryAirportCount.sortWith(_._2 < _._2)

    /*
    * @TODO : Cut the first top 10 and last 10 countries from the sorted list
    */
    val TopTenAirportCountries: List[(String, Int)] = TopCountries.take(10).map( x=> (getCountryName(x._1), x._2))
    val BottomTenAirportCountries: List[(String, Int)] = BottomCountries.take(10).map( x=> (getCountryName(x._1), x._2))

    /*
    * @TODO : Create a tuple of airport_id and surface type
    */


    /*
    * @TODO : Create a tuple containing country name with surface runway type using the airportIdSurfaceType map
    * and the getCountryName function to get name of the country using the airport_id
    */

    /*
    * @TODO : Create a map of country with it sets of Runways surface type using airportSurfaceType
    *  We also filter countries not having surface type
    */


    /*
    * @TODO: Get The top 10 most common runway latitude
    */


    /*
    * @TODO: Print all informations
    */
    def showReport(){

    }
}