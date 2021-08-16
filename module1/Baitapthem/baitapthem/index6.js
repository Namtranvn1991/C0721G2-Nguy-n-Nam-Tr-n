function result() {
    let myName = document.getElementById("myName").value;
    let hobby = document.getElementsByName("hobby");
    let kqua = "";
    for ( let i = 0; i < hobby.length; i++) {
        if (hobby[i].checked===true){
            kqua += "["+hobby[i].value+"]";
        }
    }
    alert("Sở thích của " + myName + " là " + kqua);
    let qqq = document.getElementById("myName")
    let qq = qqq.innerHTML;
    console.log(qq);
}