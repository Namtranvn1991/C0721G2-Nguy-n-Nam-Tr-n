var fibonacci = [0, 1];
function listFibonacci(num) {
    for (var i = 1; i < num; i++) {
        fibonacci.push(fibonacci[i] + fibonacci[i - 1]);
    }
    console.log(fibonacci);
    return fibonacci;
}
var total = 0;
listFibonacci(5).forEach(function (value) { return total += value; });
console.log(total);
function Fibonacci(n) {
    if (n == 1 || n == 2) {
        return 1;
    }
    return Fibonacci(n - 1) + Fibonacci(n - 2);
}
var number = 3;
console.log(Fibonacci(number));
