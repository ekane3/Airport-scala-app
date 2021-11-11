import org.scalatest.funsuite.AnyFunSuite


class MainEntryTest extends AnyFunSuite {

  test("MainEntry.getCountryName") {
    assert(MainEntry.getCountryName("US") == "United States")
    assert(MainEntry.getCountryName("JP") == "Japan")
  }
  test("MainEntry.getCountryCode") {
    assert(MainEntry.getCountryCode("United States") == "US")
    assert(MainEntry.getCountryCode("Japan") == "JP")
  }
}