let user = {
    id: "1",
    name: "Aman",
    email: "example@mail.com",
    password: "JsExample123",
    isAuthorised: true,
};

window.addEventListener('load', function () {
    if (trySessionUser() === null) {
        showSplashScreen();
    } else {
        hideSplashScreen();
    }
})
function trySessionUser() {
    const userAsJSON = localStorage.getItem('user');
    return JSON.parse(userAsJSON);
}

class Post {
    constructor(id, userId, image, description) {
        this.id = id,
            this.userId = userId,
            this.image = image,
            this.description = description,
            this.likes = 0;
    }
}

class Comment {
    constructor(commentator, commentFor, comment, cEmail) {
        this.commentator = commentator,
            this.commentFor = commentFor,
            this.comment = comment,
            this.cEmail = cEmail
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
submit()



function updateRootPage() {
    console.log("LS USER: " + localStorage.getItem('user'));
    if (localStorage.getItem('user') == null){
    } else {
        fetchAuthorised('localhost:8092').then(res => {
            if (res.ok) {
                hideSplashScreen();
            } else {
                showSplashScreen();
            }
        });
    }
}

function restoreUser() {
    const userAsJSON = localStorage.getItem('user');
    return JSON.parse(userAsJSON);
}

function saveUserToStorage(user) {
      localStorage.setItem('user', JSON.stringify(user));
}
// function authOptions(options) {
//     const update = { ...options };
//     update.mode = 'cors';
//     update.headers = { ... options.headers };
//     update.headers['Content-Type'] = 'application/json';
//     const user = restoreUser();
//     if(user) {
//         update.headers['Authorization'] = 'Basic ' + btoa(user.username + ':' + user.password);
//     }
//     return update;
// }

function fetchAuthorised(url, options) {
    const settings = options || {}
    return fetch(url, authOptions(settings));
}
async function onLoginHandler(e) {
    e.preventDefault();
    const form = e.target;
    const userFormData = new FormData(form);
    const user = Object.fromEntries(userFormData);
    console.log(getUserFromStorage)
    await fetchAuthorised(BASE_URL + 'user/info', authOptions)
    saveUserToStorage(user);
    updateRootPage();
}

const BASE_URL = "http://localhost:8092";
function submit() {
    let bckSplash = document.getElementById('log-out')
    let submit = document.getElementsByClassName('post-form')[0]
    let btn = document.getElementsByClassName('login-in')[0];

    bckSplash.addEventListener('click', function () {
        localStorage.clear();
        window.location.href = 'localhost:8092';
    })

    btn.addEventListener('submit',function (e) {
            e.preventDefault();
            const form = e.target;
            const userFormData = new FormData(form);
            let user = Object.fromEntries(userFormData);
            const userAsJSON = JSON.stringify(user)
            saveUser(userAsJSON)
            updateRootPage();
           let i = document.getElementById('log-out');
           document.createElement('div')
        }
    );

    submit.addEventListener('submit', function (e){
        e.preventDefault();
        const form = e.target;
        const data = new FormData(form);
        console.log("sdf")
        createCommentElement(Object.fromEntries(data))
        submit.reset();
        fetch('https://localhost:8080/posts', {
            method: 'POST',
            cors: 'no-cors',
            body: data
        }).then(function(response) {
            return response.json();
        }).then(function(data) {
        });
    });
}

function eventListener(post) {
    let heart = post.getElementsByClassName('like1')[0];
    let bookmark = post.getElementsByClassName('fa-bookmark')[0];
    let img = post.getElementsByClassName('like-heart')[0];
    let like = post.getElementsByClassName('like')[0].hidden=true
    let com = post.getElementsByClassName('fa-comment')[0];
    let form = post.getElementsByClassName('com-upload-form')[0].getElementsByTagName('form')[0];
    let data = new FormData(form);
    let id= data.get("postId");



    com.addEventListener('click', function () {
        document.getElementById('comFor-' +id).hidden = document.getElementById('comFor-' + id).hidden === false;
    })


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

function creatPostElement(post) {

    let elem = document.createElement('div');
    elem.classList.add(post.id);
    elem.id=post.id
    elem.innerHTML =
        '<div id="1s" class="1s card my-2">' +
        '<div class="d-flex justify-content-around">'+
        '<div class="like-heart">'+
        `<img src="${post.url}" class=" card-img-top picture" alt="Picture Publication ">`+
        '<span class="h1 mx-2 text-danger like">'+
        '<i class="fas fa-heart"></i>'+
        ' </span>'+
        '</div>'+
        '</div>'+
        '<div class="px-4 py-3">'+
        '<div class="d-flex justify-content-around">'+
        '<span class="h1 mx-2 muted">'+
        '<i class="far fa-heart like1"></i>'+
        ' </span>'+
        '<span class="h1 mx-2 muted">' +
        '<i class="far fa-comment"></i>' +
        '</span>' +
        '<span class="mx-auto"></span>' +
        '<span class="h1 mx-2 muted">' +
        '<i class="far fa-bookmark"></i>' +
        '</span>' +
        '</div>' +
        '<hr>' +
        '<div class="com-upload-form" id="comFor-' + post.id+ '" + hidden>'+
        '<form class="com-form">' +
        '<input type="hidden" name="postId" value="' + post.id+ '">' +
        '<textarea placeholder="Comment" name="comment"> </textarea>' +
        '<br>' +
        '<button type="button" >comment</button>' +
        '</form>' +
        '</div>' +
        '<div class="titleText">' +
        // '<img className="img-fluid" src={post.url}/>'+
        '<p> ' + post.title + '</p>' +
        '</div>' +
        '<hr>' +
        '<div id="comments" class="com">' +
        '</div>' + '</div>'+
                        '</div>'+
                    '</div>'
    eventListener(elem);
    addEvListenerForCommentButton(elem.getElementsByClassName("com-form")[0]);
    getCommentsFromServer(post)


    return elem;
}


eventListener(document.getElementsByClassName('no-scroll')[0]);

function addComment(c) {
    document.getElementById('comFor-'+c.commentFor);
}

function createCommentElement(comment) {
    let elem = document.createElement('div');
    elem.innerHTML =
        '<div class="pb-3">'+comment.email+' :'+'</div>'+
        '<p>'+comment.body+'</p>'+
        '<hr>'

    return elem;
}

function addEvListenerForCommentButton(com) {
    let butt = com.getElementsByTagName('button')[0];
    butt.addEventListener('click', async function () {
        let data = new FormData(com);
        console.log("test")
        await fetch('https://jsonplaceholder.typicode.com/comments', {
            method: 'POST',
            body: data
        }).then(r => r.json()).then(data => console.log(data));
        let comment = new Comment(data.get("id"), data.get("postId"), data.get("body"), data.get("email"));
        addComment(createCommentElement(comment));
        document.getElementById('comFor-' + comment.commentFor).hidden = true;
        com.reset()
    });
}

async function getPostsFromServer() {
    let list = document.getElementsByClassName('posts-container')[0];
    let posts = await  fetch('https://jsonplaceholder.typicode.com/posts')
    let PostContent = await  posts.json()
    for (let i = 0; i <PostContent.length ; i++) {
        list.append(creatPostElement(PostContent[i]))
    }
}

async function getCommentsFromServer(post) {
         let CommentFF = await fetch('https://jsonplaceholder.typicode.com/comments');
         let contentComment = await CommentFF.json()
    for (let i = 0; i <contentComment.length ; i++) {
        if(post.id===contentComment[i].postId) {
            document.getElementById('comFor-' + post.id).append(createCommentElement(contentComment[i]))
        }
    }
}
getPostsFromServer()


