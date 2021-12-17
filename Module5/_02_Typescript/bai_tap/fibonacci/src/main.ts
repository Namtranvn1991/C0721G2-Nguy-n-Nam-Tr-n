let fibonacci = [0,1];

function listFibonacci(num:number) {
    for (let i = 1; i < num; i++) {
        fibonacci.push(fibonacci[i] + fibonacci[i - 1]);
    }
    console.log(fibonacci);
    return fibonacci;
}

let total = 0;
listFibonacci(5).forEach(value => total+=value);
console.log(total)



function Fibonacci(n:number):number {
    if(n ==1 || n ==2){
        return  1;
    }
    return Fibonacci(n-1) + Fibonacci(n-2);

}
let number: number = 3;
console.log(Fibonacci(number));
