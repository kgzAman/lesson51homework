let user = {
    id: "1",
    name: "Aman",
    email: "example@mail.com",
    password: "JsExample123",
    isAuthorised: true,
};

function Pub(id,picture ) {
    this.id = id;
    this.picture = picture;
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
let like = document.getElementsByClassName('like')[0].hidden=true

function eventListener() {
    let heart = document.getElementsByClassName('like1')[0];
    let bookmark = document.getElementsByClassName('fa-bookmark')[0];
    let img = document.getElementsByClassName('like-heart')[0];

    const btn = document.getElementsByClassName('btn')[0];
    const bckSplsh = document.getElementsByClassName('bts')[0];


    bckSplsh.addEventListener('click',function () {
            hideSplashScreen();
    })
    btn.addEventListener('click', function () {
        showSplashScreen();
    });

    img.addEventListener('dblclick', function () {
     like = document.getElementsByClassName('like')[0].hidden=false;
        setTimeout(() => (
            like = document.getElementsByClassName('like')[0].hidden=true), 500)
        heart.classList.add('text-danger');
        heart.classList.add('fas');
        heart.classList.remove('far');
    })
    ;

    bookmark.addEventListener('click', function () {
        if (bookmark.classList.contains('fas')) {
            bookmark.classList.remove('fas');
            bookmark.classList.add('far');
        } else {
            bookmark.classList.remove('far');
            bookmark.classList.add('fas');
        }
    })

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


function showSplashScreen() {
    document.getElementsByClassName("container")[0].style.visibility = null;
    document.getElementsByClassName("splash-Screen")[0].style.visibility= "hidden" ;
}


function hideSplashScreen() {
    document.getElementsByClassName("container")[0].style.visibility =  "hidden";
    document.getElementsByClassName("splash-Screen")[0].style.visibility= null;
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
        <img src="${publication.picture}" class=" card-img-top picture" alt="Picture Publication ">   
        </div>`
    eventListener();
    return elem;
}

function addPost(posts) {
    // let posts = new Pub(1,"../img/1087200.png")
    document.getElementsByClassName('posts-container')[0].append(creatPostElement(posts));
}

function Post(post) {
    for (let i = 0; i < 1; i++) {
        addPost(post)
    }
}
eventListener();

