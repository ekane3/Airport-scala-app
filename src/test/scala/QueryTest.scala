import org.scalatest.funsuite.AnyFunSuite

/**
*@author: EKANE & NZEKET
*@version: 1.0
*/

class QueryTest extends AnyFunSuite {

  test("Query.getCountryName") {
    assert(Query.countryFromPartialName("Indi") == "India")
    assert(Query.countryFromPartialName("Gree") == "Greenland")
  }
  test("Query.getCountryCode") {
    assert(Query.deriveCountryCode("United States") == "US")
    assert(Query.deriveCountryCode("Japan") == "JP")
  }
}