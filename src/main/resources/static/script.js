let user ={
    id:"1",
    name: "Aman",
    email: "example@mail.com",
    password:"JsExample123",
    isAuthorised: true,
};

let publication={
    id:"1",
    Picture:"/picture.img" ,
    description :"Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    date:"15.12.15",
    User :user,
    Like : likes=[],
    Comment: comment=[],
    // создал обьект user в к класс publication
}
let comment = {
    id: "1",
    description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    date:"01.12.16",
    // добавил обект comment в к класс publication
}

let Like ={
    id:"1",
    date:"",
}

let publications = [];

function addPublication(publication) {
    publications.push(publication);
}

function isNotAuthorised(user) {
    user.isAuthorised=false;
}

function addLike(id) {
    let pub1 = publications[id];
   pub1.push(Like)
}

function removeLike(id) {
    publications[id].pop();
}

function showSplashScreen() {
    document.getElementById('splash-screen').hidden = true;
    document.body.classList.add('no-scroll');
};

function hideSplashScreen() {
    document.getElementById('splash-screen').hidden = false;
    document.body.classList.remove('no-scroll');
};

function createCommentElement(comment) {
    let elem = document.createElement('div');
    elem.innerHTML = comment;
    return  elem.innerHTML ;
};


