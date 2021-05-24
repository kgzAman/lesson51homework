let user = {
    id: "1",
    name: "Aman",
    email: "example@mail.com",
    password: "JsExample123",
    isAuthorised: true,
};

class Post {
    constructor(image, description,) {
            this.id = id,
            this.userId = userId,
            this.image = image,
            this.description = description;
            this.likes = 0;
    }
};

class Comment {
    constructor(userComent, commentFor, comment, cEmail) {
            this.userComent = userComent
            this.commentFor = commentFor
            this.comment = comment
            this.cEmail = cEmail;
    }
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

function eventListener(post) {
    let heart = post.getElementsByClassName('like1')[0];
    let bookmark = post.getElementsByClassName('fa-bookmark')[0];
    let img = post.getElementsByClassName('like-heart')[0];
    let btn = post.getElementsByClassName('sing-in')[0];
    let bckSplash = post.getElementsByClassName('back')[0];
    let submit = post.getElementsByClassName('post-form')[0];
    let like = post.getElementsByClassName('like')[0].hidden=true
    let com = post.getElementsByClassName('fa-comment')[0];
    let addCommit = post.getElementsByClassName('btnSub')[0];



    addCommit.addEventListener('submit', function (e) {
        e.preventDefault();

    })


    submit.addEventListener('submit', function (e){
        e.preventDefault();
        const form = e.target;
        const data = new FormData(form);
        console.log("sdf")
        console.log(Object.fromEntries(data))
        addPostsFrom(data)
    });

    com.addEventListener('click', function () {
            document.getElementsByClassName('comnt')[0].hidden = document.getElementsByClassName('comnt')[0].hidden === false;
    })

    bckSplash.addEventListener('click',function () {
          showSplashScreen()
    })

    btn.addEventListener('click', function () {
        hideSplashScreen()
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
    document.getElementsByClassName("container")[0].style.visibility = "hidden";
    document.getElementsByClassName("splash-Screen")[0].style.visibility= null ;
}

function hideSplashScreen() {
    document.getElementsByClassName("container")[0].style.visibility =  null;
    document.getElementsByClassName("splash-Screen")[0].style.visibility= "hidden";
}

function getId(data) {
    return data.id;
}

function getEmail(data) {
    return data.email;
}

function addPostsFrom(data) {
    let i = data.length;
    for (let j = 0; j < i; j++) {
        let p = new Post(data[j].id, data[j].user, data[j].image, data[j].description);
        addPost(creatPostElement(p));
    }
}

function createCommentElement(comment) {
    let elem = document.createElement('div');
    elem.innerHTML = `<a href="#" class="muted"> comment.cEmail</a>
        <p>comment.comment </p> 
        <input name="forPost" type="hidden" value="' + comment.commentFor + '">`;
    return elem;
}

function creatPostElement(post) {
    let elem = document.createElement('div');
    elem.innerHTML =
        `<div id="1s" class="1s card my-2">
                        <div class="d-flex justify-content-around">
                                <div class="like-heart">
    <img src="${post.image}" class=" card-img-top picture" alt="Picture Publication ">                                    <span class="h1 mx-2 text-danger like">
                                      <i class="fas fa-heart"></i>
                                    </span>
                                </div>
                        </div>
                        <div class="px-4 py-3">

                            <div class="d-flex justify-content-around">
                        <span class="h1 mx-2 muted">
                          <i class="far fa-heart like1"></i>
                        </span>
                                <span class="h1 mx-2 muted">
                          <i class="far fa-comment"></i>
                        </span>
                                <span class="mx-auto"></span>
                                <span class="h1 mx-2 muted">
                          <i class="far fa-bookmark"></i>
                        </span>
                            </div>
                        </div>
                    </div>`
    eventListener(elem)
    return elem;
}

function addPost(postElem) {
    document.getElementsByClassName('posts-container')[0].append(postElem);
}

eventListener(document.getElementsByClassName('no-scroll')[0]);

