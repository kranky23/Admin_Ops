let login_form = document.getElementById("login-validation");

login_form.addEventListener('submit', async (e) =>
{
    e.preventDefault();
    e.stopPropagation();
    //this two lines are used for prevent submission after first time clicking submit
    //so basically it prevents overlapping submission
    if (login_form.checkValidity() === true) {
        document.getElementById("submit-button");
        // document.getElementById("spinner-button");
        let response = await fetch('api/admin/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                eid: document.getElementById('eid').value,
                pwd: document.getElementById('pwd').value,
            })
        });
        let result = await response;
        // let result=response;
        console.log(response);
        if(result['status'] === 200)
        // if(JSON.parse(document.getElementById('eid').value) === 1)
        {
            let data = await response.json();
            /*response.json() is a method on the Response object that lets you extract
            a JSON object from the response.
            The method returns a promise, so you have to wait for the JSON: await response.json().*/
            document.getElementById("submit-button");
            //document.getElementById("spinner-button");

            sessionStorage.setItem('id',data['id']);
            //this method will store the id in the session storage and we can use it for further use
            location.href = "UpdateOrView.html";
            console.log("if part");
        }
        else
        {
            // document.getElementById("submit-button");
            //document.getElementById("spinner-button");
            console.log("else part");
            // if(JSON.stringify(document.getElementById('pwd').value) != "")
            // document.getElementById("submit-button").style.display = "block";

                // document.getElementById("login-alert").style.display = "block";




        }
    }
});