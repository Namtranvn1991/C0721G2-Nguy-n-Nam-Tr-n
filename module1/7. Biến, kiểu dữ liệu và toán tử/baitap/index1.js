let amount;
let from;
let to;
let result;
function convert() {
    amount = document.getElementById("amount").value;
    from = document.getElementById("from").value;
    to = document.getElementById("to").value;
    if (amount<0){alert("nhập lại giá trị lớn hơn 0")};
    if (from=="VND"&&to=="USD"){
        result=amount/20000;
        document.getElementById("result").innerText = result.toLocaleString() + "USD";}
    else if (from=="VND"&&to=="JPY"){
        result=amount/200;
        document.getElementById("result").innerText = result.toLocaleString() + "JPY";}
    else if (from=="USD"&&to=="VND"){
        result=amount*20000;
        document.getElementById("result").innerText = result.toLocaleString() + "VND";}
    else if (from=="USD"&&to=="JPY"){
        result=amount*200;
        document.getElementById("result").innerText = result.toLocaleString() + "JPY";}
    else if (from=="JPY"&&to=="USD"){
        result=amount/200;
        document.getElementById("result").innerText = result.toLocaleString() + "USD";}
    else if (from=="JPY"&&to=="VND"){
        result=amount*200;
        document.getElementById("result").innerText = result.toLocaleString() + "VND";}
    else (alert("Trùng đơn vị"));
}