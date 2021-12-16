let fibonacci = [0,1];

function listFibonacci(num:number) {
    // starting at array index 1, and push current index + previous index to the array
    for (let i = 1; i < num; i++) {
        fibonacci.push(fibonacci[i] + fibonacci[i - 1]);
    }
    console.log(fibonacci);
    return fibonacci;
}

let total = 0;
listFibonacci(5).forEach(value => total+=value);
console.log(total)

