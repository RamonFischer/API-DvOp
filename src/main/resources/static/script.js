const form = document.querySelector("form");

const Iname = document.querySelector(".name");
const Iemail = document.querySelector(".email");
const Ipassword = document.querySelector(".password");
const Itel = document.querySelector(".tel");

function register() {
    fetch("https://testfullapi.azurewebsites.net/post",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            name: Iname.value,
            email: Iemail.value,
            password: Ipassword.value,
            telephone: Itel.value
        })
    })
    .then(function (res) { console.log(res)})
    .catch(function (res) { console.log(res)})
};


function clean(){
    Iname.value = "";
    Iemail.value = "";
    Ipassword.value = "";
    Itel.value = "";
};

function deleteEmail() {
    const emailId = document.getElementById("deleteText").value;
    fetch('https://testfullapi.azurewebsites.net/delete' + emailId, {
        method: 'DELETE',
        mode: 'cors'
      })
      .then(res => res.text())
      .then(res => console.log(res))
      .then(clean())
      .then(alert('Deleted!'));
      
};

const el = document.getElementById("Delete");


el.addEventListener('click', function(event){
    event.preventDefault();

    deleteEmail();
    clean();
});


form.addEventListener('submit', function(event){
    event.preventDefault();
    try{
        register();
        alert('Registered!');
    }
    catch{
        alert('Illegal values!')
    }
    clean();
});