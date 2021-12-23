let login_form = document.getElementById("update-details");

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    //this two lines are used for prevent submission after first time clicking submit
    //so basically it prevents overlapping submission
    if (login_form.checkValidity() === true) {
        document.getElementById("submit-button");
        // document.getElementById("spinner-button");
        let response = await fetch('api/admin/update', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                roll: document.getElementById('roll').value,
                dom_id: document.getElementById('dom_id').value,

            })
        });
        let result = await response;
        console.log(response);
        if (result['status'] === 200)
        {
            console.log("Entered success page ");
            await fetch_values();

            document.getElementById("success-alert").style.display = "block";
        }
        else
        {
            console.log("Entered else part ");
            document.getElementById("error-alert").style.display = "block";
        }
    }
});
