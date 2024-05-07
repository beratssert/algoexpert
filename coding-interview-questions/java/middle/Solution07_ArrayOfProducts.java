class Program {
  // O(n) time | O(n) space - n is the length of the array.
  public int[] arrayOfProducts(int[] array) {
    int[] productedArray = new int[array.length];

    int leftProduct = 1;
    for (int i = 0; i < array.length; i++) {
      productedArray[i] = leftProduct;
      leftProduct *= array[i];
    }

    int product = 1;
    for (int i = array.length - 1; i >= 0; i--) {
      productedArray[i] *= product;
      product *= array[i];
    }

    return productedArray;
  }

  // O(n^2) time | O(n) space - n is the length of the array.
  // public int[] arrayOfProducts(int[] array) {
  // int[] productedArray = new int[array.length];
  // for (int i = 0; i < array.length; i++) {
  // int product = 1;
  // for (int j = 0; j < array.length; j++) {
  // if (i != j) {
  // product *= array[j];
  // }
  // }
  // productedArray[i] = product;
  // }

  // return productedArray;
  // }
}
