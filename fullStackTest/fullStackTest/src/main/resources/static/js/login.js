$(document).ready(function () {

});

async function loginUser() {
  let data = {};
  data.email = document.getElementById('txtEmail').value;
  data.password = document.getElementById('txtPassword').value;

  const request = await fetch('/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  });

  const response = await request.text();

  if (response != "Fail") {
    localStorage.token = response;
    localStorage.email = data.email
    alert("login successful");
    console.log("Redirecting to users.html");
    window.location.href = 'users.html';
  } else {
    alert("Incorrect credentials");
  }
}
