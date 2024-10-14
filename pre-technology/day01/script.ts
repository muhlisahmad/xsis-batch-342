const dummyNumber: number = 333;
const dummyNumber2: number = 33.3;

console.log(dummyNumber);
console.log(dummyNumber2);

const dummyArray: string[] = ["lklkmda", "dsadadaw"];

const secondaryArray: string[] = dummyArray.map((value, id) => `${id}: ${value}`);
console.log(dummyArray);
console.log(secondaryArray);

const arrow: () => string = () => {
  return "sdadad";
}