let user = {
    id: "1",
    name: "Aman",
    email: "example@mail.com",
    password: "JsExample123",
    isAuthorised: true,
};

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
function submit() {
    let bckSplash = document.getElementsByClassName('back')[0];
    let submit = document.getElementsByClassName('post-form')[0]
    let btn = document.getElementsByClassName('sing-in')[0];


    bckSplash.addEventListener('click',function () {
        showSplashScreen()
    })
    btn.addEventListener('click', function () {
        hideSplashScreen()
    });
    submit.addEventListener('submit', function (e){
        e.preventDefault();
        const form = e.target;
        const data = new FormData(form);
        console.log("sdf")
        addPostsFrom(Object.fromEntries(data))
        submit.reset();
        fetch('https://jsonplaceholder.typicode.com/posts', {
            method: 'POST',
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
        document.getElementById('comments-' +id).hidden = document.getElementById('comments-' + id).hidden === false;
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
    elem.classList.add('card');
    elem.classList.add('my-3');
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
        '<div class="com-upload-form" id="comments-' + post.id+ '" + hidden>' +
        '<form class="com-form">' +
        '<input type="hidden" name="postId" value="' + post.id+ '">' +
        '<textarea placeholder="Comment" name="comment"> </textarea>' +
        '<br>' +
        '<button type="button" >comment</button>' +
        '</form>' +
        '</div>' +
        '<div>' +
        '<p>' + post.title + '</p>' +
        '</div>' +
        '<hr>' +
        '<div id="comments" class="com">' +
        '</div>' + '</div>'+
                        '</div>'+
                    '</div>'
    eventListener(elem);
    addEvListenerToCommentButton(elem.getElementsByClassName("com-form")[0]);


    return elem;
}

function addPost(postElem) {
    document.getElementsByClassName('posts-container')[0].append(postElem);
}

eventListener(document.getElementsByClassName('no-scroll')[0]);


function addPostsFrom(data) {
    let i = data.length;
    for (let j = 0; j < i; j++) {
        let p = new Post(data[j].id, data[j].user, data[j].url, data[j].title);
        addPost(creatPostElement(p));
    }
}

// let comment = document.getElementById('com-form');
// addEvListenerToCommentButton(comment);

function addComment(commentElem) {
    document.getElementsByClassName("com-upload-form")[0].append(commentElem);
}

// function addCommentsFrom(data) {
//     let i = data.length;
//     for(let j = 0; j < i; j++) {
//         let a = new Comment(data[j].commentator, data[j].commentFor, data[j].comment);
//         addComment(createCommentElement(a));
//     }
// }

function createCommentElement(comment) {
    let elem = document.createElement('div');
    elem.innerHTML =
        '<p>'+comment.body+'</p>'
    return elem;
}

function addEvListenerToCommentButton(fo) {
    let butt = fo.getElementsByTagName('button')[0];
    butt.addEventListener('click', async function () {
        let data = new FormData(fo);
        console.log("test")
        await fetch('https://jsonplaceholder.typicode.com/comments', {
            method: 'POST',
            body: data
        }).then(r => r.json()).then(data => console.log(data));
        let c = new Comment(data.get("userId"), data.get("postId"), data.get("comment"), data.get("userEmail"));
        addComment(createCommentElement(c));
        document.getElementById('comments-' + c.commentFor).hidden = true;
        // window.location.href = BASE_URL;
    });
}

//     let comments = document.getElementById('comments');
// async function getComments() {
//     let response = await  fetch('https://jsonplaceholder.typicode.com/comments')
//     let content = await  response.json();
//      for (let i = 0; i <content.length ; i++) {
//          comments.append(createCommentElement(content[i]));
//     }
// }
        let list = document.getElementsByClassName('posts-container')[0];
async function getPosts() {

    let posts = await  fetch('https://jsonplaceholder.typicode.com/posts')
    let PostContent = await  posts.json()
    for (let i = 0; i <PostContent.length ; i++) {
        list.append(creatPostElement(PostContent[i]))
        // console.log(list.append(comments))
    }

}
getPosts()
// getComments();