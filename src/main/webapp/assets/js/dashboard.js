let detailsUpdate = document.getElementById("details");
window.onload = fetch_values;


detailsUpdate.addEventListener('submit', async (e) => {
    let kaushik;

    e.preventDefault();
    e.stopPropagation();
    console.log("Event occured");
    if (detailsUpdate.checkValidity() === true) {
        document.getElementById("submit-button");
        // document.getElementById("spinner-button").style.display = "block";
        let response = await fetch('api/admin/view', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                dom_id: document.getElementById('dom_id').value,
            })
        });
        let result = await response;
        console.log(response);
        const data = await response.json();
        console.log(data);
        if (result['status'] === 200)
            // if(JSON.parse(document.getElementById('contact').value) === 1)
        {
            this.kaushik = data;
            // document.getElementById("name") = 1;
            console.log(this.kaushik);
            console.log("paina di")

            // let display = function()
            // {
            this.kaushik.forEach(function (i) {
                document.getElementById("domStu").innerHTML +=
                    i.roll + "<span style='padding-left: 90px' />" +
                    i.name + "<span style='padding-left: 50px' />" +
                    i.dom_id + "<span style='padding-left: 70px' />" +
                    i.qualification + "<br />";
            })


            //     return 'some value';
            // };


            // document.getElementById("name").value = display();


            document.getElementById("submit-button").style.display = "block";
            // document.getElementById("spinner-button").style.display = "none";
            document.getElementById("success-alert-1").style.display = "block";
        } else if (JSON.parse(document.getElementById('contact').value) === 2) {
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("success-alert-2").style.display = "block";
        } else {
            document.getElementById("submit-button").style.display = "block";
            // document.getElementById("spinner-button").style.display = "none";

            document.getElementById("error-alert").style.display = "block";
        }
    }
});


async function fetch_values() {
    document.getElementById("success-alert").style.display = "none";
    document.getElementById('error-alert').style.display = "none";
    if (!sessionStorage.getItem('id')) {
        //getting the id from the session local storage
        // location.href = "index.html";
        return;
    }
    console.log(sessionStorage.getItem('id'));
    let response = await fetch("api/admin/update", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: sessionStorage.getItem('id'),
        })
    });
    let result = await response;
    console.log(response);
    // if(result['status'] === 200)
    if (JSON.parse(document.getElementById('contact').value) === 1) {
        console.log("kindadi");
        let data = await response.json();
        //this is to fill the values originally there before add update delete
        document.getElementById("contact").value = data['dom_id'];
    } else {
        document.getElementById("error-alert").style.display = "block";
    }
}
