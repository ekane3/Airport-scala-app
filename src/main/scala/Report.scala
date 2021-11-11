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
    val AirportIdSurfaceType: Map[String, String] = runwaysData.map{ x => (x.split(",")(2), x.split(",")(5)) }.toMap

    /*
    * @TODO : Create a tuple containing country name with surface runway type using the airportIdSurfaceType map
    * and the getCountryName function to get name of the country using the airport_id
    */
    val CountryNameSurfaceType: List[(String, String)] = airportsData.map( x => ( getCountryName(x.split(",")(8) ), Try { AirportIdSurfaceType.get(x.split(",")(1)).get}.getOrElse("") )).toList

    /*
    * @TODO : Create a map of country with it sets of Runways surface type using airportSurfaceType
    *  We also filter countries not having surface type
    */

    val CountrySurfaceType: Map[String, Set[String]] = 
                CountryNameSurfaceType.groupBy(_._1)
                .filter( x => x._2.size > 1)
                .mapValues( x => x.map(_._2).toSet).toMap

    /*
    * @TODO: Get The top 10 most common runway latitude
    */
    val TopTenLatitude: List[String] = runwaysData.map( x => Try{x.split(",")(8)}.getOrElse(""))
                                                            .groupBy(identity)
                                                            .mapValues(_.size)
                                                            .toList
                                                            .sortWith(_._2 > _._2)
                                                            .take(10)
                                                            .map { case (id, count) => id }



    /*
    * @TODO: Print all informations
    */
    def showReport(){

    }
}