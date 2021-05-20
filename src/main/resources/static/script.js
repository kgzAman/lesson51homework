let user = {
    id: "1",
    name: "Aman",
    email: "example@mail.com",
    password: "JsExample123",
    isAuthorised: true,
};

class Publication {
    constructor(id, Picture) {
        this.id = id;
        this.Picture = Picture;
    }

    // description :"Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    // date:"15.12.15",
    // User :user,
    // Like : likes=[],
    // Comment: comment=[],
    // создал обьект user в к класс publication
}

let comment = {
    id: "1",
    description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    date: "01.12.16",
    // добавил обект comment в к класс publication
}
let Like = {
    id: "1",
    date: "",
}

let publications = [];

function addPublication(publication) {
    publications.push(publication);
}

function isNotAuthorised(user) {
    user.isAuthorised = false;
}

function addLike() {
    let heart = document.getElementsByClassName('fa-heart')[0];
    heart.addEventListener('click',function () {
        if (heart.classList.contains('fas')) {
            heart.classList.remove('fas');
            heart.classList.remove('text-danger');
            heart.classList.add('far');
        } else {
            heart.classList.remove('far');
            heart.classList.add('text-danger');
            heart.classList.add('fas');
        }
    })
}

function removeLike(id) {
    publications[id].pop();
}

function showSplashScreen() {
    document.getElementById('splashScreen').hidden = true;
    document.body.classList.add('no-scroll');
}

function hideSplashScreen() {
    document.getElementById('splashScreen').hidden = false;
    document.body.classList.remove('no-scroll');
}

function createCommentElement(comment) {
    let elem = document.createElement('div');
    elem.innerHTML = comment;
    return elem.innerHTML;
}

function creatPostElement(publication) {
    let elem = document.createElement('div');
    elem.innerHTML =
        `<div class="row justify-content-center">
        <div class="col col-lg-7 posts-container" id="posts-cont">
            <div id="1s" class="1s card my-3">
        <img src="${publication.image}" class=" card-img-top picture" alt="Picture Publication ">
           
        </div>`
    return elem;
}

function addPost() {
    let posts = new Publication(1, "../img/1087200.png")
    document.getElementsByClassName('posts-container')[0].append(creatPostElement(posts));
}

function Post() {
    for (let i = 0; i < 1; i++) {
        addPost()
    }
}
addLike();





