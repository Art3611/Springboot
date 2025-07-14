// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadUsers();
});

async function loadUsers() {
  const request = await fetch('users', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const users = await request.json();


  let listHtml = "";
  for (let user of users) {
    let deleteButon = '<a href="#" onclick="deleteUser('+user.id+')"class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'
    let userhtml = '<tr><td>123</td><td>' + user.name + '</td><td>' + user.email + '</td><td>' + user.phone + '</td><td>'+deleteButon+'</td></tr>';
    listHtml += userhtml;
  }

  document.querySelector('#users tbody').innerHTML = listHtml;

  // Inicializa DataTables después de insertar los datos
  $('#users').DataTable();


}

async function deleteUser(id){

if (!onfirm('Desea eliminar este usuario?')){
return;
}
    const request = await fetch('user/'+ id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

location.reload()

}