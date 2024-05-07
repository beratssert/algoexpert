class Program {
  // O(n) time | O(1) space - n is the number of the cities
  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    int distance = 0;
    int minDistance = 0;
    int startingCity = 1;
    for (int i = 0; i < fuel.length; i++) {
      int galoon = fuel[i];
      distance = distance + galoon * mpg - distances[i];

      if (distance < minDistance) {
        startingCity = i + 1;
        minDistance = distance;
      }

    }
    return startingCity;
  }

  // O(n^2) time | O(1) space - n is the number of the cities.
  // public int validStartingCity(int[] distances, int[] fuel, int mpg) {
  // int numberOfCities = distances.length;
  // for (int city = 0; city < numberOfCities; city++) {
  // int milesLeft = 0;
  // for (int j = city; j < city + numberOfCities; j++) {
  // int currentCityIdx = j % numberOfCities;

  // int milesToNextCity = distances[currentCityIdx];
  // milesLeft += fuel[currentCityIdx] * mpg - milesToNextCity;

  // if (milesLeft < 0)
  // break;
  // }

  // if (milesLeft >= 0)
  // return city;
  // }

  // return -1;
  // }
}
