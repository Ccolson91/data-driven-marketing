
//let button = document.getElementById("submitBtn");
//
//async function addCustomer(){
//
//let firstName = document.getElementById("firstName").value;
//let lastName = document.getElementById("lastName").value;
//let phoneNumber = document.getElementById("phoneNumber").value;
//let email = document.getElementById("email").value;
//let hairColor = document.getElementById("hairColor").value;
//
//    let headers = {
//        "Content-Type": "application/json",
//        "Api-Token": "8b58f7a664289ab530a593108a10744ac9a0763f5b9fce7d8efbe656777dd1184297eec9"
//    }
//
//
//    let customer = {
//        contact: {
//            email: email,
//            firstName: firstName,
//            lastName: lastName,
//            phone: phoneNumber,
//            hairColor: hairColor
//        }
//    }
//    console.log(customer)
//
//    let response = await fetch('https://hometownpromotionsllc.api-us1.com/api/3/contacts', {
//        method: 'POST',
//        headers: headers,
//        body: JSON.stringify(customer)
//    });
//
//}

//    let response = axios.post('https://hometownpromotionsllc.api-us1.com/api/3/contacts', {
//        headers: headers,
//        body: customer
//    })
//    }
//    .catch(e) {
//
//    };
//
//    let result = await response.json();
//    console.log(result)
//
//}
//
//button.addEventListener("click", addCustomer());
//
//addCustomer("Cami", "Cambridge", "5555555555", "cc@kk.com");
//addCustomer();