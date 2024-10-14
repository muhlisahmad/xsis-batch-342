// // console.log(dummy);

// // var dummy = "lorem ipsum";

// // console.log(dummy);

// for (let i = 0; i < 10; i++) {
//   console.log(`this is from for loop : ${i}`);
// }

// // console.log(i);

// const sebuahFunction = function(param1) {
//   console.log(param1);
// }

// const arrow2 = (param) => console.log(param)

// const arrowFunction = (param1) => {
//   console.log(param1);
// }

// const dummyArray = ["lklk", "knkkjn", 3123, 423, true];
// dummyArray.forEach(m => console.log(m));
// dummyArray.forEach((m, i) => console.log(`${m}, ${i}`));
// dummyArray.forEach(function(m) {console.log(m)});

// for (let index = 0; index < dummyArray.length; index++) {
//   console.log(dummyArray[index]);
// }

// // final String dummyString = "lklkm";

// const dummyString = "lkllkmlk";

// const dummyObject = {
//   name: "Alichwan",
//   dob: "2002-03-04",
//   makan(makanan) {
//     console.log(`ali makan ${makanan}`)
//   }
// }


const intArray = [1, 2, 3, 4, 5, 6, 7, 8, 9];

const arrBaru = intArray.map(e => e * 2);

intArray.forEach((e, idx, arr) => {
  console.log(`index ke-${idx} dari array ${arr} adalah ${e}`);
})

const filteredArray = intArray.find(val => val > 3);
console.log(filteredArray);

const dummyObject = {
  status: "success",
  error: false,
  code: 200,
  data: null
}


// console.log(intArray);
// console.log(arrBaru);
// higher order function