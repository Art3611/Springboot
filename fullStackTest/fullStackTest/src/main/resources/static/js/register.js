$(document).ready(function() {
   //on ready
});

async function registerUser() {

  let data = {};
  data.name = document.getElementById('txtName').value;
  data.surname = document.getElementById('txtSurname').value;
  data.email = document.getElementById('txtEmail').value;
  data.password = document.getElementById('txtPassword').value;
  let repeatPass = document.getElementById('txtRepeatPassword').value;

    if(repeatPass != data.password){
    alert('Password is incorrect')
    return;
}
  const request = await fetch('/users', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },

    body: JSON.stringify(data)

  });



}