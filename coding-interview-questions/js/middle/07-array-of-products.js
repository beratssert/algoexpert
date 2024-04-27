// O(n) time | O(n) space
function arrayOfProducts(array) {
  const products = new Array(array.length).fill(1);

  let leftProduct = 1;
  for (let i = 0; i < array.length; i++) {
    products[i] = leftProduct;
    leftProduct *= array[i];
  }

  let rightProduct = 1;
  for (let i = array.length - 1; i >= 0; i--) {
    products[i] *= rightProduct;
    rightProduct *= array[i];
  }

  return products;
}

// function arrayOfProducts(array) {
//   const products = new Array(array.length).fill(1);
//   const leftProducts = new Array(array.length).fill(1);
//   const rightProducts = new Array(array.length).fill(1);

//   let leftProduct = 1;
//   for (let i = 0; i < array.length; i++) {
//     leftProducts[i] = leftProduct;
//     leftProduct *= array[i];
//   }

//   let rightProduct = 1;
//   for (let i = array.length - 1; i >= 0; i--) {
//     rightProducts[i] = rightProduct;
//     rightProduct *= array[i];
//   }

//   for (let i = 0; i < array.length; i++) {
//     products[i] = leftProducts[i] * rightProducts[i];
//   }

//   return products;
// }

// function arrayOfProducts(array) {
//   const result = [];

//   let product = 1;
//   let productWithoutZero = 1;
//   let counter = 1;
//   for (let value of array) {
//     if (value === 0 && counter < 2) {
//       product *= value;
//       counter++;
//     } else {
//       product *= value;
//       productWithoutZero *= value;
//     }
//   }

//   for (let value of array) {
//     const num = value === 0 ? productWithoutZero : product / value;
//     result.push(num);
//   }

//   return result;
// }

console.log(arrayOfProducts([5, 1, 4, 2]));
