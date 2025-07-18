
$(document).ready(function() {
  loadUsers();

});

async function loadUsers() {
  const request = await fetch('users', {
    method: 'GET',
    headers: getHeaders()
  });

  const users = await request.json();


  let listHtml = "";
  for (let user of users) {
    let phone = user.phone == null ? '-' : user.phone;
    let deleteButon = '<a href="#" onclick="deleteUser('+user.id+')"class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'
    let userhtml = '<tr><td>123</td><td>' + user.name + '</td><td>' + user.email + '</td><td>' + phone + '</td><td>'+deleteButon+'</td></tr>';
    listHtml += userhtml;
  }

  document.querySelector('#users tbody').innerHTML = listHtml;



$('#users').DataTable();

}
function getHeaders(){
 headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization' : localStorage.token
    };

}


async function deleteUser(id){

if (!confirm('Desea eliminar este usuario?')){
return;
}
    const request = await fetch('user/'+ id, {
    method: 'DELETE',
    headers: getHeaders()
  });

location.reload()

}