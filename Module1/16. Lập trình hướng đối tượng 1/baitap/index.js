let main = document.getElementById("main");

class MobilePhone {
    constructor(name) {
        this.name = name;
        this.draft = [];
        this.inbox = [];
        this.send = "";
        this.sent = [];
        this.battery = 100;
        this.onOff = true;
    }


    setMobile() {
        let status;
        if (this.onOff) {
            status = 'On'
        } else {
            status = "Off"
        }
        let data = '<div id="phone ' + this.name + '">'
        data += '<div><h2> ' + this.name + '</h2><span>' + this.battery + '</span><span>' + status + '</span></div>'
        data += "<div>"
        data += '<button onclick="turnon(' + this.name + ')">Turn On</button>'
        data += '<button onclick="turnoff(' + this.name + ')">Turn Off</button>'
        data += '<button onclick="charge(' + this.name + ')">Charge</button>'
        data += "</div>"
        data += "<div>"
        data += '<button onclick="">Write Messenge</button>'
        data += '<input id="phone' + this.name + '" type="text">'
        data += '<button onclick="">Send Messenge</button>'
        data += "</div>"
        data += "<div>"
        data += '<button onclick="">Inbox</button>'
        data += '<button onclick="">Sent</button>'
        data += '<button onclick="">Draft</button>'
        data += "</div>"
        data += "</div>"
        data += "</div>"
        main.innerHTML = main.innerHTML + data;
    }

    checkBattery() {
        if (this.battery < 0) {
            this.turnOff();
            return this.battery = 0;
        }
    }

    turnOn() {
        this.onOff = true;
        console.log(this.onOff)
    }

    turnOff() {
        this.onOff = false;
        console.log(this.onOff)
    }

    charge() {
        while (this.battery <= 100) {
            this.battery = this.battery + 0.01;
        }
    }

    setBattery(n) {
        this.battery = n;
        this.checkBattery();
    }

    writeMessenge() {
        if (this.onOff) {
            let text = prompt("nhập tin nhắn");
            let saveConfirm = confirm("bạn có muốn lưu tin nhắn");
            if (saveConfirm) {
                this.draft.push(text)
                let sendConfirm = confirm("bạn có muốn gởi tin nhắn này?");
                if (sendConfirm) {
                    this.setMessenge(text);
                    this.draft.pop()
                }
            }
            this.battery--;
        }
        this.checkBattery()
    }

    setMessenge(text) {
        if (this.onOff) {
            this.send = text;
            this.battery--;
        }
        this.checkBattery()
    }

    sendMessenge(mobilePhone) {
        if (this.onOff) {
            mobilePhone.receiveMessenge(this, this.send);
            this.sent.push("Đã gởi tin nhắn " + this.send + " đến điện thoại " + mobilePhone.name);
            this.send = "";
            this.battery--;
        }
        this.checkBattery()
    }

    receiveMessenge(mobile, message) {
        if (this.onOff) {
            this.inbox.push(mobile.name + " đã gởi tin nhắn " + message)
            this.battery--;
        }
        this.checkBattery()
    }

    readInbox() {
        if (this.onOff) {
            let data = "";
            for (let i = 0; i < this.inbox.length; i++) {
                data += [i] + " : " + this.inbox
            }
            return data;
            this.battery--;
        }
        this.checkBattery()
    }

    readSent() {
        if (this.onOff) {
            let data = "";
            for (let i = 0; i < this.sent.length; i++) {
                data += [i] + " : " + this.sent
            }
            return data;
            this.battery--;
        }
        this.checkBattery()
    }

    readDraft() {
        if (this.onOff) {
            let data = "";
            for (let i = 0; i < this.draft.length; i++) {
                data += [i] + " : " + this.draft;
            }
            return data;
            this.battery--;
        }
        this.checkBattery()
    }

}

let phone = Array();
let Ip = new MobilePhone("Ip");
let Android = new MobilePhone("Android");

ip.setMobile();
phone.push(ip);
android.setMobile();
phone.push(android);


// function turnoff(Ip) {
//     phone[0].turnOff()
//     console.log(Ip.onOff)
// }



function turnon(name) {
name.turnOn();
}

// function turnoff(name) {
//     for (let i = 0; i < phone.length; i++) {
//         if (name == phone[i].name) {
//             phone[i].turnOff();
//             console.log(phone[i].onOff)
//         }
//     }
// }

function charge(name) {
    for (let i = 0; i < phone.length; i++) {
        if (name == phone[i].name) {
            phone[i].charge()
        }
    }
}


